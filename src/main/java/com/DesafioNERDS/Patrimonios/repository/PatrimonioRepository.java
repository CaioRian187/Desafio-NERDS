package com.DesafioNERDS.Patrimonios.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DesafioNERDS.Patrimonios.models.Patrimonio;

public interface PatrimonioRepository extends JpaRepository<Patrimonio, Long>{
    Optional<Patrimonio> findByNome(String nome);

    boolean existsByNumeroSerie(String numeroSerie);
}
