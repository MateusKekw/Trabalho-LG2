package org.example;

import org.example.Entity.*;
import org.example.dataStructure.*;
import org.example.util.HibernateUtil;
import org.hibernate.Transaction;
import org.hibernate.Session;
import java.util.*;

public class Main {
    public static void main(String[] args) {

            Investidor investidor = new Investidor("Investidor 1");
            Investidor investidor1 = new Investidor("Investidor 2");
            Investidor investidor2 = new Investidor("Investidor 3");
            Carteira carteira = new Carteira(investidor);
            Carteira carteira1 = new Carteira(investidor1);
            Carteira carteira2 = new Carteira(investidor2);
            Ativo ativo = new Ativo("AAPL", "Ação");
            Ativo ativo1 = new Ativo("JNKS", "Ação");
            Ativo ativo2 = new Ativo("FGSA", "Ação");
            Ativo ativo3 = new Ativo("ASDG", "Ação");
            Ativo ativo4 = new Ativo("MOBG", "Ação");
            Ativo ativo5 = new Ativo("PERU", "Ação");
            Corretora corretora = new Corretora("Corretora XYZ");
            Corretora corretora1 = new Corretora("Corretora JBD");
            Corretora corretora2 = new Corretora("Corretora PQW");
            Bolsa bolsa = new Bolsa("B3");
            Date data = new Date();
            Ordem ordem = new Ordem(investidor, ativo, corretora, bolsa, "Compra", 10, 150.0, data);
            Ordem ordem1 = new Ordem(investidor1, ativo, corretora, bolsa, "Compra", 10, 150.0, data);
            Ordem ordem2 = new Ordem(investidor2, ativo, corretora, bolsa, "Compra", 10, 150.0, data);

            bolsa.setOrdens(new ArrayList<>(List.of(ordem, ordem1, ordem2)));

            OperacoesInvestidor.adicionarCarteira(investidor, carteira);
            OperacoesCarteira.adicionarAtivo(carteira, ativo);
            OperacoesOrdem.processarOrdem(ordem);

            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();

            session.persist(investidor);
            session.persist(carteira);
            session.persist(ativo);
            session.persist(corretora);
            session.persist(bolsa);
            session.persist(ordem);

            transaction.commit();

        List<Ordem> ordens = session.createQuery("from Ordem", Ordem.class).list();
        ordens.forEach(v -> System.out.println(v));
        System.out.println(ordens.get(0));

        List<Bolsa> bolsas = session.createQuery("from Bolsa", Bolsa.class).list();
        bolsas.forEach(v -> System.out.println(v));
        System.out.println(bolsas.get(0));

        // Exemplo de uso para Fila
        Fila<Ativo> fila = new Fila<>();
        fila.enfileirar(new Ativo("CCPD", "Ação"));
        fila.enfileirar(new Ativo("ZKXV", "Ação"));
        fila.enfileirar(new Ativo("CCPD", "Ação"));

        System.out.println("Elementos da fila:");
        while (!fila.isEmpty()) {
            System.out.print(fila.desenfileirar() + " ");
        }

        // Exemplo de uso para Lista Encadeada
        Lista<Object> lista = new Lista<>();
        lista.adicionar(new Ativo("CCPD", "Ação"));
        lista.adicionar(new Ativo("ZKXV", "Ação"));
        lista.adicionar(new Ativo("CCPD", "Ação"));

        System.out.println("\nElementos da lista:");

        lista.imprimir();

        // Exemplo de uso para Árvore Binária
        ArvoreBinaria<Ativo> arvore = new ArvoreBinaria<>();
        arvore.inserir(new Ativo("ZKXV","Ação"));
        arvore.inserir(new Ativo("CCPD","Ação"));
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
