package com.dev.backend.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dev.backend.entity.Produto;
import com.dev.backend.entity.ProdutoImagens;
import com.dev.backend.repository.ProdutoImagensRepository;
import com.dev.backend.repository.ProdutoRepository;

import lombok.NonNull;

@Service
public class ProdutoImagensService {

    @Autowired
    private ProdutoImagensRepository produtoImagensRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoImagens> buscarTodos() {
        return produtoImagensRepository.findAll();
    }

    public ProdutoImagens inserir(@NonNull Long idProduto, MultipartFile file) {

        Produto produto = produtoRepository.findById(idProduto).get();
        ProdutoImagens obj = new ProdutoImagens();

        try {
            if (!file.isEmpty()) {

                String nomeImagem = String.valueOf(produto.getId()) + ". " + file.getOriginalFilename();
                byte[] bytes = file.getBytes();
                Path caminho = Paths.get("C:/Users/Victor Moni/OneDrive/Imagens/Imagens/" + nomeImagem);
                Files.write(caminho, bytes);
                obj.setNome(nomeImagem);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        obj.setProduto(produto);
        obj.setDataCriacao(new Date());
        obj = produtoImagensRepository.saveAndFlush(obj);
        return obj;

    }

    public ProdutoImagens alterar(ProdutoImagens obj) {
        obj.setDataAtualizacao(new Date());
        return produtoImagensRepository.saveAndFlush(obj);
    }

    public void excluir(@NonNull Long id) {
        ProdutoImagens obj = produtoImagensRepository.findById(id).get();
        if(obj!=null)
        produtoImagensRepository.delete(obj);
    }
}
