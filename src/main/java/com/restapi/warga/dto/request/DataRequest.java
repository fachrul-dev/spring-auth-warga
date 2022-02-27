package com.restapi.warga.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DataRequest {
    private String nama;
    private String pekerjaan;
    private String profesi;
}
