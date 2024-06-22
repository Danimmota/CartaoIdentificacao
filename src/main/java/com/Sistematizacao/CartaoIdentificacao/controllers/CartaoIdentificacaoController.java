package com.Sistematizacao.CartaoIdentificacao.controllers;

import com.Sistematizacao.CartaoIdentificacao.dto.CartaoDTO;
import com.Sistematizacao.CartaoIdentificacao.service.CartaoIdentificacaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//editar cartao > put
//add cartao > post > ok
//deletar cartao > delete > ok
//buscar cartao > get > ok

@RestController
@RequestMapping("/cartaoidentificacao")
public class CartaoIdentificacaoController {

    private static final Logger log = LoggerFactory.getLogger(CartaoIdentificacaoController.class);
    @Autowired
    CartaoIdentificacaoService cartaoIdentificacaoService;


    //buscar um cartão existente
    @GetMapping("/")
    public ResponseEntity<CartaoDTO> getCartao(@RequestParam("id") Integer matricula){
        CartaoDTO dto = cartaoIdentificacaoService.getCartao(matricula);

        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    //buscar uma lista de cartões existentes
    @GetMapping("/listartodos")
    public ResponseEntity<List<CartaoDTO>> listarCartoes(){
        List<CartaoDTO> cartoesDTO = cartaoIdentificacaoService.listarCartoes();

        return ResponseEntity.status(HttpStatus.OK).body(cartoesDTO);
    }
    //Adicionar um cartao e editar um cartão
    @PostMapping("/create")
    public ResponseEntity<CartaoDTO> saveCartao(@RequestBody CartaoDTO cartaoDTO) {
        CartaoDTO dto = cartaoIdentificacaoService.saveCartao(cartaoDTO);

        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    // Deletar um cartao de identificação
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCartao (@RequestParam("id") Integer matricula) {
        cartaoIdentificacaoService.deleteCartao(matricula);

        return ResponseEntity.status(HttpStatus.OK).body("Cartão excluído com sucesso");
    }





}