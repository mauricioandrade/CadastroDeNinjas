package dev.java10x.CadastroDeNinjas.Missoes;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

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
    public ResponseEntity<String> criarNinja(@RequestBody MissoesDTO missoesModel) {
        MissoesDTO missoesDTO = missoesService.criarMissao(missoesModel);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missao criada com sucesso: " + missoesDTO.getNome() + " (ID): " + missoesDTO.getId());
    }

    // MOSTRAR TODAS AS MISSOES (READ) -- GET -- MANDAR UMA REQUISIÇÃO PARA MOSTRAR AS MISSOES
    @GetMapping("/listar")
    public ResponseEntity<List<MissoesDTO>> listar() {
        List<MissoesDTO> missoes = missoesService.Listar();
        return ResponseEntity.ok(missoes);
    }

    // Procurar MISSOES por ID (READ)
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable Long id) {
        MissoesDTO missoes = missoesService.listarPorId(id);
        if (missoes != null){
            return ResponseEntity.ok(missoes);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missao com o id " + id + " não existe nos nossos registros!");
        }
    }


    // alterar ninja
    @PatchMapping("/alterar/{id}")
    public ResponseEntity<?> alterarMissaoPorId(@PathVariable Long id, @RequestBody MissoesDTO missaoAtualizada){
        MissoesDTO missoes = missoesService.atualizarMissao(id, missaoAtualizada);
        if(missoes != null){
            return ResponseEntity.ok(missoes);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missao com o id " + id + " não existe nos nossos registros!");
        }
    }


    // Deletar Missoes por ID (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissaoPorId(@PathVariable Long id) {
        if (missoesService.listarPorId(id) != null) {
            missoesService.deletarMissaoPorId(id);
            return ResponseEntity.ok("Missao com id: " + id + " deletada com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A missao com o id " + id + " não existe");
        }
    }
}
