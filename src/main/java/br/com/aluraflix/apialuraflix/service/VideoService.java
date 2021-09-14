package br.com.aluraflix.apialuraflix.service;

import br.com.aluraflix.apialuraflix.model.VideoModel;
import br.com.aluraflix.apialuraflix.model.VideoNaoEncontradoException;
import br.com.aluraflix.apialuraflix.repository.VideoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoService {
    private final VideoRepository videoRepository;

    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }



    public List<VideoModel> findAll() {
        return videoRepository.findAll();
    }

    public Optional<VideoModel> listOne(Long id) {
       Optional<VideoModel> videoModelUnico = videoRepository.findById(id);
        if (videoModelUnico.isPresent()) {
            return videoRepository.findById(id);
        }
        throw new VideoNaoEncontradoException(String.format("Video de ID %d não encontrado!", id));
    }

    public VideoModel createOne(VideoModel videoModel) {
        return videoRepository.save(videoModel);
    }

    public VideoModel putOne(Long id, VideoModel videoModel) {
        Optional<VideoModel> videoModelDB = videoRepository.findById(id);

        if(videoModelDB.isPresent()) {
            videoModel.setId(id);
            return videoRepository.save(videoModel);
        }
        throw new VideoNaoEncontradoException(String.format("Video de ID %d não encontrado!", id));
    }

    public void deleteOne(Long id) {
        Optional<VideoModel> videoModelDelete = videoRepository.findById(id);

        if (videoModelDelete.isPresent()) {
            videoRepository.deleteById(id);
        } else {
            throw new VideoNaoEncontradoException(String.format("Video de ID %d não encontrado!", id));
        }
    }
}