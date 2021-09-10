package br.com.aluraflix.apialuraflix.service;

import br.com.aluraflix.apialuraflix.model.VideoModel;
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
        return videoRepository.findById(id);
    }

    public VideoModel createOne(VideoModel videoModel) {
        return videoRepository.save(videoModel);
    }

    public VideoModel putOne(Long id, VideoModel videoModel) {
        Optional<VideoModel> videoModel1 = videoRepository.findById(id);

        if(videoModel1.isPresent()) {
            videoModel.setId(id);
            return videoRepository.save(videoModel);
        }
        return null;
    }
}