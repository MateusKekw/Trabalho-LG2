import java.util

public class Ativos {
  private String codNegoc;
  /*XXXXY 
  XXXX = 04 letras maiúsculas que representam o nome do emissor Y = 01 número que representa o tipo da ação,
  adotado 3 para ordinária; 4 para preferencial; 5, 6, 7, 8 para preferenciais classes A, B, C e D, respectivamente
  */
  private String liquidacao;
  //fisica ou financeira
  private double cotacao;
  //valor
  private int data;
  private int hora;
  //separei os dois para ficar mais fácil de ver
  private String mercado;
  private Double Lote;
  //quantidade vendida
}
