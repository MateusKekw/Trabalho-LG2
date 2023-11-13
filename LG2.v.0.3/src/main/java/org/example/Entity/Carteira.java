package org.example.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Carteira {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @ManyToOne
    private Investidor investidor;
    @Column
    @OneToMany(mappedBy = "carteira", cascade = CascadeType.ALL)
    private List<Ativo> ativos = new ArrayList<>();
    public Carteira(Investidor investidor) {
        this.investidor = investidor;
    }

    public Investidor getInvestidor() {
        return investidor;
    }

    public void setInvestidor(Investidor investidor) {
        this.investidor = investidor;
    }

    public List<Ativo> getAtivos() {
        return ativos;
    }

    public void setAtivos(List<Ativo> ativos) {
        this.ativos = ativos;
    }

    // Getters, setters e outros métodos necessários...


    @Override
    public String toString() {
        return "Carteira{" +
                "id=" + id +
                ", investidor=" + investidor +
                ", ativos=" + ativos +
                '}';
    }
}
