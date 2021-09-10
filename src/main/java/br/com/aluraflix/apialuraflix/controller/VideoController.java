package br.com.aluraflix.apialuraflix.controller;

import br.com.aluraflix.apialuraflix.model.VideoModel;
import br.com.aluraflix.apialuraflix.repository.VideoRepository;
import br.com.aluraflix.apialuraflix.service.VideoService;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@RestController
@RequestMapping("/videos")
public class VideoController {

    private final VideoService videoService;

    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @GetMapping
    public ResponseEntity<List<VideoModel>> listAll() {
        List<VideoModel> videos = videoService.findAll();
        return ResponseEntity.ok(videos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VideoModel> listOne(@PathVariable("id") Long id) {
        Optional<VideoModel> videoOPT = videoService.listOne(id);
        return ResponseEntity.of(videoOPT);
//        if (videoOPT.isPresent()) {
//            return ResponseEntity.ok(videoOPT.get());
//        } else {
//            return ResponseEntity.notFound().build();
//        }
    }

    @PostMapping
    public ResponseEntity<VideoModel> createOne(@Validated @RequestBody VideoModel videoModel) {
        return ResponseEntity.ok(videoService.createOne(videoModel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VideoModel> putOne(@PathVariable("id") Long id, @RequestBody VideoModel videoModel) {
        if(Objects.nonNull(videoService.putOne(id, videoModel))) {
            return ResponseEntity.ok(videoService.putOne(id, videoModel));
        } else {
            return ResponseEntity.notFound().build();
        }

//        return ResponseEntity.ok(videoService.putOne(id, videoModel));
    }
}