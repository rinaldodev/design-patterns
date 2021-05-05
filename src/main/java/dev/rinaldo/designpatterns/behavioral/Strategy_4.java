package dev.rinaldo.designpatterns.behavioral;

import static java.lang.System.out;

import java.math.BigDecimal;

/**
 * Java Design Patterns - Strategy (4)
 * 
 * @author youtube.com/RinaldoDev
 */
public class Strategy_4 {

    public static void main(String[] args) {
        
        // List<Cliente> listaClientes
        // listaClientes.sort((c1, c2) -> c1.id > c2.id))
        
        
        BigDecimal valor = new BigDecimal("10");
        Compra4 compra = new Compra4(valor);
        
        compra.processarCompra(v -> out.println("Pagou no crédito " + v));
    }

}

//----------------------------------------------------

class Compra4 {
    
    BigDecimal valor;
    
    public Compra4(BigDecimal valor) {
        this.valor = valor;
    }
    
    void processarCompra(EstrategiaPagamento4 estrategiaPagamento) {
        estrategiaPagamento.pagar(valor);
    }
    
}

//----------------------------------------------------

interface EstrategiaPagamento4 {
    void pagar(BigDecimal valor);
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