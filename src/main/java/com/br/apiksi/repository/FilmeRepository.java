package com.br.apiksi.repository;

import com.br.apiksi.entity.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {

}
