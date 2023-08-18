package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Produto;
import com.example.demo.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }

    public Produto createProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto getProdutoById(Long id) throws ResourceNotFoundException {
        Produto produto = produtoRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException(String.format("Produto de ID %d não encontrado", id)));
        return produto;
    }
    
    public Produto updateProduto(Long id, Produto novoProduto) throws ResourceNotFoundException {
        Produto produtoAtual = produtoRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException(String.format("Produto de ID %d não encontrado", id)));
        produtoAtual.setNome(novoProduto.getNome());
        produtoAtual.setQuantidade(novoProduto.getQuantidade());
        return produtoRepository.save(produtoAtual);
    }

    public void deleteProduto(Long id) throws ResourceNotFoundException {
        Produto produto = produtoRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException(String.format("Produto de ID %d não encontrado", id)));
        produtoRepository.delete(produto);
    }
}
