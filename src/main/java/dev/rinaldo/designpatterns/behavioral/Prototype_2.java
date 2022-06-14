package dev.rinaldo.designpatterns.behavioral;

import java.util.HashMap;
import java.util.Map;

/**
 * Java Design Patterns - Prototype (2)
 * 
 * @author youtube.com/RinaldoDev
 */
public class Prototype_2 {

    public static void main(String[] args) {
        DocumentosRegistry2 registry = DocumentosRegistry2.getInstance();
        Documento2 pdfRestrito = registry.getDocumento2("PDF RESTRITO");
        System.out.println(pdfRestrito);
        pdfRestrito.nome = "ListaDeMembros.pdf";
        System.out.println(pdfRestrito);
        
        pdfRestrito = registry.getDocumento2("PDF RESTRITO");
        System.out.println(pdfRestrito);
    }

}

//----------------------------------------------------

final class Documento2 implements Cloneable {
    
    String nome;
    String visibilidade;
    String tipo;
    String localizacao; // url, path, etc
    
    @Override
    public Documento2 clone() throws CloneNotSupportedException {
        return (Documento2) super.clone();
    }

    @Override
    public String toString() {
        return "Documento1 [nome=" + nome + ", visibilidade=" + visibilidade + ", tipo=" + tipo + ", localizacao=" + localizacao
                + "]";
    }
    
}

//----------------------------------------------------

final class DocumentosRegistry2 {

    private static final DocumentosRegistry2 INSTANCE = new DocumentosRegistry2();
    
    private static final Map<String, Documento2> REGISTRY = new HashMap<>();
    
    static {
        Documento2 d1 = new Documento2();
        d1.tipo = "PDF";
        d1.visibilidade = "RESTRITO";
        REGISTRY.put("PDF RESTRITO", d1);
        
        Documento2 d2 = new Documento2();
        d2.tipo = "PDF";
        d2.visibilidade = "PUBLICO";
        REGISTRY.put("PDF PUBLICO", d2);
        
        Documento2 d3 = new Documento2();
        d3.tipo = "DOC";
        d3.visibilidade = "RESTRITO";
        REGISTRY.put("DOC RESTRITO", d3);
        
        Documento2 d4 = new Documento2();
        d4.tipo = "DOC";
        d4.visibilidade = "RESTRITO";
        REGISTRY.put("DOC PUBLICO", d4);
    }
    
    public static DocumentosRegistry2 getInstance() {
        return INSTANCE;
    }
    
    public Documento2 getDocumento2(String chave) {
        try {
            return REGISTRY.get(chave).clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
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