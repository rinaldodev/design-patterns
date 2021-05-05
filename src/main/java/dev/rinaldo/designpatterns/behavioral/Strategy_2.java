package dev.rinaldo.designpatterns.behavioral;

import java.math.BigDecimal;

/**
 * Java Design Patterns - Strategy (2)
 * 
 * @author youtube.com/RinaldoDev
 */
public class Strategy_2 {

    public static void main(String[] args) {
        BigDecimal valor = new BigDecimal("10");
        Compra2 compra = new Compra2(valor);
        
        compra.processarCompra(new PagamentoCartaoCredito2());
        //compra.processarCompra(new PagamentoCartaoDebito2());
    }

}

//----------------------------------------------------

class Compra2 {
    
    // Long id;
    BigDecimal valor;
    // Tipo
    
    
    public Compra2(BigDecimal valor) {
        this.valor = valor;
    }
    
    void processarCompra(EstrategiaPagamento2 estrategiaPagamento) {
        estrategiaPagamento.pagar(this);
    }
    
}

//----------------------------------------------------

interface EstrategiaPagamento2 {

    void pagar(Compra2 compra);

}

//----------------------------------------------------

class PagamentoCartaoCredito2 implements EstrategiaPagamento2 {

    @Override
    public void pagar(Compra2 compra) {
        System.out.println("Pagou no crédito " + compra.valor);
        // compra.set...
    }

}

//----------------------------------------------------

class PagamentoCartaoDebito2 implements EstrategiaPagamento2 {

    @Override
    public void pagar(Compra2 compra) {
        System.out.println("Pagou no débito " + compra.valor);
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