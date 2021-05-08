package dev.rinaldo.designpatterns.creational;

/**
 * Java Design Patterns - Singleton (1)
 * 
 * @author youtube.com/RinaldoDev
 */
public class Singleton_2 {

    public static void main(String[] args) {
        ProdutoFactory2.INSTANCE.novoProduto(0);
    }

}

interface Produto5 {
}

class ProdutoPadrao5 implements Produto5 {
}

class ProdutoDigital5 extends ProdutoPadrao5 {
}

class ProdutoFisico5 extends ProdutoPadrao5 {
}

//----------------------------------------------------
// ProdutoFactory.java
enum ProdutoFactory2 {
    INSTANCE;
    
    public Produto5 novoProduto(int tipoProduto) {
        switch (tipoProduto) {
            case 1:
                return new ProdutoPadrao5();
            case 2:
                return new ProdutoDigital5();
            case 3:
                return new ProdutoFisico5();
            default:
                throw new IllegalArgumentException();
        }
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