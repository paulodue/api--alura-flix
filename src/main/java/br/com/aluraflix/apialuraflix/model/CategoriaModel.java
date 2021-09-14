package br.com.aluraflix.apialuraflix.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "categoria")
public class CategoriaModel {


    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(message = "O título deve ter no mínimo 3 e máximo 100 caracteres", min = 3, max = 100)
    @NotBlank(message = "Este campo deve ser preenchido!")
    @Column(name = "titulo", length = 100, nullable = false)
    private String titulo;

    @Size(message = "A cor deve ter no mínimo 3 e máximo 50 caracteres", min = 3, max = 50)
    @NotBlank(message = "Este campo deve ser preenchido!")
    @Column
    private String cor;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
}
