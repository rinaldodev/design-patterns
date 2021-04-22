package dev.rinaldo.designpatterns.structural;

import java.math.BigDecimal;

/**
 * Java Design Patterns - Adapter (1)
 * 
 * @author youtube.com/RinaldoDev
 */
public class Adapter_1 {

    // Client
    // Adapter
    // Adaptee
    
    public static void main(String[] args) {
        MeuPagamentoCredito credito = new MeuPagamentoCredito();
        credito.debitar(new BigDecimal("100"));
    }

}

// ----------------------------------------------------

class MeuPagamentoCredito { // você tem acesso! é sua!

    SdkPagamentoCredito sdkPagamentoCredito = new SdkPagamentoCredito();

    public void debitar(BigDecimal valor) {
        sdkPagamentoCredito.autorizar(valor);
        sdkPagamentoCredito.capturar(valor);
    }

    public void creditar(BigDecimal valor) {
        sdkPagamentoCredito.creditar(valor);
    }

}

//----------------------------------------------------

class SdkPagamentoCredito { // sdk fechada! você não tem acesso!

    public void autorizar(BigDecimal valor) {
        // autoriza
    }

    public void capturar(BigDecimal valor) {
        // captura
    }

    public void creditar(BigDecimal valor) {
        // credita
    }

}

/*
 * twitter.com/rinaldodev
 * linkedin.com/in/rinaldodev
 * twitch.tv/rinaldodev
 * github.com/rinaldodev
 * facebook.com/rinaldodev
 * www.rinaldo.dev
 */

/*
 * ATENÇÃO: Esse arquivo é um material que acompanha a explicação em vídeo no YouTube. Não se baseie nesse exemplo para copiar e
 * colar diretamente no seu código sem anter entender do que se trata. Nem todas as boas práticas estão sendo aplicadas aqui, e
 * muitas coisas são omitidas por uma questão didática. Assista o vídeo completo no canal RinaldoDev no YouTube.
 */