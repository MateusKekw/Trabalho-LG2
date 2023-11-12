package org.example.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Investidor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;
    @Column
    @OneToMany(mappedBy = "investidor", cascade = CascadeType.ALL)
    private List<Ordem> ordens = new ArrayList<>();
    @Column
    @OneToMany(mappedBy = "investidor", cascade = CascadeType.ALL)
    private List<Carteira> carteiras = new ArrayList<>();

    public Investidor() {
    }

    public Investidor(String nome) {
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

    public List<Carteira> getCarteiras() {
        return carteiras;
    }

    public void setCarteiras(List<Carteira> carteiras) {
        this.carteiras = carteiras;
    }

    @Override
    public String toString() {
        return "Investidor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", ordens=" + ordens +
                ", carteiras=" + carteiras +
                '}';
    }
}
