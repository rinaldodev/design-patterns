package dev.rinaldo.designpatterns.creational;

/**
 * Java Design Patterns - Singleton (3)
 * 
 * @author youtube.com/RinaldoDev
 */
public class Singleton_3 {

    public static void main(String[] args) {
    }

}

//----------------------------------------------------
// ConfiguracaoAplicacao.java
class ConfiguracaoAplicacao {
    private static ConfiguracaoAplicacao instance;
    
    public String nomeAplicacao;
    public String versao;
    public String cor;

    protected ConfiguracaoAplicacao() {
        this.nomeAplicacao = "Singleton";
        this.versao = "3.0";
        this.cor = "Azul";
    }
    
    // parâmetro jvm
    // mapa - registro dos singletons
    // classpath
    
    public ConfiguracaoAplicacao getInstance() {
        if (instance == null) {
            String configuracao = System.getProperty("class.configuracao");
            if (configuracao == "teste") {
                instance = new ConfiguracaoAplicacaoTeste();
            }
            instance = new ConfiguracaoAplicacao();
        }
        return instance;
    }

}

//----------------------------------------------------
class ConfiguracaoAplicacaoTeste extends ConfiguracaoAplicacao {
    
    protected ConfiguracaoAplicacaoTeste() {
        this.nomeAplicacao = "Singleton Teste";
        this.versao = "3.0";
        this.cor = "Vermelho";
    }

}

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