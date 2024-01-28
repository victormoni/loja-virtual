package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.Categoria;
import com.dev.backend.repository.CategoriaRepository;

import lombok.NonNull;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> buscarTodos() {
        return categoriaRepository.findAll();
    }

    public Categoria inserir(Categoria obj) {
        obj.setDataCriacao(new Date());
        Categoria objNovo = categoriaRepository.saveAndFlush(obj);
        return objNovo;
    }

    public Categoria alterar(Categoria obj) {
        obj.setDataAtualizacao(new Date());
        return categoriaRepository.saveAndFlush(obj);
    }

    public void excluir(@NonNull Long id) {
        Categoria obj = categoriaRepository.findById(id).get();

        if(obj != null)
        categoriaRepository.delete(obj);
    }
}
