package dev.rinaldo.designpatterns.structural;

import java.math.BigDecimal;

/**
 * Java Design Patterns - Adapter (2)
 * 
 * @author youtube.com/RinaldoDev
 */
public class Adapter_2 {
    
    // Client
    // Adapter
    // Adaptee
    // Target
    
    public static void main(String[] args) {
        ProcessorPagamento2 credito = new MeuPagamentoCredito2();
        credito.debitar(new BigDecimal("100"));
    }
    
}

//----------------------------------------------------

interface ProcessorPagamento2 {
    
    void debitar(BigDecimal valor);
    
    void creditar(BigDecimal valor);
    
}

//----------------------------------------------------

class MeuPagamentoCredito2 implements ProcessorPagamento2 {
    
    SdkPagamentoCredito2 sdkPagamentoCredito = new SdkPagamentoCredito2();
    
    // ..
    
    public void debitar(BigDecimal valor) {
        // ..        
        sdkPagamentoCredito.autorizar(valor);
        sdkPagamentoCredito.capturar(valor);
    }
    
    public void creditar(BigDecimal valor) {
        // ..        
        sdkPagamentoCredito.creditar(valor);
    }
    
}

//----------------------------------------------------

class SdkPagamentoCredito2 { // .jar / lib no maven
    
    // posso até ter acesso, mas não convém alterar
    
    void autorizar(BigDecimal valor) {
        // autoriza
    }
    
    void capturar(BigDecimal valor) {
        // captura
    }
    
    void creditar(BigDecimal valor) {
        // credita
    }
    
}

/*
 * /
 * twitter.com/rinaldodev
 * linkedin.com/in/rinaldodev
 * twitch.tv/rinaldodev
 * github.com/rinaldodev
 * facebook.com/rinaldodev
 * www.rinaldo.dev
 * /
 */

/*
 * ATENÇÃO: Esse arquivo é um material que acompanha a explicação em vídeo no YouTube. Não se baseie nesse exemplo para copiar e
 * colar diretamente no seu código sem anter entender do que se trata. Nem todas as boas práticas estão sendo aplicadas aqui, e
 * muitas coisas são omitidas por uma questão didática. Assista o vídeo completo no canal RinaldoDev no YouTube.
 */