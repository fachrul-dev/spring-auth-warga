package com.restapi.warga.services;

import com.restapi.warga.dto.request.DataRequest;
import com.restapi.warga.dto.response.DataResponse;
import com.restapi.warga.entities.Warga;

import java.util.List;

public interface WargaService {

    DataResponse saveData(DataRequest request);

    List<Warga> getAllData();

    Warga findOne(Integer id);

    void removeData(Integer id);
}
