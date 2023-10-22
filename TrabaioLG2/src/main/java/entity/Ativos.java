package entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Ativos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String codNegoc;
    /*XXXXY
    XXXX = 04 letras maiúsculas que representam o nome do emissor Y = 01 número que representa o tipo da ação,
    adotado 3 para ordinária; 4 para preferencial; 5, 6, 7, 8 para preferenciais classes A, B, C e D, respectivamente
    */
    @Column
    private String liquidacao;
    //fisica ou financeira
    @Column
    private double cotacao;
    //valor
    @Column
    private int data;
    @Column
    private int hora;
    //separei os dois para ficar mais fácil de ver
    @Column
    private String mercado;
    @Column
    private Double Lote;
    //quantidade vendida


}