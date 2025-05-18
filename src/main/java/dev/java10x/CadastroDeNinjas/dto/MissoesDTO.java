package dev.java10x.CadastroDeNinjas.dto;

import dev.java10x.CadastroDeNinjas.entity.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class MissoesDTO {

    Long id;
    private String nome;
    private String dificuldade;
    private List<NinjaModel> ninja;
}
