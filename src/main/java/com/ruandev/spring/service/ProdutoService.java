package com.ruandev.spring.service;

import com.ruandev.spring.database.model.ProdutoEntity;
import com.ruandev.spring.dto.ProdutoDto;
import com.ruandev.spring.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {
    private static final List<ProdutoEntity> PRODUTOS = new ArrayList<>(List.of(
            ProdutoEntity.builder()
                    .id(1)
                    .nome("iphone")
                    .preco(new BigDecimal(700))
                    .quantidade(10)
                    .build(),
            ProdutoEntity.builder()
                    .id(2)
                    .nome("capa")
                    .preco(new BigDecimal(70))
                    .quantidade(30)
                    .build(),
            ProdutoEntity.builder()
                    .id(3)
                    .nome("notebook")
                    .preco(new BigDecimal(2000))
                    .quantidade(2)
                    .build()
    )
    );

    public List<ProdutoEntity> findAll() {
        return new ArrayList<>(PRODUTOS);
    }

    public boolean deleteId(Integer id) {
        return PRODUTOS.removeIf(p -> p.getId().equals(id));
    }

    public ProdutoEntity createProduct(ProdutoDto produto) {

        Integer newID = PRODUTOS.stream()
                .mapToInt(ProdutoEntity::getId)
                .max()
                .orElse(0) + 1;


        ProdutoEntity newProduct = ProdutoEntity.builder()
                .id(newID)
                .nome(produto.getNome())
                .preco(produto.getPreco())
                .quantidade(produto.getQuantidade())
                .build();
        PRODUTOS.add(newProduct);

        return newProduct;
    }
    private ProdutoEntity findById(Integer id) throws NotFoundException {
        return PRODUTOS.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("product not found"));
    }

    public ProdutoEntity updateProduct(ProdutoDto produtoDto, Integer id) throws NotFoundException {
        ProdutoEntity produto = findById(id);

        produto.setNome(produtoDto.getNome());
        produto.setPreco(produtoDto.getPreco());
        produto.setQuantidade(produtoDto.getQuantidade());
        return produto;
    }


    public ProdutoEntity search( Integer id) throws NotFoundException {
        return findById(id);
    }

    public ProdutoEntity updateProductPartially(ProdutoDto produtoDto, Integer id) throws NotFoundException {
        ProdutoEntity produto =findById(id);

        if (produtoDto.getNome() != null) {
            produto.setNome(produtoDto.getNome());
        }
        if (produtoDto.getPreco() != null) {
            produto.setPreco(produtoDto.getPreco());
        }
        if (produtoDto.getQuantidade() != null) {
            produto.setQuantidade(produtoDto.getQuantidade());
        }

        return produto;

    }
}
