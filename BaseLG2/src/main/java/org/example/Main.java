package org.example;

import org.example.Entity.*;
import org.example.dataStructure.ArvoreBinaria;
import org.example.dataStructure.Fila;
import org.example.dataStructure.Lista;
import org.example.util.HibernateUtil;
import org.hibernate.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Investidor investidor = new Investidor("Investidor 1");
            Carteira carteira = new Carteira(investidor);
            Ativo ativo = new Ativo("AAPL", "Ação");
            Corretora corretora = new Corretora("Corretora XYZ");
            Bolsa bolsa = new Bolsa("B3");
            Date data = new Date(13/11/23);
            Ordem ordem = new Ordem(investidor, ativo, corretora, bolsa, "Compra", 10, 150.0, data);

            OperacoesInvestidor.adicionarCarteira(investidor, carteira);
            OperacoesCarteira.adicionarAtivo(carteira, ativo);
            OperacoesOrdem.processarOrdem(ordem);

            session.save(investidor);
            session.save(carteira);
            session.save(ativo);
            session.save(corretora);
            session.save(bolsa);
            session.save(ordem);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Exemplo de uso para Fila
        Fila<Ativo> fila = new Fila<>();
        fila.enfileirar(new Ativo("CCPD", "Cotação"));
        fila.enfileirar(new Ativo("ZKXV", "Ação"));
        fila.enfileirar(new Ativo("CCPD", "Ação"));

        System.out.println("Elementos da fila:");
        while (!fila.isEmpty()) {
            System.out.print(fila.desenfileirar() + " ");
        }

        // Exemplo de uso para Lista Encadeada
        Lista<Ativo> lista = new Lista<>();
        lista.adicionar(new Ativo("CCPD", "Cotação"));
        lista.adicionar(new Ativo("ZKXV", "Ação"));
        lista.adicionar(new Ativo("CCPD", "Ação"));

        System.out.println("\nElementos da lista:");

        lista.imprimir();

        // Exemplo de uso para Árvore Binária
        ArvoreBinaria<Ativo> arvore = new ArvoreBinaria<>();
        arvore.inserir(new Ativo("ZKXV","Ação"));
        arvore.inserir(new Ativo("CCPD","Cotação"));
        arvore.inserir(new Ativo("CCPD","Acão"));

        System.out.println("Travessia em ordem da árvore:");
        arvore.emOrdem();
    }
}


// Operações relacionadas a Investidor
class OperacoesInvestidor {
    public static void adicionarCarteira(Investidor investidor, Carteira carteira) {
        investidor.getCarteiras().add(carteira);
        carteira.setInvestidor(investidor);
    }
    public static double calcularValorTotalInvestidor(Investidor investidor) {
        double valorTotal = 0.0;
        List<Carteira> carteiras = investidor.getCarteiras();
        for (Carteira carteira : carteiras) {
            valorTotal += OperacoesCarteira.calcularValorTotalCarteira(carteira);
        }
        return valorTotal;
    }


}

// Operações relacionadas a Carteira
class OperacoesCarteira {
    public static void adicionarAtivo(Carteira carteira, Ativo ativo) {
        carteira.getAtivos().add(ativo);
        ativo.setCarteira(carteira);
    }
    public static double calcularValorTotalCarteira(Carteira carteira) {
        double valorTotal = 0.0;
        for (Ativo ativo : carteira.getAtivos()) {
            valorTotal += ativo.getQuantidade() * ativo.getPrecoAtual();
        }
        return valorTotal;
    }


}

// Operações relacionadas a Ordem
class OperacoesOrdem {
    public static void processarOrdem(Ordem ordem) {
        if (ordem.getTipo().equalsIgnoreCase("Compra")) {
            processarCompra(ordem);
        } else if (ordem.getTipo().equalsIgnoreCase("Venda")) {
            processarVenda(ordem);
        } else {
            System.out.println("Tipo de ordem inválido: " + ordem.getTipo());
        }
    }

    private static void processarCompra(Ordem ordem) {
        double valorTotal = ordem.getQuantidade() * ordem.getPreco();

        // Lógica para processar a compra (exemplo: atualizar saldo, registrar transação, etc.)
        System.out.println("Ordem de compra processada para " + ordem.getAtivo().getCodigo() +
                " - Quantidade: " + ordem.getQuantidade() +
                " - Valor Total: " + valorTotal +
                " - Data: " + ordem.getData());
    }

    private static void processarVenda(Ordem ordem) {
        double valorTotal = ordem.getQuantidade() * ordem.getPreco();

        // Lógica para processar a venda (exemplo: atualizar saldo, registrar transação, etc.)
        System.out.println("Ordem de venda processada para " + ordem.getAtivo().getCodigo() +
                " - Quantidade: " + ordem.getQuantidade() +
                " - Valor Total: " + valorTotal +
                " - Data: " + ordem.getData());
    }

}
