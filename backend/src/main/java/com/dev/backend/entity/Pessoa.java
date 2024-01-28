package com.dev.backend.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "pessoa")
public class Pessoa{
  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private String endereco;
    private String cep;

    @ManyToOne
    @JoinColumn(name="idCidade")
    private Cidade cidade;

    @OneToMany
    @JoinColumn(name="IdPermissaoPessoa")
    private List<PermissaoPessoa> permissoes;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;
}
