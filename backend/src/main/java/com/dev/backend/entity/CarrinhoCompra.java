package com.dev.backend.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "carrinhoCompra")
public class CarrinhoCompra {
  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date dataCompra;
    private String observacao;
    private String situacao;
     
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;

}
