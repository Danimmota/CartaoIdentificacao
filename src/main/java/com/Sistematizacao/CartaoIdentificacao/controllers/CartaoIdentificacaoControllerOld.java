//package com.Sistematizacao.CartaoIdentificacao.controllers;

//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//public class CartaoIdentificacaoControllerOld {
//
//    private static final Logger log = LoggerFactory.getLogger(CartaoIdentificacaoControllerOld.class);
//    @Autowired
//    FuncionarioRepository funcionarioRepository;
//    @Autowired
//    AlergiaRepository alergiaRepository;
//    @Autowired
//    ProblemaMedicoRepository problemaMedicoRepository;
//
//
//    //buscar um cartoão existente ou a lista de cartões existentes
//    @GetMapping("/cartaoidentificacao")
//    public ResponseEntity<List<Funcionario>> listar(){
//        List<Funcionario> cartaoIdentificacaoList = cartaoDTO.findAll();
//        return ResponseEntity.status(HttpStatus.OK).body(cartaoIdentificacaoList);
//    }
//    //criar um novo cartão/funcionário
//    @PostMapping("/cartaoidentificacao")
//    public ResponseEntity<Funcionario> salvar(@RequestBody @Valid CartaoDTO cartaoIdentificacaoDto) {
//        var funcionario = new Funcionario();
//        var cartaoIdentificacaoService = new CartaoIdentificacaoService();
//        var alergia = new Alergia();
//        var problemaMedico = new ProblemaMedico();
//        BeanUtils.copyProperties(cartaoIdentificacaoService, funcionario);
//        return ResponseEntity.status(HttpStatus.CREATED).body(cartaoIdentificacaoService.save(funcionario, alergia, problemaMedico));
//    }
//    //atualizar um cartao existente
//    @PutMapping("/cartaoidentificacao")
//    public ResponseEntity<Object> detalhar(@PathVariable(value="id") Integer id) {
//        Optional<Funcionario> cartao = cartaoDTO.findById(id);
//        if (cartao.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cartao não encontrado");
//        }
//        return ResponseEntity.status(HttpStatus.OK).body(cartao.get());
//    }
//    //deletar um cartão existente
//    @DeleteMapping("/cartaoidentificacao")
//    public ResponseEntity<Object> deleteProduct(@PathVariable(value = "id") Integer id) {
//    Optional<Funcionario> cartao = cartaoDTO.findById(id);
//        if (cartao.isEmpty()) {
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cartao não encontrado");
//        }
//        cartaoDTO.delete(cartao.get());
//        return ResponseEntity.status(HttpStatus.OK).body("Cartão excluído");
//    }
//
//}