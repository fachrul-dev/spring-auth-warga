package com.restapi.warga.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DataResponse<T> {
    private boolean success;
    private String message;
    private T data;

}
