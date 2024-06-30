package com.Sistematizacao.CartaoIdentificacao.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="alergias")
public class Alergia {

    //colunas da tabela de alergias
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_alergia")
    private Integer idAlergia;

    @Column(name="nome")
    private String nomeAlergia;

    @Column(name="id_matricula")
    private Integer idMatricula;

}
