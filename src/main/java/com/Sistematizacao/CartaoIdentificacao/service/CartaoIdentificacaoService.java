package com.Sistematizacao.CartaoIdentificacao.service;

import com.Sistematizacao.CartaoIdentificacao.dto.AlergiaDTO;
import com.Sistematizacao.CartaoIdentificacao.dto.CartaoDTO;
import com.Sistematizacao.CartaoIdentificacao.dto.SaudeDTO;
import com.Sistematizacao.CartaoIdentificacao.models.Alergia;
import com.Sistematizacao.CartaoIdentificacao.models.Funcionario;
import com.Sistematizacao.CartaoIdentificacao.models.Saude;
import com.Sistematizacao.CartaoIdentificacao.repositories.AlergiaRepository;
import com.Sistematizacao.CartaoIdentificacao.repositories.FuncionarioRepository;
import com.Sistematizacao.CartaoIdentificacao.repositories.SaudeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartaoIdentificacaoService {

   //Injeção de dependencia
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private SaudeRepository saudeRepository;
    @Autowired
    private AlergiaRepository alergiaRepository;


    //Responsáveis pelas regras de negócio

    //Método para converter o objeto model em objeto DTO
    public CartaoDTO parseCartao(Funcionario funcionario) {
        //criação do cartao de identificação
        CartaoDTO cartaoDTO = new CartaoDTO();

        Integer matricula = funcionario.getIdMatricula();

        cartaoDTO.setIdMatricula(funcionario.getIdMatricula());
        cartaoDTO.setNome(funcionario.getNome());
        cartaoDTO.setCpf(funcionario.getCpf());
        cartaoDTO.setEmail(funcionario.getEmail());
        cartaoDTO.setTelefone(funcionario.getTelefone());
        cartaoDTO.setTipoSanguineo(funcionario.getTipoSanguineo());
        // Inclui a lista de alergias no cartaoDTO
        cartaoDTO.setAlergias(getAlergiasDTO(matricula));
        // Inclui a lista de saude no cartaoDTO
        cartaoDTO.setSaude(getSaudeDTO(matricula));

        return cartaoDTO;
    }

    //Método para buscar 01 cartao existente no banco de dados
    public CartaoDTO getCartao(Integer matricula) {
        Funcionario funcionario = funcionarioRepository.findById(matricula).orElseThrow();
        return parseCartao(funcionario);
    }

    //Método para listar todos os cartões
    public List<CartaoDTO> listarCartoes() {
        List<Funcionario> funcionarioList = funcionarioRepository.findAll();
        List<CartaoDTO> cartoesDTO = new ArrayList<>();
        for (int i=0; i < funcionarioList.size(); i++){
            Funcionario funcionario = funcionarioList.get(i);
            CartaoDTO dto = parseCartao(funcionario);

            cartoesDTO.add(dto);
        }
        return cartoesDTO;
    }
    //Método para listar as alergias
    public List<AlergiaDTO> getAlergiasDTO(Integer idMatricula){
        List<Alergia> alergias = alergiaRepository.findByIdMatricula(idMatricula);
        // Cria uma lista vazia de objetos AlergiaDTO
        List<AlergiaDTO> alergiasDTO = new ArrayList<>();
        // Percorre a lista de alergias obtidas do banco de dados
        for (int i = 0; i < alergias.size(); i++){
            // Obtem o objeto Alergia a partir do index
            Alergia alergia = alergias.get(i);

            AlergiaDTO dto = new AlergiaDTO();
            dto.setNome(alergia.getNomeAlergia());
            // Adiciona o objeto DTO na lista de AlergiasDTO
            alergiasDTO.add(dto);
        }
        return alergiasDTO;
    }
    //Método para listar os problemas de saúde
    public List<SaudeDTO> getSaudeDTO(Integer idMatricula) {
        List<Saude> problemaMedico = saudeRepository.findByIdMatricula(idMatricula);
        //Cria uma lista vazia de objetos SaudeDTO
        List<SaudeDTO> saudeDTO = new ArrayList<>();
        //Percorre a lista de saude obtidas do banco de dados
        for (int i=0; i< problemaMedico.size(); i++){
            //
            Saude saude = problemaMedico.get(i);
            SaudeDTO dto = new SaudeDTO();
            dto.setProblemaMedico(saude.getProblema_medico());
            //
            saudeDTO.add(dto);
        }
        return saudeDTO;
    }

    //Método para adicionar um novo cartão de identificação ou editar um cartão
    @Transactional
    public CartaoDTO saveCartao(CartaoDTO cartaoDTO) {
        Funcionario funcionario = new Funcionario();
        funcionario.setIdMatricula(cartaoDTO.getIdMatricula());
        funcionario.setNome(cartaoDTO.getNome());
        funcionario.setCpf(cartaoDTO.getCpf());
        funcionario.setEmail(cartaoDTO.getEmail());
        funcionario.setTelefone(cartaoDTO.getTelefone());
        funcionario.setTipoSanguineo(cartaoDTO.getTipoSanguineo());

        /*
        O ID Matricula será null caso seja a criação de uma novo cartão
        se for edição, a matricula sepassada como parametro e será realizado uma operação de
        limpeza do historico de alergias e saude
        */
        Integer idMatricula = funcionario.getIdMatricula();
        if (idMatricula != null) {
            alergiaRepository.deleteByIdMatricula(idMatricula);
            saudeRepository.deleteByIdMatricula(idMatricula);
        }

        funcionario = funcionarioRepository.save(funcionario);

        //Criação da lista de alergias do novo cartão de identificação
        List<Alergia> alergias = new ArrayList<>();
        for (int i=0; i< cartaoDTO.getAlergias().size(); i++){
            String nomeAlergia = cartaoDTO.getAlergias().get(i).getNome();

            Alergia alergia = new Alergia();
            alergia.setNomeAlergia(nomeAlergia);
            alergia.setIdMatricula(funcionario.getIdMatricula());

            alergias.add(alergia);
        }

        alergiaRepository.saveAll(alergias);

        //Criação da lista de saúde/problemasmedicos do novo cartão de identificação
        List<Saude> saudeList = new ArrayList<>();
        for (int i=0; i< cartaoDTO.getSaude().size(); i++) {
            String problema_medico = cartaoDTO.getSaude().get(i).getProblemaMedico();

            Saude saude = new Saude();
            saude.setProblema_medico(problema_medico);
            saude.setIdMatricula(funcionario.getIdMatricula());

            saudeList.add(saude);

        }

        saudeRepository.saveAll(saudeList);

        return parseCartao(funcionario);
    }

    //Método para deletar um cartão
    @Transactional
    public void deleteCartao (Integer idMatricula) {
        /*
        Os registros de Saude e Alergia precisão ser excluidos antes do funcionario porque estas duas tabelas
        possui relacionamento com funcionario
        */
        saudeRepository.deleteByIdMatricula(idMatricula);
        alergiaRepository.deleteByIdMatricula(idMatricula);

        funcionarioRepository.deleteById(idMatricula);
    }


}
