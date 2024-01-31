package com.dev.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.backend.dto.ClienteRequestDTO;
import com.dev.backend.entity.Pessoa;
import com.dev.backend.service.PessoaService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping("/")
    public Pessoa inserir(@RequestBody ClienteRequestDTO clienteRequestDTO) {
        Pessoa pessoa = new ClienteRequestDTO().converter(clienteRequestDTO);
        return pessoaService.inserir(pessoa);
    }
}