package br.com.gustavo.generatecsv.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ServicoTecnico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String nome;

    @Column(length = 255)
    private String descricaoDetalhada;

    private boolean ativo;

}
