package com.DesafioNERDS.Patrimonios.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.DesafioNERDS.Patrimonios.models.Patrimonio;
import com.DesafioNERDS.Patrimonios.service.PatrimonioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/patrimonio")
@Validated
public class PatrimonioController {

    @Autowired
    private PatrimonioService patrimonioService;
    
    @GetMapping("/{id}")
    public ResponseEntity<Patrimonio> findById(@PathVariable Long id){
        Patrimonio patrimonio = this.patrimonioService.findById(id);
        return ResponseEntity.ok().body(patrimonio);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<Patrimonio> findByNome(@Valid @PathVariable String nome){
        Patrimonio patrimonio = this.patrimonioService.findByNome(nome);
        return ResponseEntity.ok().body(patrimonio);
    }

    @GetMapping
    public ResponseEntity<List<Patrimonio>> findAll(){
        List<Patrimonio> list = this.patrimonioService.findAllPatrimonios();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Void> createPatrimonio(@Valid @RequestBody Patrimonio patrimonio){
        this.patrimonioService.createPatrimonio(patrimonio);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(patrimonio.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePatrimonio(@Valid @RequestBody Patrimonio patrimonio, @PathVariable Long id){
        patrimonio.setId(id);
        patrimonio = this.patrimonioService.updatePatrimonio(patrimonio);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatrimonio(@PathVariable Long id){
        this.patrimonioService.deletePatrimonio(id);
        return ResponseEntity.noContent().build();
    }
}
