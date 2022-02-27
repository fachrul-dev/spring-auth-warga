package com.restapi.warga.repository;

import com.restapi.warga.entities.Warga;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WargaRepository extends JpaRepository<Warga, Integer> {
//    List<Warga> findByNameContains(String nama);
}

