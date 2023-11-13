package org.example.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Corretora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
    @Column
    @OneToMany(mappedBy = "corretora", cascade = CascadeType.ALL)
    private List<Ordem> ordens = new ArrayList<>();

    public Corretora(String nome) {
        this.nome = nome;
    }

    // Getters, setters e outros métodos necessários...


    @Override
    public String toString() {
        return "Corretora{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", ordens=" + ordens +
                '}';
    }
}
