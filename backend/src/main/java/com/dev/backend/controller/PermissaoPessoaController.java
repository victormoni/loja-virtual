package com.dev.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.backend.entity.PermissaoPessoa;
import com.dev.backend.service.PermissaoPessoaService;

@RestController
@RequestMapping("/api/permissaoPessoa")
public class PermissaoPessoaController {

    @Autowired
    private PermissaoPessoaService permissaoPessoaService;

    @GetMapping("/")
    public List<PermissaoPessoa> buscarTodos() {
        return permissaoPessoaService.buscarTodos();
    }

    @PostMapping("/")
    public PermissaoPessoa inserir(@RequestBody PermissaoPessoa obj) {
        return permissaoPessoaService.inserir(obj);
    }

    @PutMapping("/")
    public PermissaoPessoa alterar(@RequestBody PermissaoPessoa obj) {
        return permissaoPessoaService.alterar(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        permissaoPessoaService.excluir(id);
        return ResponseEntity.ok().build();
    }
}