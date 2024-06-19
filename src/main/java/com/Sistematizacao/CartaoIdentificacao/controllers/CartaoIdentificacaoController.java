package com.Sistematizacao.CartaoIdentificacao.controllers;

import com.Sistematizacao.CartaoIdentificacao.dto.CartaoDTO;
import com.Sistematizacao.CartaoIdentificacao.service.CartaoIdentificacaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class CartaoIdentificacaoController {

    private static final Logger log = LoggerFactory.getLogger(CartaoIdentificacaoController.class);
    @Autowired
    CartaoIdentificacaoService cartaoIdentificacaoService;


    //buscar um cartão existente ou a lista de cartões existentes
    @GetMapping("/cartaoidentificacao")
    public ResponseEntity<CartaoDTO> getCartao(@RequestParam("id") Integer matricula){
        CartaoDTO dto = cartaoIdentificacaoService.getCartao(matricula);

        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }


}