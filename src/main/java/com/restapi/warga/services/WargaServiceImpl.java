package com.restapi.warga.services;

import com.restapi.warga.dto.request.DataRequest;
import com.restapi.warga.dto.response.DataResponse;
import com.restapi.warga.dto.response.ListDataResponse;
import com.restapi.warga.entities.Warga;
import com.restapi.warga.repository.WargaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class WargaServiceImpl implements WargaService {
    @Autowired
    private WargaRepository wargaRepository;

    @Override
    public DataResponse saveData(DataRequest request) {

        try {
            Warga warga1 =wargaRepository.save(Warga.builder()
                    .nama(request.getNama())
                    .pekerjaan(request.getPekerjaan())
                    .build());
            return DataResponse.builder()
                    .success(true)
                    .message("Success")
                    .data(ListDataResponse.builder().Warga(warga1).build())
                    .build();
        } catch (Exception e) {
            return DataResponse.builder()
                    .success(false)
                    .message("Authorization Invalid")
                    .data(null)
                    .build();
        }


//
    }

    @Override
    public List<Warga> getAllData() {
        List<Warga> list = wargaRepository.findAll();
        return list;

    }


    public Warga findOne(Integer id) {
        return wargaRepository.findById(id).get();
    }

    public void removeData(Integer id){
        wargaRepository.deleteById(id);
    }



}
