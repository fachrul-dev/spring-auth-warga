package com.restapi.warga.controller;

import com.restapi.warga.dto.request.DataRequest;
import com.restapi.warga.dto.response.DataResponse;
import com.restapi.warga.dto.response.ListDataResponse;
import com.restapi.warga.entities.Warga;
import com.restapi.warga.services.WargaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class WargaController {

    @Autowired
    private WargaService wargaService;

    @PostMapping("/save/warga")
    public ResponseEntity<?> save(@RequestBody  DataRequest request , @RequestHeader("Authorization") String auth) {
    DataResponse dataResponse =wargaService.saveData(request);
    return ResponseEntity.ok().body(dataResponse);
    }



    @GetMapping("/getalldata")
    public ResponseEntity<?> get(@RequestHeader("Authorization") String auth) {

        try {
            List<Warga> list = wargaService.getAllData();
            return ResponseEntity.ok().body(DataResponse.builder()
                    .success(true)
                    .message("successfully")
                    .data(ListDataResponse.builder().Warga(list).Total(list.size()).build())
                    .build());

        } catch (Exception e) {
          return ResponseEntity.badRequest().body(DataResponse.builder()
                    .success(false)
                    .message("Authorization Invalid")
                    .data(null)
                    .build());
        }

    }

//Get by 1
    @GetMapping("/{id}")
    public Warga findOne(@PathVariable("id") Integer id , @RequestHeader("Authorization") String auth) {
        return wargaService.findOne(id);
    }


    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id, @RequestHeader("Authorization") String auth) {
         wargaService.removeData(id);
    }
}
