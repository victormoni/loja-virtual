package com.dev.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.backend.entity.CarrinhoCompra;

public interface CarrinhoCompraRepository extends JpaRepository<CarrinhoCompra, Long>{
    
}
