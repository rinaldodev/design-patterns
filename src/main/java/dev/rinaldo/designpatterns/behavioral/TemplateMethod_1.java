package dev.rinaldo.designpatterns.behavioral;

/**
 * Java Design Patterns - Template Method (1)
 * 
 * @author youtube.com/RinaldoDev
 */
public class TemplateMethod_1 {

    public static void main(String[] args) {
        ProcessadorPagamento processadorPagamento = new ProcessadorPagamentoCredito();
        processadorPagamento.processarPagamento();
    }

}

//----------------------------------------------------

// Abstrata
// Concretas - Implementações

abstract class ProcessadorPagamento {
    
    // template method
    public void processarPagamento() {
        preparar();
        validar();
        debitar();
        notificar();
        finalizar();
    }

    protected abstract void debitar();

    private void preparar() {
        System.out.println("Reservando produtos");
    }
    
    private void validar() {
        System.out.println("Validando cadastro");
    }

    protected void notificar() {
        System.out.println("Notificando usuário");
    }
    
    protected void finalizar() {
        System.out.println("Finalizando compra");
    }
    
}

//----------------------------------------------------

class ProcessadorPagamentoCredito extends ProcessadorPagamento {

    @Override
    protected void debitar() {
        System.out.println("Debitando..");
    }
    
    @Override
    protected void notificar() {
//        super.notificar();
        System.out.println("Notificações adicionais..");
    }
    
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