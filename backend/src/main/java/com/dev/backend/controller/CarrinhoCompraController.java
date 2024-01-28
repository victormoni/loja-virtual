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

import com.dev.backend.entity.CarrinhoCompra;
import com.dev.backend.service.CarrinhoCompraService;

@RestController
@RequestMapping("/api/carrinhoCompra")
public class CarrinhoCompraController {

    @Autowired
    private CarrinhoCompraService carrinhoCompraService;

    @GetMapping("/")
    public List<CarrinhoCompra> buscarTodos() {
        return carrinhoCompraService.buscarTodos();
    }

    @PostMapping("/")
    public CarrinhoCompra inserir(@RequestBody CarrinhoCompra obj) {
        return carrinhoCompraService.inserir(obj);
    }

    @PutMapping("/")
    public CarrinhoCompra alterar(@RequestBody CarrinhoCompra obj) {
        return carrinhoCompraService.alterar(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        carrinhoCompraService.excluir(id);
        return ResponseEntity.ok().build();
    }
}