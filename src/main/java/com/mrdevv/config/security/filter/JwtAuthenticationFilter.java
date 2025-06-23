package com.mrdevv.config.security.filter;

import com.mrdevv.exception.ObjectNotFoundException;
import com.mrdevv.service.IUsuarioService;
import com.mrdevv.service.auth.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private JwtService jwtService;
    private IUsuarioService usuarioService;

    @Autowired
    public JwtAuthenticationFilter(JwtService jwtService, IUsuarioService usuarioService){
        this.jwtService = jwtService;
        this.usuarioService = usuarioService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String autherizationHeader = request.getHeader("Authorization");

        if (StringUtils.hasText(autherizationHeader) && autherizationHeader.startsWith("Bearer ") &&
                (request.getRequestURI().contains("login") || request.getRequestURI().contains("create-usuario"))
        ){
            filterChain.doFilter(request, response);
            return;
        }

        if (!StringUtils.hasText(autherizationHeader) || !autherizationHeader.startsWith("Bearer ") ){
            filterChain.doFilter(request, response);
            return;
        }

        String jwt = autherizationHeader.split(" ")[1];

        String userEmail = jwtService.extractUserEmail(jwt);

        UserDetails userDetails = usuarioService.findByEmail(userEmail)
                .orElseThrow(() -> new ObjectNotFoundException(
                        "El email " + userEmail + "  no se encontró en la base de datos.",
                        "El email no está asociado a ninguna cuenta."
                ));

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                userEmail, null, userDetails.getAuthorities()
        );

        authenticationToken.setDetails(new WebAuthenticationDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        filterChain.doFilter(request, response);
    }
}
