package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.PermissaoPessoa;
import com.dev.backend.repository.PermissaoPessoaRepository;

@Service
public class PermissaoPessoaService {

    @Autowired
    private PermissaoPessoaRepository permissaoPessoaRepository;

    public List<PermissaoPessoa> buscarTodos() {
        return permissaoPessoaRepository.findAll();
    }

    public PermissaoPessoa inserir(PermissaoPessoa obj) {
        obj.setDataCriacao(new Date());
        PermissaoPessoa objNovo = permissaoPessoaRepository.saveAndFlush(obj);
        return objNovo;
    }

    public PermissaoPessoa alterar(PermissaoPessoa obj) {
        obj.setDataAtualizacao(new Date());
        return permissaoPessoaRepository.saveAndFlush(obj);
    }

    public void excluir(Long id) {
        PermissaoPessoa obj = permissaoPessoaRepository.findById(id).get();
        permissaoPessoaRepository.delete(obj);
    }
}
