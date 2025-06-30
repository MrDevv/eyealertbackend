package com.mrdevv.payload.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.domain.Pageable;

public record ResponseWithPageable<T>(
        @JsonProperty("content")
        T data,
        PageableData pageable
) {
}
