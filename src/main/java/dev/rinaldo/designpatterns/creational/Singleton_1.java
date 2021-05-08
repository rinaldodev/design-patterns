package dev.rinaldo.designpatterns.creational;

/**
 * Java Design Patterns - Singleton (1)
 * 
 * @author youtube.com/RinaldoDev
 */
public class Singleton_1 {

    public static void main(String[] args) {
//        ProdutoFactory.INSTANCE.novoProduto(1);
//        ProdutoFactory.INSTANCE.novoProduto(2);
//        ProdutoFactory.INSTANCE.novoProduto(3);
        ProdutoFactory.getInstance().novoProduto(1);
        ProdutoFactory.getInstance().novoProduto(2);
        ProdutoFactory.getInstance().novoProduto(3);
    }

}

interface Produto4 {
}

class ProdutoPadrao4 implements Produto4 {
}

class ProdutoDigital4 extends ProdutoPadrao4 {
}

class ProdutoFisico4 extends ProdutoPadrao4 {
}

//----------------------------------------------------
// ProdutoFactory.java
class ProdutoFactory {
//    public static final ProdutoFactory INSTANCE = new ProdutoFactory();
    private static ProdutoFactory instance;
    
    private ProdutoFactory() {
    }
    
//    public static synchronized ProdutoFactory getInstance() {
    public static ProdutoFactory getInstance() {
        if (instance == null) {
            instance = new ProdutoFactory();
        }
        return instance;
    }
    
    public Produto4 novoProduto(int tipoProduto) {
        switch (tipoProduto) {
            case 1:
                return new ProdutoPadrao4();
            case 2:
                return new ProdutoDigital4();
            case 3:
                return new ProdutoFisico4();
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