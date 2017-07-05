package com.igorhara.example.web.dto;

public interface DTO<T> {
    DTO<T> populateDTO(T t);
}
