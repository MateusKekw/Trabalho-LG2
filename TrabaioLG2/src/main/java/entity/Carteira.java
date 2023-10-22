package entity;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

public class Carteira {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id_carteira;
    @Column
    private String dono;
    @Column
    private List<String> ativos;
    @Column
    private double valor_total;
}
