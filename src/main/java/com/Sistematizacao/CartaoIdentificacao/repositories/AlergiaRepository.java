package com.Sistematizacao.CartaoIdentificacao.repositories;

import com.Sistematizacao.CartaoIdentificacao.models.Alergia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlergiaRepository extends JpaRepository<Alergia, Integer> {

    List<Alergia> findByIdMatricula(Integer idMatricula);
}
