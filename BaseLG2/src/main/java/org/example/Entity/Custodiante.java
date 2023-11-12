package org.example.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Custodiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
    @Column
    @OneToMany(mappedBy = "custodiante", cascade = CascadeType.ALL)
    private List<Ativo> ativosCustodiados = new ArrayList<>();

    public Custodiante() {
    }

    public Custodiante(String nome) {
        this.nome = nome;
    }

    // Getters, setters e outros métodos necessários...


    @Override
    public String toString() {
        return "Custodiante{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", ativosCustodiados=" + ativosCustodiados +
                '}';
    }
}
