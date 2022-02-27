package com.restapi.warga.dto.response;

import com.restapi.warga.dto.request.DataRequest;
import com.restapi.warga.entities.Warga;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ListDataResponse<T> {
    private T Warga;
    private Integer Total;
}
