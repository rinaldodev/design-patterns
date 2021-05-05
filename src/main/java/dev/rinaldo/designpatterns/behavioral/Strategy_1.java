package dev.rinaldo.designpatterns.behavioral;

import java.math.BigDecimal;

/**
 * Java Design Patterns - Strategy (1)
 * 
 * @author youtube.com/RinaldoDev
 */
public class Strategy_1 {

    // Estrategia - Interface
    // Estrategia - Concreta
    // Contexto
    
    public static void main(String[] args) {
        BigDecimal valor = new BigDecimal("10");
        Compra compra = new Compra(valor);
        
//        compra.processarCompra(new PagamentoCartaoCredito());
        compra.processarCompra(new PagamentoCartaoDebito());
    }

}

//----------------------------------------------------

class Compra { // Contexto
    
    // ..
    BigDecimal valor;
    
    public Compra(BigDecimal valor) {
        this.valor = valor;
    }
    
    void processarCompra(EstrategiaPagamento estrategiaPagamento) {
        // ..
        estrategiaPagamento.pagar(valor);
    }
    
}

//----------------------------------------------------

// PagamentoStrategy
interface EstrategiaPagamento { // Estrategia - Interface

    void pagar(BigDecimal valor);

}

//----------------------------------------------------

//Estrategia - Concreta
class PagamentoCartaoCredito implements EstrategiaPagamento {

    @Override
    public void pagar(BigDecimal valor) {
        System.out.println("Pagou no crédito " + valor);
    }

}

//----------------------------------------------------

//Estrategia - Concreta
class PagamentoCartaoDebito implements EstrategiaPagamento {

    @Override
    public void pagar(BigDecimal valor) {
        System.out.println("Pagou no débito " + valor);
    }

}

/*
 * Twitter: @rinaldodev
 * LinkedIn: rinaldodev
 * Twitch: rinaldodev
 * GitHub: rinaldodev
 * Facebook: rinaldodev
 * Site: rinaldo.dev
 */

/*
 * ATENÇÃO: Esse arquivo é um material que acompanha a explicação em vídeo no YouTube. Não se baseie nesse exemplo para copiar e
 * colar diretamente no seu código sem anter entender do que se trata. Nem todas as boas práticas estão sendo aplicadas aqui, e
 * muitas coisas são omitidas por uma questão didática. Assista o vídeo completo no canal RinaldoDev no YouTube.
 */