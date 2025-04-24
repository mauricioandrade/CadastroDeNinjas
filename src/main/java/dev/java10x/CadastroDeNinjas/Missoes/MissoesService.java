package dev.java10x.CadastroDeNinjas.Missoes;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    //listar
    public List<MissoesModel> Listar() {
        return missoesRepository.findAll();
    }

    // listar por id
    public MissoesModel listarPorId(Long id) {
        Optional<MissoesModel> listarPorId = missoesRepository.findById(id);
        return listarPorId.orElse(null);
    }

    // salvar
    public MissoesModel criarMissao(MissoesModel missoesModel) {
        return missoesRepository.save(missoesModel);
    }

    // deletar missao por id - tem que ser um metodo void
    public void deletarMissaoPorId(Long id) {
            missoesRepository.deleteById(id);
    }
    public MissoesModel atualizarMissao(Long id, MissoesModel missoesAtualizado){
        if (missoesRepository.existsById(id)){
            missoesAtualizado.setId(id);
            missoesRepository.save(missoesAtualizado);
        }
        return null;
    }
}