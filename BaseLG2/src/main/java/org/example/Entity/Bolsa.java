package org.example.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Bolsa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
    @Column
    @OneToMany(mappedBy = "bolsa", cascade = CascadeType.ALL)
    private List<Ordem> ordens = new ArrayList<>();

    public Bolsa() {
    }

    public Bolsa(String nome) {
        this.nome = nome;
    }

    // Getters, setters e outros métodos necessários...


    @Override
    public String toString() {
        return "Bolsa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", ordens=" + ordens +
                '}';
    }
}
