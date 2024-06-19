package com.Sistematizacao.CartaoIdentificacao.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "saude")
public class Saude {

    //colunas da tabela de historico medico
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id_saude")
    private Integer idSaude;

    @Column(name="problema_medico")
    private String problemaMedico;

    @Column(name="id_matricula")
    private Integer idMatricula;

}
