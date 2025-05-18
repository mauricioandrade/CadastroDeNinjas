package dev.java10x.CadastroDeNinjas.service;
import dev.java10x.CadastroDeNinjas.dto.MissoesDTO;
import dev.java10x.CadastroDeNinjas.repository.MissoesRepository;
import dev.java10x.CadastroDeNinjas.entity.MissoesModel;
import dev.java10x.CadastroDeNinjas.mapper.MissoesMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {

    private final MissoesRepository missoesRepository;
    private MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    //listar
    public List<MissoesDTO> Listar() {
        List<MissoesModel> missoes = missoesRepository.findAll();
        return missoes.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

    // listar por id
    public MissoesDTO listarPorId(Long id) {
        Optional<MissoesModel> listarPorId = missoesRepository.findById(id);
        return listarPorId.map(missoesMapper::map).orElse(null);
    }

    // salvar
    public MissoesDTO criarMissao(MissoesDTO missoesDTO) {
        MissoesModel missoesModel = missoesMapper.map(missoesDTO);
        missoesModel = missoesRepository.save(missoesModel);
        return missoesMapper.map(missoesModel);
    }

    // Deletar missao
    public void deletarMissaoPorId(Long id) {
        missoesRepository.deleteById(id);
    }

    // alterar missao
    public MissoesDTO atualizarMissao(Long id, MissoesDTO missoesDTO){
        Optional<MissoesModel> missaoExistente = missoesRepository.findById(id);
        if (missaoExistente.isPresent()) {
            MissoesModel missaoAtualizada = missoesMapper.map(missoesDTO);
            missaoAtualizada.setId(id);
            MissoesModel missaoSalva = missoesRepository.save(missaoAtualizada);
            return missoesMapper.map(missaoSalva);
        }
        return null;
    }
}