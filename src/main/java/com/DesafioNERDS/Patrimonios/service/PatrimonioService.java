package com.DesafioNERDS.Patrimonios.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DesafioNERDS.Patrimonios.exceptions.DuplicateException;
import com.DesafioNERDS.Patrimonios.exceptions.NotFoundException;
import com.DesafioNERDS.Patrimonios.models.Patrimonio;
import com.DesafioNERDS.Patrimonios.repository.PatrimonioRepository;

import jakarta.transaction.Transactional;

@Service
public class PatrimonioService {
    @Autowired
    private PatrimonioRepository patrimonioRepository;

    public Patrimonio findById(Long id){
        Optional<Patrimonio> patrimonio = this.patrimonioRepository.findById(id);
        return patrimonio.orElseThrow( () -> new NotFoundException("Patrimônio de id = " + id + " não encontrado"));
    }

    public Patrimonio findByNome(String nome){
      return patrimonioRepository.findByNome(nome).orElseThrow( () -> new NotFoundException("Patrimônio de nome " + nome + " não encontrado"));
    }

    public List<Patrimonio> findAllPatrimonios(){
        List<Patrimonio> list = this.patrimonioRepository.findAll();
        if (list.isEmpty()){
            throw new NotFoundException("Nenhum patrimônio encontrado");
        }
        return list;
    }

    @Transactional
    public void createPatrimonio(Patrimonio patrimonio){
        if (patrimonioRepository.existsByNumeroSerie(patrimonio.getNumeroSerie())){
            throw new DuplicateException("Já existe um patrimônio cadastrato com o número de série: " + patrimonio.getNumeroSerie());
        }

        this.patrimonioRepository.save(patrimonio);
    }

    @Transactional
    public Patrimonio updatePatrimonio(Patrimonio patrimonio){
        Patrimonio newPatrimonio = findById(patrimonio.getId());

        newPatrimonio.setNome(patrimonio.getNome());
        newPatrimonio.setTipo(patrimonio.getTipo());
        newPatrimonio.setNumeroSerie(patrimonio.getNumeroSerie());

        return this.patrimonioRepository.save(newPatrimonio);
    }

    public void deletePatrimonio(Long id){
        findById(id);
        this.patrimonioRepository.deleteById(id);
    }

}
