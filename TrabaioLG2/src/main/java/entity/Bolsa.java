package entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Bolsa {
    @Column
    private String nome = "B3";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    //só para não dar erro no @Table
    @Column
    private List<Corretora> empresas_cadastradas;
    @Column
    private List<Investidor> investidores;
    @Column
    private List<Ativos> acoes_circulando;
}
