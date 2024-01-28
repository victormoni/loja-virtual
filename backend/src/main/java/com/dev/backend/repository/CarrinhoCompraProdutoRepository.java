package com.dev.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.backend.entity.CarrinhoCompraProduto;

public interface CarrinhoCompraProdutoRepository extends JpaRepository<CarrinhoCompraProduto, Long>{
    
}
