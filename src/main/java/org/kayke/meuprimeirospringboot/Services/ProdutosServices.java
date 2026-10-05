package org.kayke.meuprimeirospringboot.Services;

import org.kayke.meuprimeirospringboot.Exeptions.RecursoNaoEncontradoExeption;
import org.kayke.meuprimeirospringboot.Model.Produto;
import org.kayke.meuprimeirospringboot.Repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutosServices {

    private final ProdutoRepository produtoRepository;

    public ProdutosServices(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Produto salvarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void deletarProduto(Long id) {

        if (!produtoRepository.existsById(id)) {
            throw new RecursoNaoEncontradoExeption(
                    "Produto com ID " + id + " não encontrado"
            );
        }

        produtoRepository.deleteById(id);
    }

    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoExeption(
                        "Produto com ID " + id + " não encontrado"
                ));
    }
}