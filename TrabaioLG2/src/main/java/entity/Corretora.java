package entity;

import jakarta.persistence.*;
import org.hibernate.boot.model.naming.Identifier;

import java.util.List;

@Entity
@Table
public class Corretora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id_Corretora;
    @Column
    private String nome;
    @Column
    private char Sigla;
    @Column
    private List<Ativos> movimentacoes;
    @Column
    private Integer classificacao;

}
