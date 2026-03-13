package com.cf.CadProduto.Services;

import com.cf.CadProduto.Models.ProdutoModel;
import com.cf.CadProduto.Repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoModel createProduto(ProdutoModel produtoModel) {
        return produtoRepository.save(produtoModel);
    }

    public void deleteProduto(Long id) {
        produtoRepository.deleteById(id);
    }

    public List<ProdutoModel> findAll() {
        return produtoRepository.findAll();
    }

    public ProdutoModel updateProduto(Long id, ProdutoModel produtoModel) {
        ProdutoModel produto = produtoRepository.findById(id).get();

        produto.setNome(produtoModel.getNome());
        produto.setPreco(produtoModel.getPreco());
        produto.setQuantidadeEmEstoque(produtoModel.getQuantidadeEmEstoque());
        produto.setStatusProduto(produtoModel.getStatusProduto());

        return produtoRepository.save(produto);
    }

}
