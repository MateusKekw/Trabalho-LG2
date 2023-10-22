package entity;

import jakarta.persistence.*;

@Entity
@Table
public class investidor {
    @Column
    private String nome;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CPF;
    @Column
    private int telefone;
    @Column
    private String banco;
    @Column
    private String empresa;
    @Column
    private Carteira ativos;
}
