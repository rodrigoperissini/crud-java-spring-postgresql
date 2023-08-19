package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.model.Produto;
import com.example.demo.repository.ProdutoRepository;

@ExtendWith(MockitoExtension.class)
public class ProdutoServiceTest {

    @Mock
    private ProdutoRepository produtoRepository;
    
    @Mock
    private ProdutoService produtoService;

    @BeforeEach
    public void setup() {

    }

    @Test
    void testCreateProduto() {
        Produto produto = new Produto(20L,"CD do Tchan", 25);
        when(produtoService.getAllProdutos()).thenReturn(List.of(produto));
        assertEquals(1, produtoService.getAllProdutos().size());
    }

    @Test
    void testDeleteProduto() {
        produtoService.deleteProduto(999L);
        verify(produtoService, times(1)).deleteProduto(999L);
    }

    @Test
    void testGetAllProdutos() {

    }

    @Test
    void testGetProdutoById() {

    }

    @Test
    void testUpdateProduto() {

    }
}
