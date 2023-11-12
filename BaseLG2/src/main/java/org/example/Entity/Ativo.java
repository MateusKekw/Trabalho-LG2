package org.example.Entity;

import jakarta.persistence.*;

@Entity
public class Ativo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String codigo;
    @Column
    private String tipo;
    @Column
    @ManyToOne
    private Carteira carteira;
    @Column
    @ManyToOne
    private Custodiante custodiante;
    @Column
    private int quantidade;
    @Column
    private double precoAtual;

    public Ativo() {
    }

    public Ativo(String codigo, String tipo) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.quantidade = 0;
        this.precoAtual = 0.0;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Carteira getCarteira() {
        return carteira;
    }

    public void setCarteira(Carteira carteira) {
        this.carteira = carteira;
    }

    public Custodiante getCustodiante() {
        return custodiante;
    }

    public void setCustodiante(Custodiante custodiante) {
        this.custodiante = custodiante;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPrecoAtual() {
        return precoAtual;
    }

    @Override
    public String toString() {
        return "Ativo{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", tipo='" + tipo + '\'' +
                ", carteira=" + carteira +
                ", custodiante=" + custodiante +
                ", quantidade=" + quantidade +
                ", precoAtual=" + precoAtual +
                '}';
    }
}
