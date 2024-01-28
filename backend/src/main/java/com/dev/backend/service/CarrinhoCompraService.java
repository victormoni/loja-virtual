package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.CarrinhoCompra;
import com.dev.backend.repository.CarrinhoCompraRepository;

@Service
public class CarrinhoCompraService {

    @Autowired
    private CarrinhoCompraRepository carrinhoCompraRepository;

    public List<CarrinhoCompra> buscarTodos() {
        return carrinhoCompraRepository.findAll();
    }

    public CarrinhoCompra inserir(CarrinhoCompra obj) {
        obj.setDataCriacao(new Date());
        CarrinhoCompra objNovo = carrinhoCompraRepository.saveAndFlush(obj);
        return objNovo;
    }

    public CarrinhoCompra alterar(CarrinhoCompra obj) {
        obj.setDataAtualizacao(new Date());
        return carrinhoCompraRepository.saveAndFlush(obj);
    }

    public void excluir(Long id) {
        CarrinhoCompra obj = carrinhoCompraRepository.findById(id).get();
        carrinhoCompraRepository.delete(obj);
    }
}
