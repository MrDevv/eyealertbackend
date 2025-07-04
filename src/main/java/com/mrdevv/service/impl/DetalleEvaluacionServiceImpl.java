package com.mrdevv.service.impl;

import com.mrdevv.exception.ObjectNotPermissions;
import com.mrdevv.model.DetalleEvaluacion;
import com.mrdevv.payload.dto.detalleEvaluacion.CreateDetailEvaluationDTO;
import com.mrdevv.payload.dto.detalleEvaluacion.ResponseDetalleEvaluacionDTO;
import com.mrdevv.payload.mapper.DetalleEvaluacionMapper;
import com.mrdevv.repository.DetalleEvaluacionRepository;
import com.mrdevv.service.IDetalleEvaluacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DetalleEvaluacionServiceImpl implements IDetalleEvaluacionService {

    private DetalleEvaluacionRepository detalleEvaluacionRepository;

    @Autowired
    public DetalleEvaluacionServiceImpl(DetalleEvaluacionRepository detalleEvaluacionRepository){
        this.detalleEvaluacionRepository = detalleEvaluacionRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public ResponseDetalleEvaluacionDTO getDetalleEvaluacion(Long evaluacionId) {
        List<Object[]> detalleEvaluaciones =  detalleEvaluacionRepository.findDetalleEvaluacion(evaluacionId);
        String email = detalleEvaluaciones.get(0)[10].toString();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        List<String> roles = authentication.getAuthorities().stream().map(rol -> rol.getAuthority()).toList();
        String emailUserAuthenticated = authentication.getPrincipal().toString();

        if(roles.contains("ROLE_administrador")){
            return DetalleEvaluacionMapper.toDetalleEvaluacionDTO(detalleEvaluaciones);
        }else if(roles.contains("ROLE_usuario") && email.equalsIgnoreCase(emailUserAuthenticated)){
            return DetalleEvaluacionMapper.toDetalleEvaluacionDTO(detalleEvaluaciones);
        }

        throw new ObjectNotPermissions(
                "El rol [ROLE_usuario] no tiene autorización para acceder al recurso de otro usuario",
                "No tiene permisos suficientes para acceder al detalle de esta evaluación");
    }

    @Transactional
    @Override
    public void saveDetalleEvaluacion(CreateDetailEvaluationDTO detailEvaluation, Long evaluacionId) {
        DetalleEvaluacion detalleEvaluacion = DetalleEvaluacionMapper.toDetalleEvaluacionEntity(detailEvaluation, evaluacionId);
        detalleEvaluacionRepository.save(detalleEvaluacion);
    }
}
