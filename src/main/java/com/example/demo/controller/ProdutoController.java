package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Produto;
import com.example.demo.repository.ProdutoRepository;

@RestController
@RequestMapping("/api/")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/produtos")
    public List<Produto> getAllProdutos(){
        return produtoRepository.findAll();
    }

    @PostMapping("/produtos")
    public Produto createProduto(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    @GetMapping("/produtos/{id}")
    public Produto getProdutoById(@PathVariable Long id) {
        Produto produto = produtoRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException(String.format("Produto de ID %d não encontrado", id)));
        return produto;
    }

    @PatchMapping("/produtos/{id}")
    public Produto updateProduto(@PathVariable Long id, @RequestBody Produto body) {
        Produto produto = produtoRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException(String.format("Produto de ID %d não encontrado", id)));
        produto.setNome(body.getNome());
        produto.setQuantidade(body.getQuantidade());
        return produtoRepository.save(produto);
    }

    @DeleteMapping("/produtos/{id}")
    public Map<String, Boolean> deleteProduto(@PathVariable Long id) {
        Produto produto = produtoRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException(String.format("Produto de ID %d não encontrado", id)));
        produtoRepository.delete(produto);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
    }
}
