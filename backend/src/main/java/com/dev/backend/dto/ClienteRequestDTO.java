package com.dev.backend.dto;

import org.springframework.beans.BeanUtils;

import com.dev.backend.entity.Cidade;
import com.dev.backend.entity.Pessoa;

import lombok.Data;

@Data
public class ClienteRequestDTO {
    
    private String nome;
    private String cpf;
    private String email;
    private String endereco;
    private String cep;  
    private Cidade cidade;

    public Pessoa converter(ClienteRequestDTO clienteRequestDTO){
        Pessoa pessoa = new Pessoa();
        
        if(clienteRequestDTO != null)
        BeanUtils.copyProperties(clienteRequestDTO, pessoa);
        return pessoa;  
    }
}
