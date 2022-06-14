package dev.rinaldo.designpatterns.behavioral;

import java.util.HashMap;
import java.util.Map;

/**
 * Java Design Patterns - Prototype (4)
 * 
 * @author youtube.com/RinaldoDev
 */
public class Prototype_4 {

    public static void main(String[] args) {
        // entradas de usuário
        criarModelo("PDF", "RESTRITO");
        criarModelo("DOC", "RESTRITO");
        criarModelo("PDF", "PUBLICO");
        criarModelo("DOC", "PUBLICO");
        
        DocumentosRegistry4 registry = DocumentosRegistry4.getInstance();
        
        Documento4 novoDoc = registry.getDocumento4("DOC RESTRITO");
        novoDoc.nome = "novo doc";
        System.out.println(novoDoc);
        
//        Documento4 novoDoc4 = registry.getDocumento4("DOC RESTRITO");
//        System.out.println(novoDoc4);
    }
    
    private static void criarModelo(String tipo, String visibilidade) {
        Documento4 documento = new Documento4();
        documento.tipo = tipo;
        documento.visibilidade = visibilidade;
        documento.nome = tipo + " " + visibilidade;
        
        String chave = tipo + " " + visibilidade;
        DocumentosRegistry4.getInstance().addDocumento4(chave, documento);
    }

}

//----------------------------------------------------

final class Documento4 {
    
    String nome;
    String visibilidade;
    String tipo;
    String localizacao; // url, path, etc
    
    public Documento4() {
    }
    
    public Documento4(Documento4 documento4) {
        this.nome = documento4.nome;
        this.visibilidade = documento4.visibilidade;
        this.tipo = documento4.tipo;
        this.localizacao = documento4.localizacao;
    }
    
    public static Documento4 clone(Documento4 documento4) {
        Documento4 clone = new Documento4();
        clone.nome = documento4.nome;
        clone.visibilidade = documento4.visibilidade;
        clone.tipo = documento4.tipo;
        clone.localizacao = documento4.localizacao;
        return clone;
    }

    @Override
    public String toString() {
        return "Documento1 [nome=" + nome + ", visibilidade=" + visibilidade + ", tipo=" + tipo + ", localizacao=" + localizacao
                + "]";
    }
    
}

//----------------------------------------------------

final class DocumentosRegistry4 {

    private static final DocumentosRegistry4 INSTANCE = new DocumentosRegistry4();
    private static final Map<String, Documento4> REGISTRY = new HashMap<>();
    
    private DocumentosRegistry4() {
    }
    
    public static DocumentosRegistry4 getInstance() {
        return INSTANCE;
    }
    
    public Documento4 getDocumento4(String chave) {
        Documento4 prototype = REGISTRY.get(chave);
        return Documento4.clone(prototype);
//        return new Documento4(prototype); 
    }
    
    public Documento4 addDocumento4(String chave, Documento4 documento) {
        return REGISTRY.put(chave, documento);
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