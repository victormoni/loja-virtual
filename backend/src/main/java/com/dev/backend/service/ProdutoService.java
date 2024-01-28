package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.Produto;
import com.dev.backend.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> buscarTodos() {
        return produtoRepository.findAll();
    }

    public Produto inserir(Produto obj) {
        obj.setDataCriacao(new Date());
        Produto objNovo = produtoRepository.saveAndFlush(obj);
        return objNovo;
    }

    public Produto alterar(Produto obj) {
        obj.setDataAtualizacao(new Date());
        return produtoRepository.saveAndFlush(obj);
    }

    public void excluir(Long id) {
        Produto obj = produtoRepository.findById(id).get();
        produtoRepository.delete(obj);
    }
}
