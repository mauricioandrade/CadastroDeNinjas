package dev.java10x.CadastroDeNinjas.Missoes;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("missoes")
public class MissoesController {

  private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    // CRIANDO AS MISSOES (CREATE)  -- POST -- MANDAR UMA REQUISIÇÃO PARA CRIAR AS MISSOES
    @PostMapping("/add")
    public MissoesModel criarMissao (@RequestBody MissoesModel missoesModel){
        return missoesService.criarMissao(missoesModel);
    }

    // MOSTRAR TODAS AS MISSOES (READ) -- GET -- MANDAR UMA REQUISIÇÃO PARA MOSTRAR AS MISSOES
    @GetMapping("/listar")
    public List<MissoesModel>Listar(){
        return missoesService.Listar();
    }

    // Procurar MISSOES por ID (READ)
    @GetMapping("/listar/{id}")
    public MissoesModel listarPorId(@PathVariable Long id){
        return missoesService.listarPorId(id);
    }


    // alterar ninja
    @PutMapping("/alterar/{id}")
    public MissoesModel alterarMissaoPorId(@PathVariable Long id, @RequestBody MissoesModel missoesAtualizado){
        return missoesService.atualizarMissao(id, missoesAtualizado);
    }


    // Deletar Missoes por ID (DELETE)
    @DeleteMapping("/deletar/{id}")
    public void deletarMissaoPorId(@PathVariable Long id) {
        missoesService.deletarMissaoPorId(id);
    }
}
