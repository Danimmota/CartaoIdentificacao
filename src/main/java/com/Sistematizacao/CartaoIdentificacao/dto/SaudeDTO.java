package com.Sistematizacao.CartaoIdentificacao.dto;

import jakarta.persistence.Column;
import lombok.Data;

//lombok para injetar get and set e construtor
@Data
public class SaudeDTO {
    //variável que ira retornar para o usuário
    @Column(name="problema_medico")
    public String problemaMedico;

}
