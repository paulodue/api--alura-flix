package br.com.aluraflix.apialuraflix.service;

import br.com.aluraflix.apialuraflix.model.CategoriaModel;
import br.com.aluraflix.apialuraflix.model.CategoriaNaoEncontradaException;
import br.com.aluraflix.apialuraflix.model.VideoModel;
import br.com.aluraflix.apialuraflix.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }


    public List<CategoriaModel> findAll() {
        return categoriaRepository.findAll();
    }

    public Optional<CategoriaModel> listOne(Long id) {
        Optional<CategoriaModel> categoriaModelUnico = categoriaRepository.findById(id);
        if(categoriaModelUnico.isPresent()) {
            return categoriaRepository.findById(id);
        } else {
            throw new CategoriaNaoEncontradaException(String.format("Video de ID %d não encontrado!", id));
        }
    }

    public CategoriaModel createOne(CategoriaModel categoriaModel) {
        return categoriaRepository.save(categoriaModel);
    }

    public CategoriaModel putOne(Long id, CategoriaModel categoriaModel) {
        Optional<CategoriaModel> categoriaModelDB = categoriaRepository.findById(id);

        if(categoriaModelDB.isPresent()) {
            categoriaModel.setId(id);
            return categoriaRepository.save(categoriaModel);
        }
        throw new CategoriaNaoEncontradaException(String.format("Categoria de ID %d não encontrada!", id));
    }

    public void deleteOne(Long id) {
        Optional<CategoriaModel> categoriaModelDelete = categoriaRepository.findById(id);

        if(categoriaModelDelete.isPresent()) {
            categoriaRepository.deleteById(id);
        } else {
            throw new CategoriaNaoEncontradaException(String.format("Categoria de ID %d não encontrada!", id));
        }
    }
}
