package com.mrdevv.payload;

import com.mrdevv.payload.dto.PageableData;
import com.mrdevv.payload.dto.ResponseWithPageable;
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

}
