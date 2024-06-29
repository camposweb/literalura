package br.com.alura.literalura.model;

import java.util.Collections;
import java.util.List;

public class Livro {

    private String titulo;

    private List<DadosAutor> autor;

    private List<String> idioma;

    private Integer numeroDownloads;

    public Livro() {}

    public Livro(DadosLivro dadosLivro) {
        this.titulo = dadosLivro.titulo();
        this.autor = Collections.singletonList(dadosLivro.autor().get(0));
        this.idioma = Collections.singletonList(dadosLivro.idioma().get(0));
        this.numeroDownloads = dadosLivro.numeroDownloads();
    }

    public List<DadosAutor> getAutor() {
        return autor;
    }

    public void setAutor(List<DadosAutor> autor) {
        this.autor = autor;
    }

    public List<String> getIdioma() {
        return idioma;
    }

    public void setIdioma(List<String> idioma) {
        this.idioma = idioma;
    }

    public Integer getNumeroDownloads() {
        return numeroDownloads;
    }

    public void setNumeroDownloads(Integer numeroDownloads) {
        this.numeroDownloads = numeroDownloads;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return
                "titulo='" + titulo + '\'' +
                ", autor=" + autor +
                ", idioma=" + idioma +
                ", numeroDownloads=" + numeroDownloads;
    }
}