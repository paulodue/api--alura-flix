package br.com.aluraflix.apialuraflix.controller;

import br.com.aluraflix.apialuraflix.model.VideoModel;
import br.com.aluraflix.apialuraflix.model.VideoNaoEncontradoException;
import br.com.aluraflix.apialuraflix.service.VideoService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public ResponseEntity<?> listOne(@PathVariable("id") Long id) {
        try {
            Optional<VideoModel> videoOPT = videoService.listOne(id);
            return ResponseEntity.ok(videoOPT);
        } catch (VideoNaoEncontradoException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<VideoModel> createOne(@Validated @RequestBody VideoModel videoModel) {
        return ResponseEntity.ok(videoService.createOne(videoModel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VideoModel> putOne(@PathVariable("id") Long id, @RequestBody VideoModel videoModel) {
        try {
            VideoModel videoModelSalvo = videoService.putOne(id, videoModel);
            return ResponseEntity.ok(videoModelSalvo);
        } catch (VideoNaoEncontradoException ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOne(@PathVariable("id") Long id)  {
        try {
            videoService.deleteOne(id);
            return ResponseEntity.ok().build();
        } catch (VideoNaoEncontradoException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}