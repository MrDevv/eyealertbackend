package com.mrdevv.service.impl;

import com.mrdevv.model.Quizz;
import com.mrdevv.payload.dto.ResponseWithPageable;
import com.mrdevv.payload.dto.quizz.CreateQuizzDTO;
import com.mrdevv.payload.dto.quizz.ResponsePuntajeUsuario;
import com.mrdevv.payload.dto.quizz.ResponseQuizzDTO;
import com.mrdevv.payload.dto.quizz.ResponseRankingDTO;
import com.mrdevv.payload.mapper.QuizzMapper;
import com.mrdevv.repository.QuizzRepository;
import com.mrdevv.service.IQuizzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QuizzServiceImpl implements IQuizzService {

    private QuizzRepository quizzesRespository;

    @Autowired
    public QuizzServiceImpl(QuizzRepository quizzesRespository){
        this.quizzesRespository = quizzesRespository;
    }

    @Transactional(readOnly = true)
    @Override
    public ResponseWithPageable listarQuizzes(Pageable pageable) {
        Page<Quizz> quizzes = quizzesRespository.findAll(pageable);
        return QuizzMapper.toQuizzDTO(quizzes);
    }

    @Transactional(readOnly = true)
    @Override
    public ResponsePuntajeUsuario obtenerPuntajeUsuario(Long usuarioId) {
        Object puntajeUsuario = quizzesRespository.obtenerPuntajeQuizzesUsuario(usuarioId);
        return QuizzMapper.toPuntajeUsuarioDTO(puntajeUsuario);
    }

    @Transactional(readOnly = true)
    @Override
    public ResponseRankingDTO obtenerRanking() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getPrincipal().toString();

        List<Object> ranking = quizzesRespository.obtenerRankingLimit5();
        Object puestoActualUsuario = quizzesRespository.obtenerPuestoActualUsuario(email);
        return QuizzMapper.toRankingDTOList(ranking, puestoActualUsuario);
    }

    @Override
    public ResponseQuizzDTO crearQuizz(CreateQuizzDTO quizzDTO) {
        Quizz quizz = quizzesRespository.save(QuizzMapper.toQuizzEntity(quizzDTO));
        return QuizzMapper.toQuizzDTO(quizz);
    }
}
