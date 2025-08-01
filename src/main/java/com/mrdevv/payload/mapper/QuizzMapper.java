package com.mrdevv.payload.mapper;

import com.mrdevv.model.Quizz;
import com.mrdevv.model.Usuario;
import com.mrdevv.payload.dto.PageableData;
import com.mrdevv.payload.dto.ResponseWithPageable;
import com.mrdevv.payload.dto.quizz.*;
import org.springframework.data.domain.Page;

import java.util.List;

public class QuizzMapper {

    public static ResponseWithPageable toQuizzDTO(Page<Quizz> quizzes){

        PageableData pageableData = PageableMapper.toPageableData(quizzes);

        List<ResponseQuizzDTO> responseQuizzes = quizzes.stream().map(quizz -> {
            return new ResponseQuizzDTO(
                    quizz.getQuizzId(),
                    quizz.getPuntaje(),
                    quizz.getFecha(),
                    UsuarioMapper.toUsuarioSimpleDTO(quizz.getUsuario())
            );
        }).toList();

        return new ResponseWithPageable(responseQuizzes, pageableData);
    }

    public static ResponseQuizzDTO toQuizzDTO(Quizz quizz){
        return new ResponseQuizzDTO(
                quizz.getQuizzId(),
                quizz.getPuntaje(),
                quizz.getFecha(),
                UsuarioMapper.toUsuarioSimpleDTO(quizz.getUsuario()));
    }

    public static Quizz toQuizzEntity(CreateQuizzDTO createQuizzDTO){
        return Quizz.builder()
                .puntaje(createQuizzDTO.puntaje())
                .usuario(Usuario.builder().id(createQuizzDTO.usuarioId()).build())
                .build();
    }

    public static ResponsePuntajeUsuario toPuntajeUsuarioDTO(Object puntajeUsuario){
        Object[] puntaje = (Object[]) puntajeUsuario;

        if (puntaje[0] == null){
            return null;
        }

        Integer puntajeMasAlto = ((Number) puntaje[0]).intValue();
        Integer ultimoPuntaje = ((Number) puntaje[1]).intValue();

        return new ResponsePuntajeUsuario(puntajeMasAlto, ultimoPuntaje);
    }

    public static ResponseRankingDTO toRankingDTOList(List<Object> quizzList, Object puestoUsuario){

        if (quizzList.isEmpty()){
            return null;
        }

        List<PuestoUsuarioDTO> rankingList = quizzList.stream().map(quizz -> {
            Object[] result = (Object[]) quizz;

            Integer puesto = ((Number) result[0]).intValue();
            Integer usuarioId = ((Number) result[1]).intValue();
            String nombres = result[2].toString().split(" ")[0];
            String apellidos = result[3].toString().split(" ")[0];
            Integer puntaje = ((Number) result[4]).intValue();

            return new PuestoUsuarioDTO(
                    puesto,
                    usuarioId,
                    nombres + " " + apellidos,
                    puntaje
            );
        }).toList();

        Object[] puestoUsuarioResp = (Object[]) puestoUsuario;

        if (puestoUsuarioResp == null){
            return new ResponseRankingDTO(rankingList, null);
        }

        Integer puesto = ((Number) puestoUsuarioResp[0]).intValue();
        Integer usuarioId = ((Number) puestoUsuarioResp[1]).intValue();
        String nombres = puestoUsuarioResp[2].toString().split(" ")[0];
        String apellidos = puestoUsuarioResp[3].toString().split(" ")[0];

        PuestoUsuarioDTO puestoUsuarioCurrent = new PuestoUsuarioDTO(puesto, usuarioId, nombres + " " + apellidos, null);

        return new ResponseRankingDTO(rankingList, puestoUsuarioCurrent);
    }
}
