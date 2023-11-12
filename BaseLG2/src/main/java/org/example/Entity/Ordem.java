package org.example.Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Ordem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @ManyToOne
    private Investidor investidor;
    @Column
    @ManyToOne
    private Ativo ativo;
    @Column
    @ManyToOne
    private Corretora corretora;
    @Column
    @ManyToOne
    private Bolsa bolsa;
    @Column
    private String tipo;
    @Column
    private int quantidade;
    @Column
    private double preco;
    @Column
    private Date data;

    public Ordem() {
    }

    public Ordem(Investidor investidor, Ativo ativo, Corretora corretora, Bolsa bolsa, String tipo, int quantidade, double preco, Date data) {
        this.investidor = investidor;
        this.ativo = ativo;
        this.corretora = corretora;
        this.bolsa = bolsa;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.preco = preco;
        this.data = data;
    }

    public Investidor getInvestidor() {
        return investidor;
    }

    public void setInvestidor(Investidor investidor) {
        this.investidor = investidor;
    }

    public Ativo getAtivo() {
        return ativo;
    }

    public void setAtivo(Ativo ativo) {
        this.ativo = ativo;
    }

    public Corretora getCorretora() {
        return corretora;
    }

    public void setCorretora(Corretora corretora) {
        this.corretora = corretora;
    }

    public Bolsa getBolsa() {
        return bolsa;
    }

    public void setBolsa(Bolsa bolsa) {
        this.bolsa = bolsa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "Ordem{" +
                "id=" + id +
                ", investidor=" + investidor +
                ", ativo=" + ativo +
                ", corretora=" + corretora +
                ", bolsa=" + bolsa +
                ", tipo='" + tipo + '\'' +
                ", quantidade=" + quantidade +
                ", preco=" + preco +
                ", data=" + data +
                '}';
    }
}
