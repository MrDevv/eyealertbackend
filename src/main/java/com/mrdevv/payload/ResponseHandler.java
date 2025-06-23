package com.mrdevv.payload;

import com.mrdevv.payload.dto.PageableData;
import com.mrdevv.utils.TipoResponse;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.LinkedHashMap;
import java.util.Map;

public class ResponseHandler {

    public static ResponseEntity<Object> get(TipoResponse tipoResponse, String mensaje, Object data){
        Map<String, Object> response = new LinkedHashMap();

        response.put("status", "Ok");
        response.put("code", tipoResponse.getStatus());
        response.put("message", mensaje);
        response.put("data", data);

        return ResponseEntity.status(tipoResponse.getStatus()).body(response);
    }

    public static ResponseEntity<Object> getWithPageable(TipoResponse tipoResponse, String mensaje, Page data){
        PageableData pageableData = getDataPageable(data);
        Map<String, Object> response = new LinkedHashMap();

        response.put("status", "Ok");
        response.put("code", tipoResponse.getStatus());
        response.put("message", mensaje);
        response.put("data", data.getContent());
        response.put("data_pageable", pageableData);

        return ResponseEntity.status(tipoResponse.getStatus()).body(response);

    }

    private static PageableData getDataPageable(Page data){
        return new PageableData(
                data.getPageable().getPageNumber(),
                data.isLast(),
                data.isFirst(),
                data.getTotalPages(),
                data.getTotalElements(),
                data.getNumberOfElements()
        );
    }

}
