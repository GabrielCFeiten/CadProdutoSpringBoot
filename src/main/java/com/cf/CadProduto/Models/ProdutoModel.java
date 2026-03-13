package com.cf.CadProduto.Models;

import com.cf.CadProduto.Enums.StatusProduto;
import jakarta.persistence.*;

@Entity
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Double preco;
    private Integer quantidadeEmEstoque;

    @Enumerated(EnumType.STRING)
    private StatusProduto statusProduto;

    public ProdutoModel() {
    }

    public StatusProduto getStatusProduto() {
        return statusProduto;
    }

    public void setStatusProduto(StatusProduto statusProduto) {
        this.statusProduto = statusProduto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(Integer quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }
}
