package br.com.aluraflix.apialuraflix.repository;

import br.com.aluraflix.apialuraflix.model.CategoriaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {

}