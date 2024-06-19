package com.Sistematizacao.CartaoIdentificacao.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.Data;

import java.util.List;

@Data
public class CartaoDTO {

    @JsonProperty("id_matricula")
    public Integer idMatricula;
    public String nome;
    public String cpf;
    public String email;
    public String telefone;
    @JsonProperty("tipo_sanguineo")
    public String tipoSanguineo;

    //renomear o mapeamento de saída em formato Json
    @JsonProperty("alergias")
    public List<AlergiaDTO> alergias;
    @JsonProperty("saude")
    public List<SaudeDTO> saude;

}
