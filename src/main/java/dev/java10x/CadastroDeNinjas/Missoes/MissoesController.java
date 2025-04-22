package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    // CRIANDO AS MISSOES (CREATE)  -- POST -- MANDAR UMA REQUISIÇÃO PARA CRIAR AS MISSOES
    @PostMapping("/criar")
    public String criarMissao() {
        return "Missão Criada com Sucesso!";
    }

    // MOSTRAR TODAS AS MISSOES (READ) -- GET -- MANDAR UMA REQUISIÇÃO PARA MOSTRAR AS MISSOES
    @GetMapping("/todas")
    public String mostrarTodasAsMissoes(){
        return "Mostrando as Missoes!";
    }

    // Procurar MISSOES por ID (READ)
    @GetMapping("/todasID")
    public String mostrarTodasAsMissoesPorId(){
        return "Mostrando as Missões por ID!";
    }

    // Alterar dados das MISSOES (UPDATE) -- PUT -- REQUISIÇÃO PARA ALTERAR AS MISSOES
    @PutMapping("/alterarID")
    public String alterarMissaoPorId(){
        return "Alterar Missões por ID";
    }

    // Deletar MISSOES por ID (DELETE) -- DELETE -- REQUISIÇÃO PARA DELETAR AS MISSOES
    @DeleteMapping("/deletarID")
    public String deletarMissaoPorId(){
        return "Missão Deletada!";
    }
}
