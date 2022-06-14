package dev.rinaldo.designpatterns.behavioral;

import java.util.HashMap;
import java.util.Map;

/**
 * Java Design Patterns - Prototype (3)
 * 
 * @author youtube.com/RinaldoDev
 */
public class Prototype_3 {

    public static void main(String[] args) {
        // entradas de usuário
        criarModelo("PDF", "RESTRITO");
//        criarModelo("DOC", "RESTRITO");
//        criarModelo("PDF", "PUBLICO");
//        criarModelo("DOC", "PUBLICO");
        
        DocumentosRegistry3 registry = DocumentosRegistry3.getInstance();
        
        Documento3 novoDoc = registry.getDocumento3("PDF RESTRITO");
        novoDoc.nome = "novo doc";
        System.out.println(novoDoc);
        
        Documento3 novoDoc3 = registry.getDocumento3("PDF RESTRITO");
        System.out.println(novoDoc3);
    }
    
    private static void criarModelo(String tipo, String visibilidade) {
        Documento3 documento = new Documento3();
        documento.tipo = tipo;
        documento.visibilidade = visibilidade;
        documento.nome = tipo + " " + visibilidade;
        
        String chave = tipo + " " + visibilidade;
        DocumentosRegistry3.getInstance().addDocumento3(chave, documento);
    }

}

//----------------------------------------------------

final class Documento3 implements Cloneable {
    
    String nome;
    String visibilidade;
    String tipo;
    String localizacao; // url, path, etc
    // Documento2 doc -- PROBLEMA
    
    @Override
    public Documento3 clone() throws CloneNotSupportedException {
        return (Documento3) super.clone();
    }

    @Override
    public String toString() {
        return "Documento1 [nome=" + nome + ", visibilidade=" + visibilidade + ", tipo=" + tipo + ", localizacao=" + localizacao
                + "]";
    }
    
}

//----------------------------------------------------

final class DocumentosRegistry3 {

    private static final DocumentosRegistry3 INSTANCE = new DocumentosRegistry3();
    private static final Map<String, Documento3> REGISTRY = new HashMap<>();
    
    private DocumentosRegistry3() {
    }
    
    public static DocumentosRegistry3 getInstance() {
        return INSTANCE;
    }
    
    public Documento3 getDocumento3(String chave) {
        try {
            return REGISTRY.get(chave).clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Documento3 addDocumento3(String chave, Documento3 documento) {
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