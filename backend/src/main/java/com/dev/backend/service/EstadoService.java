package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.Estado;
import com.dev.backend.repository.EstadoRepository;

import lombok.NonNull;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public List<Estado> buscarTodos() {
        return estadoRepository.findAll();
    }

    public Estado inserir(Estado obj) {
        obj.setDataCriacao(new Date());
        Estado objNovo = estadoRepository.saveAndFlush(obj);
        return objNovo;
    }

    public Estado alterar(Estado obj) {
        obj.setDataAtualizacao(new Date());
        return estadoRepository.saveAndFlush(obj);
    }

    public void excluir(@NonNull Long id) {
        Estado obj = estadoRepository.findById(id).get();
        if (obj != null)
        estadoRepository.delete(obj);
    }
}
