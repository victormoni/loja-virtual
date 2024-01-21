package com.dev.backend.controller;

import org.springframework.web.bind.annotation.RestController;

import com.dev.backend.entity.Marca;
import com.dev.backend.service.MarcaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/marca")
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    @GetMapping("/")
    public List<Marca> buscarTodos() {
        return marcaService.buscarTodos();
    }

    @PostMapping("/")
    public Marca inserir(@RequestBody Marca marca) {
        return marcaService.inserir(marca);
    }

    @PutMapping("/")
    public Marca alterar(@RequestBody Marca marca) {
        return marcaService.alterar(marca);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
        marcaService.excluir(id);
        return ResponseEntity.ok().build();

    }
}
