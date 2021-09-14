package br.com.aluraflix.apialuraflix.controller;


import br.com.aluraflix.apialuraflix.model.CategoriaModel;
import br.com.aluraflix.apialuraflix.model.CategoriaNaoEncontradaException;
import br.com.aluraflix.apialuraflix.service.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) { this.categoriaService = categoriaService; }


    @GetMapping
    public ResponseEntity<?> listAll() {
        List<CategoriaModel> categorias = categoriaService.findAll();
        return ResponseEntity.ok(categorias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listOne(@PathVariable("id") Long id) {
        try {
            Optional<CategoriaModel> categoriaOPT = categoriaService.listOne(id);
            return ResponseEntity.ok(categoriaOPT);
        } catch (CategoriaNaoEncontradaException ex){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> createOne(@Validated @RequestBody CategoriaModel categoriaModel) {
        return ResponseEntity.ok(categoriaService.createOne(categoriaModel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putOne(@PathVariable("id") Long id, @RequestBody CategoriaModel categoriaModel) {
        try {
            CategoriaModel categoriaModelSalvo = categoriaService.putOne(id, categoriaModel);
            return ResponseEntity.ok(categoriaModelSalvo);
        } catch (CategoriaNaoEncontradaException ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOne(@PathVariable("id")Long id) {
        try {
            categoriaService.deleteOne(id);
            return ResponseEntity.ok().build();
        } catch (CategoriaNaoEncontradaException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
