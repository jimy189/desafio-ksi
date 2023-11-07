package com.br.apiksi.controller;


import com.br.apiksi.dto.FilmeDTO;
import com.br.apiksi.service.FilmeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/filme")
public class FilmeController {
    @Autowired
    private FilmeService filmeService;

    @PostMapping("/adicionarFilmes")
    public ResponseEntity<?> create(@RequestBody FilmeDTO form) throws Exception {
        filmeService.criar(form);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/listaFilmes")
    public ResponseEntity<?> listarFilmes() {
        return ResponseEntity.ok(filmeService.listarFilmes());
    }

    @PutMapping("/editar")
    public ResponseEntity<?> editarPessoa(@RequestParam(value = "idFilme" , required = true) long idFilme,
                                          @RequestBody FilmeDTO form) {
        filmeService.editar(idFilme, form);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/deletar")
    public ResponseEntity<?> deletarFilme(@RequestParam(value = "idFilme" , required = true) long idFilme) {
        filmeService.deletar(idFilme);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
