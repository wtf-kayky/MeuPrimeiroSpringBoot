package org.kayke.meuprimeirospringboot.Controller;

import org.kayke.meuprimeirospringboot.Exeptions.RecursoNaoEncontradoExeption;
import org.kayke.meuprimeirospringboot.Model.Produto;
import org.kayke.meuprimeirospringboot.Services.ProdutosServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/produtos")
public class ProdutoController {

    private final ProdutosServices produtosServices;

    public ProdutoController(ProdutosServices produtosServices) {
        this.produtosServices = produtosServices;
    }

    @GetMapping
    public List<Produto> listarProdutos() {
        return produtosServices.listarProdutos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarProduto(@PathVariable Long id) {
            Produto produto = produtosServices.buscarPorId(id);
            return ResponseEntity.ok(produto);

    }

    @PostMapping
    public Produto adicionarProduto(@RequestBody Produto produto) {
        return produtosServices.salvarProduto(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
        produtosServices.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }
}