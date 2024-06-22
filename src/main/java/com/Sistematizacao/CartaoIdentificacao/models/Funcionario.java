package com.Sistematizacao.CartaoIdentificacao.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="funcionarios")
public class Funcionario {

    //colunas da tabela de funcionarios
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_matricula")
    private Integer idMatricula;

    @Column
    private String nome;

    @Column
    private String cpf;

    @Column
    private String email;

    @Column
    private String telefone;

    @Column(name="tipo_sanguineo")
    private String tipoSanguineo;
}

