package com.Sistematizacao.CartaoIdentificacao.repositories;

import com.Sistematizacao.CartaoIdentificacao.models.Saude;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaudeRepository extends JpaRepository<Saude, Integer> {

    List<Saude> findByIdMatricula(Integer idMatricula);
}
