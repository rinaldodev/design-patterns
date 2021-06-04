package dev.rinaldo.designpatterns.behavioral;

/**
 * Java Design Patterns - Template Method (2)
 * 
 * @author youtube.com/RinaldoDev
 */
public class TemplateMethod_2 {

    public static void main(String[] args) {
        ProcessadorPagamento2 processadorPagamento = new ProcessadorPagamentoCredito2();
        processadorPagamento.processarPagamento();
    }

}

//----------------------------------------------------

abstract class ProcessadorPagamento2 {
    
    // template method
    public void processarPagamento() {
        preparar();
        validar();
        debitar();
        notificar();
        notificarAdicional();
        finalizar();
        finalizarAdicional();
    }

    protected abstract void debitar();

    private void preparar() {
        System.out.println("Reservando produtos");
    }
    
    private void validar() {
        System.out.println("Validando cadastro");
    }

    private void notificar() {
        System.out.println("Notificando usuário");
    }
    
    private void finalizar() {
        System.out.println("Finalizando compra");
    }
    
    protected void notificarAdicional() {
        // vazio
    }
    
    protected void finalizarAdicional() {
        // vazio        
    }
    
}

//----------------------------------------------------

class ProcessadorPagamentoCredito2 extends ProcessadorPagamento2 {

    @Override
    protected void debitar() {
        System.out.println("Debitando..");
    }
    
    @Override
    protected void notificarAdicional() {
        System.out.println("Notificações adicionais..");
    }
    
//    @Override
//    protected void finalizarAdicional() {
//        System.out.println("Finalização adicional..");
//    }
    
}

//----------------------------------------------------

// Twitter: twitter.com/rinaldodev
// LinkedIn: linkedin.com/in/rinaldodev
// Twitch: twitch.tv/rinaldodev
// GitHub: github.com/rinaldodev
// Facebook: facebook.com/rinaldodev
// Site: rinaldo.dev

/*
 * ATENÇÃO: Esse arquivo é um material que acompanha a explicação em vídeo no YouTube. Não se baseie nesse exemplo para copiar e
 * colar diretamente no seu código sem anter entender do que se trata. Nem todas as boas práticas estão sendo aplicadas aqui, e
 * muitas coisas são omitidas por uma questão didática. Assista o vídeo completo no canal RinaldoDev no YouTube.
 */