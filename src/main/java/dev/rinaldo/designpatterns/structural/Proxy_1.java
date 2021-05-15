package dev.rinaldo.designpatterns.structural;

/**
 * Java Design Patterns - Proxy (1)
 * 
 * @author youtube.com/RinaldoDev
 */
public class Proxy_1 {

    // RealSubject / Implementação
    // Proxy
    
    public static void main(String[] args) {
//        ProdutoDAO produtoDAO = new ProdutoDAO();
        ProdutoDAO produtoDAO = new LogProdutoDAO();
        ProdutoService produtoService = new ProdutoService(produtoDAO);

        produtoService.buscarProduto(1);
        produtoService.buscarProduto(2);
        produtoService.buscarProduto(3);
    }

}

//----------------------------------------------------

class ProdutoService {

    private ProdutoDAO produtoDAO;

    public ProdutoService(ProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
    }

    public Object buscarProduto(long id) {
        return produtoDAO.find(id);
    }

}

//----------------------------------------------------

class ProdutoDAO {

    public ProdutoDAO() {
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

// Não mexi no Cliente
// Não mexi na Implementação original
// Herança

class LogProdutoDAO extends ProdutoDAO {
    
    @Override
    public Object find(long id) {
        System.out.println("Buscando produto com id " + id);
        Object find = super.find(id);
        System.out.println("Buscando produto com id " + id);
        return find;
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