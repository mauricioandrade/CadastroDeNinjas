package dev.java10x.CadastroDeNinjas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(exclude = "missoes")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(unique = true)
    private String email;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "rank")
    private String rank;

    @Column(name = "idade")
    private int idade;



    // @ManyToOne um ninja tem uma unica missao.
    @ManyToOne
    @JoinColumn(name = "missoes_id") // foreing key - chave estrangeira.
    private MissoesModel missoes;



}
