package com.br.apiksi.service;

import com.br.apiksi.dto.FilmeDTO;
import com.br.apiksi.entity.Filme;
import com.br.apiksi.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    public Filme criar(FilmeDTO form) {

        return filmeRepository.save(new Filme(form));
    }

    public  List<Filme> listarFilmes() {
        List<Filme> filmes = filmeRepository.findAll();
        return filmes;
    }

    public void  editar(Long idFilme, FilmeDTO form) {
        Optional<Filme> filme = filmeRepository.findById(idFilme);
        filme.get().setTitle(form.getTitle());
        filme.get().setDirector(form.getDirector());
        filme.get().setYear(form.getYear());
        filmeRepository.save(filme.get());
    }
    public void deletar(Long idFilme) {
        Optional<Filme> filme = filmeRepository.findById(idFilme);
        filmeRepository.delete(filme.get());
    }
}
