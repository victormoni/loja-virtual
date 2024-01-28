package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.CarrinhoCompraProduto;
import com.dev.backend.repository.CarrinhoCompraProdutoRepository;

@Service
public class CarrinhoCompraProdutoService {

    @Autowired
    private CarrinhoCompraProdutoRepository carrinhoCompraProdutoRepository;

    public List<CarrinhoCompraProduto> buscarTodos() {
        return carrinhoCompraProdutoRepository.findAll();
    }

    public CarrinhoCompraProduto inserir(CarrinhoCompraProduto obj) {
        obj.setDataCriacao(new Date());
        CarrinhoCompraProduto objNovo = carrinhoCompraProdutoRepository.saveAndFlush(obj);
        return objNovo;
    }

    public CarrinhoCompraProduto alterar(CarrinhoCompraProduto obj) {
        obj.setDataAtualizacao(new Date());
        return carrinhoCompraProdutoRepository.saveAndFlush(obj);
    }

    public void excluir(Long id) {
        CarrinhoCompraProduto obj = carrinhoCompraProdutoRepository.findById(id).get();
        carrinhoCompraProdutoRepository.delete(obj);
    }
}
