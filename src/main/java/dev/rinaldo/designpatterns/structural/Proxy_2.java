package dev.rinaldo.designpatterns.structural;

import java.util.HashMap;

/**
 * Java Design Patterns - Proxy (2)
 * 
 * @author youtube.com/RinaldoDev
 */
public class Proxy_2 {

    // RealSubject / Implementação
    // Proxy    
    
    public static void main(String[] args) {
//                ProdutoDAO2 produtoDAO = new ProdutoDAO2();
        ProdutoDAO2 produtoDAO = new CacheProdutoDAO2();
        ProdutoService2 produtoService = new ProdutoService2(produtoDAO);
        
        produtoService.buscarProduto(1);
        produtoService.buscarProduto(1);
        produtoService.buscarProduto(1);
    }
    
}

//----------------------------------------------------

class ProdutoService2 {
    
    private ProdutoDAO2 produtoDAO;

    public ProdutoService2(ProdutoDAO2 produtoDAO) {
        this.produtoDAO = produtoDAO;
    }
    
    public Object buscarProduto(long id) {
        return produtoDAO.find(id);
    }
    
}

//----------------------------------------------------

class ProdutoDAO2 {

    public ProdutoDAO2() {
        simulaTempoAlto();
    }

    public Object find(long id) {
        // Busca produto e retorna
        System.out.println("Busca objeto na base.");
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

//Não mexi no Cliente
//Não mexi na Implementação original
//Herança

class CacheProdutoDAO2 extends ProdutoDAO2 {

    private static final HashMap<Long, Object> CACHE = new HashMap<>();
    
    @Override
    public Object find(long id) {
        Object o = CACHE.get(id);
        if (o == null) {
            o = super.find(id);
            CACHE.put(id, o);
            return o;
        }
        System.out.println("Busca objeto no cache.");
        return o;
    }
    
}

// Exemplos
// @Inject / @AutoWired / @EJB
// RMI / java.rmi - Remote Method Invocation


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