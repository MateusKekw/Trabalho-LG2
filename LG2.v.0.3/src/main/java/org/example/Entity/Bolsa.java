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

    public Bolsa(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Ordem> getOrdens() {
        return ordens;
    }

    public void setOrdens(List<Ordem> ordens) {
        this.ordens = ordens;
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
