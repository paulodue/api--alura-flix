package br.com.aluraflix.apialuraflix.repository;

import br.com.aluraflix.apialuraflix.model.VideoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<VideoModel, Long> {

}