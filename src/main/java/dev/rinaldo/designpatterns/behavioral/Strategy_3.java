package dev.rinaldo.designpatterns.behavioral;

import java.math.BigDecimal;

/**
 * Java Design Patterns - Strategy (3)
 * 
 * @author youtube.com/RinaldoDev
 */
public class Strategy_3 {

    public static void main(String[] args) {
        BigDecimal valor = new BigDecimal("10");
        Compra3 compra = new Compra3(valor);
        
        compra.processar(new PagamentoCartaoCredito3());
        //compra.processarCompra(new PagamentoCartaoDebito3());
    }

}

//----------------------------------------------------

interface Pagavel3 {
    BigDecimal getValor();
    // ..
}

//----------------------------------------------------

class Compra3 implements Pagavel3 {
    
    BigDecimal valor;
    
    public Compra3(BigDecimal valor) {
        this.valor = valor;
    }
    
    public void processar(EstrategiaPagamento3 estrategiaPagamento) {
        // ..
        estrategiaPagamento.pagar(this);
        // ..        
    }

    @Override
    public BigDecimal getValor() {
        return valor;
    }
    
}

//----------------------------------------------------

interface EstrategiaPagamento3 {

    void pagar(Pagavel3 compra);

}

//----------------------------------------------------

class PagamentoCartaoCredito3 implements EstrategiaPagamento3 {

    @Override
    public void pagar(Pagavel3 pagavel) {
        System.out.println("Pagou no crédito " + pagavel.getValor());
    }

}

//----------------------------------------------------

class PagamentoCartaoDebito3 implements EstrategiaPagamento3 {

    @Override
    public void pagar(Pagavel3 pagavel) {
        System.out.println("Pagou no débito " + pagavel.getValor());
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