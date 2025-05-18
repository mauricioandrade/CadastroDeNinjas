package dev.java10x.CadastroDeNinjas.controller;
import dev.java10x.CadastroDeNinjas.dto.MissoesDTO;
import dev.java10x.CadastroDeNinjas.service.MissoesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
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
    @Operation(summary = "Cria uma nova missao", description = "Rota cria uma nova missao e insere no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Missao criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criaçao da missao")
    })
    public ResponseEntity<String> criarNinja(@RequestBody MissoesDTO missoesModel) {
        MissoesDTO missoesDTO = missoesService.criarMissao(missoesModel);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missao criada com sucesso: " + missoesDTO.getNome() + " (ID): " + missoesDTO.getId());
    }

    // MOSTRAR TODAS AS MISSOES (READ) -- GET -- MANDAR UMA REQUISIÇÃO PARA MOSTRAR AS MISSOES
    @GetMapping("/listar")
    @Operation(summary = "Lista as missoes", description = "Rota que lista as missoes")
    public ResponseEntity<List<MissoesDTO>> listar() {
        List<MissoesDTO> missoes = missoesService.Listar();
        return ResponseEntity.ok(missoes);
    }

    // Procurar MISSOES por ID (READ)
    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista a missao por id", description = "Rota lista uma missao pelo seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missao encontrada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Missao nao encontrado")
    })
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
    @Operation(summary = "Altera a missao por Id", description = "Rota altera uma missao pelo seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missao alterada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Missao nao encontrado, nao foi possivel alterar")
    })
    public ResponseEntity<?> alterarMissaoPorId(
            @Parameter(description = "Usuario manda o id no caminho da requisiçao")
            @PathVariable Long id,
            @Parameter(description = "Usuario manda os dados da misso a ser atualizad no corpo da requisiçao")
            @RequestBody MissoesDTO missaoAtualizada){
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
    @Operation(summary = "Deleta a missao por id", description = "Rota deleta uma missao por id")
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
