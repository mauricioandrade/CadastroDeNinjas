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
    public MissoesDTO criarMissao (@RequestBody MissoesDTO missoesDTO){
        return missoesService.criarMissao(missoesDTO);
    }

    // MOSTRAR TODAS AS MISSOES (READ) -- GET -- MANDAR UMA REQUISIÇÃO PARA MOSTRAR AS MISSOES
    @GetMapping("/listar")
    public List<MissoesDTO>Listar(){
        return missoesService.Listar();
    }

    // Procurar MISSOES por ID (READ)
    @GetMapping("/listar/{id}")
    public MissoesDTO listarPorId(@PathVariable Long id){
        return missoesService.listarPorId(id);
    }


    // alterar ninja
    @PutMapping("/alterar/{id}")
    public MissoesDTO alterarMissaoPorId(@PathVariable Long id, @RequestBody MissoesDTO missoesDTO){
        return missoesService.atualizarMissao(id, missoesDTO);
    }


    // Deletar Missoes por ID (DELETE)
    @DeleteMapping("/deletar/{id}")
    public void deletarMissaoPorId(@PathVariable Long id) {
        missoesService.deletarMissaoPorId(id);
    }
}
