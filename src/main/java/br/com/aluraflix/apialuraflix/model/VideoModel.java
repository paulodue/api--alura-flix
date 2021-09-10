package br.com.aluraflix.apialuraflix.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "video")
public class VideoModel {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Size(message = "O título deve ter no mínimo 10 e máximo 100 caracteres", min = 10, max = 100)
    @NotBlank(message = "Este campo deve ser preenchido!")
    @Column(name = "titulo", length = 100, nullable = false)
    private String titulo;

    @NotBlank(message = "Este campo deve ser preenchido!")
    @Column(name = "descricao", length = 255, nullable = false)
    private String descricao;

    @NotBlank(message = "Este campo deve ser preenchido!")
    @Column(name = "url", length = 255, nullable = false)
    private String url;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {this.id = id;}

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

}