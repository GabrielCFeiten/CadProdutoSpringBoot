package com.cf.CadProduto.Controllers;

import com.cf.CadProduto.Models.ProdutoModel;
import com.cf.CadProduto.Services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoModel>> getAllProdutos(){
        List<ProdutoModel> produtos = produtoService.findAll();
        return ResponseEntity.ok().body(produtos);
    }

    @PostMapping
    public ResponseEntity<ProdutoModel> createProduto(@RequestBody ProdutoModel produto){
        ProdutoModel request = produtoService.createProduto(produto);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(request.getId())
                .toUri();

        return ResponseEntity.created(uri).body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduto(@PathVariable Long id){
        produtoService.deleteProduto(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoModel> updateProduto(@PathVariable Long id, @RequestBody ProdutoModel produto){
        ProdutoModel updated = produtoService.updateProduto(id, produto);
        return ResponseEntity.ok().body(updated);
    }
}
