package dev.rinaldo.designpatterns.structural;

/**
 * Java Design Patterns - Proxy (3)
 * 
 * @author youtube.com/RinaldoDev
 */
public class Proxy_3 {
    
    // RealSubject / Implementação - ProdutoDAO3
    // Proxy - LazyProdutoDAO3
    // Subject - Interface
    
    public static void main(String[] args) {
//              IProdutoDAO3 produtoDAO = new ProdutoDAO3();
        IProdutoDAO3 produtoDAO = new LazyProdutoDAO3();
        ProdutoService3 produtoService = new ProdutoService3(produtoDAO);
        System.out.println("Produto service criado.");
//        produtoService.buscarProduto(1);
//        produtoService.buscarProduto(2);
//        produtoService.buscarProduto(3);
    }

}

//----------------------------------------------------

class ProdutoService3 {

    private IProdutoDAO3 produtoDAO;

    public ProdutoService3(IProdutoDAO3 produtoDAO) {
        this.produtoDAO = produtoDAO;
    }

    public Object buscarProduto(long id) {
        return produtoDAO.find(id);
    }

}

//----------------------------------------------------

interface IProdutoDAO3 {

    Object find(long id);

}

//----------------------------------------------------

class ProdutoDAO3 implements IProdutoDAO3 {

    public ProdutoDAO3() {
        System.out.println("Criando conexão com o banco.");
        simulaTempoAlto();
    }

    public Object find(long id) {
        // Busca produto e retorna
        simulaTempoAlto();
        return new Object();
    }

    private void simulaTempoAlto() {
        try {
            // Cria conexão com o banco
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

//----------------------------------------------------

// Composição

// Escolher entre composição (interface) ou herança

class LazyProdutoDAO3 implements IProdutoDAO3 {

    private IProdutoDAO3 daoReal;

    @Override
    public Object find(long id) {
        inicializaDAO();
        return daoReal.find(id);
    }

    private void inicializaDAO() {
        if (daoReal == null) {
            daoReal = new ProdutoDAO3();
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