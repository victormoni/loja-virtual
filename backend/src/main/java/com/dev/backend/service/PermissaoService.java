package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.Permissao;
import com.dev.backend.repository.PermissaoRepository;

import lombok.NonNull;

@Service
public class PermissaoService {

    @Autowired
    private PermissaoRepository permissaoRepository;

    public List<Permissao> buscarTodos() {
        return permissaoRepository.findAll();
    }

    public Permissao inserir(Permissao obj) {
        obj.setDataCriacao(new Date());
        Permissao objNovo = permissaoRepository.saveAndFlush(obj);
        return objNovo;
    }

    public Permissao alterar(Permissao obj) {
        obj.setDataAtualizacao(new Date());
        return permissaoRepository.saveAndFlush(obj);
    }

    public void excluir(@NonNull Long id) {
        Permissao obj = permissaoRepository.findById(id).get();
       
        if(obj != null)
        permissaoRepository.delete(obj);
    }
}
