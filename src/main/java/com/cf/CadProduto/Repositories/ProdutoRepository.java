package com.cf.CadProduto.Repositories;

import com.cf.CadProduto.Models.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProdutoRepository extends JpaRepository<ProdutoModel,Long> {
}