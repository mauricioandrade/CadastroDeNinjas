package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota";
    }

    // Adicionar Ninjas (CREATE)
    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja Criado!";
    }

    // MOSTRAR TODOS OS NINJAS (READ)
    @GetMapping("/todos")
    public String mostrarTodosOsNinjas(){
        return "Mostrando os Ninjas!";
    }

    // Procurar Ninjas por ID (READ)
    @GetMapping("/todosID")
    public String mostrarTodosOsNinjasPorId(){
        return "Mostrando os Ninjas por ID!";
    }

    // Alterar dados dos Ninjas (UPDATE)
    @PutMapping("/alterarID")
    public String alterarNinjaPorId(){
        return "Alterar Ninja por ID";
    }

    // Deletar Ninjas por ID (DELETE)
    @DeleteMapping("/deletarID")
    public String deletarNinjaPorId(){
        return "Ninja Deletado!";
    }


}
