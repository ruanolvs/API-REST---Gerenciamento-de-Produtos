package com.ruandev.spring.controller;


import com.ruandev.spring.database.model.ProdutoEntity;
import com.ruandev.spring.dto.ProdutoDto;
import com.ruandev.spring.exception.NotFoundException;
import com.ruandev.spring.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/produtos")
@RequiredArgsConstructor /*coloca os metodos private ja em um construtor,
tornando codigo mais clean e sem precisar usar autowired*/

public class ProdutoController {

    private final ProdutoService produtoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProdutoEntity> findAll() {
        return produtoService.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        boolean removed = produtoService.deleteId(id);
        if (removed) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoEntity create(@RequestBody ProdutoDto produto) {
        return produtoService.createProduct(produto);

    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProdutoEntity update(@PathVariable Integer id,
                                @RequestBody ProdutoDto produtoDto) throws NotFoundException {
        return produtoService.updateProduct(produtoDto, id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProdutoEntity searchProduct(@PathVariable Integer id) throws NotFoundException {
        return produtoService.search(id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProdutoEntity updatePartially(@PathVariable Integer id,
                                            @RequestBody ProdutoDto produtoDto) throws NotFoundException {
        return produtoService.updateProductPartially(produtoDto, id);
    }


}
