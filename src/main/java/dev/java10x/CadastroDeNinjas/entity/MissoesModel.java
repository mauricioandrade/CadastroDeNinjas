package dev.java10x.CadastroDeNinjas.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table (name = "tb_missoes")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString

public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long id;

    private String nome;

    private String dificuldade;

    //@OneToMany uma missao para muitos ninjas.
    @OneToMany(mappedBy = "missoes")
    @JsonIgnore // ignora o loop da serialização
    private List<NinjaModel> ninja;


}

