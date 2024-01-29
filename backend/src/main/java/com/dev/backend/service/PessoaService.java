package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.Pessoa;
import com.dev.backend.repository.PessoaRepository;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> buscarTodos() {
        return pessoaRepository.findAll();
    }

    public Pessoa inserir(Pessoa obj) {
        obj.setDataCriacao(new Date());
        Pessoa objNovo = pessoaRepository.saveAndFlush(obj);
        return objNovo;
    }

    public Pessoa alterar(Pessoa obj) {
        obj.setDataAtualizacao(new Date());
        return pessoaRepository.saveAndFlush(obj);
    }

    public void excluir(Long id) {
        Pessoa obj = pessoaRepository.findById(id).get();
        pessoaRepository.delete(obj);
    }
}
