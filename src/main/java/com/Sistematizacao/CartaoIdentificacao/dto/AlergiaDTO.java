package com.Sistematizacao.CartaoIdentificacao.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

//lombok para injetar getter and setter e construtor
@Data
public class AlergiaDTO{
    //variável que ira retornar para o usuário
    @JsonProperty("nome")
    public String nome;
}
