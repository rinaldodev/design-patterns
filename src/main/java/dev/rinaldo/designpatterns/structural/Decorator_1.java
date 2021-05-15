package dev.rinaldo.designpatterns.structural;

/**
 * Java Design Patterns - Decorator (1)
 * 
 * @author youtube.com/RinaldoDev
 */
public class Decorator_1 {

    public static void main(String[] args) {
        Endereco endereco = new Endereco("Rua 4 Casa 123", "Centro", "São José", "RN", "50930-123");
        
        EnderecadorSimples enderecador = new EnderecadorSimples();
        EnderecadorCaixaAlta enderecadorCaixaAlta = new EnderecadorCaixaAlta(enderecador);
        
        String enderecoFormatado = enderecadorCaixaAlta.preparaEndereco(endereco);
        
        System.out.println(enderecoFormatado);
    }

}

//----------------------------------------------------

class Endereco {
    final String logradouro;
    final String bairro;
    final String cidade;
    final String uf;
    final String cep;
    
    public Endereco(String logradouro, String bairro, String cidade, String uf, String cep) {
        super();
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
    }
}

//----------------------------------------------------

class EnderecadorSimples {
    public String preparaEndereco(Endereco endereco) {
        StringBuilder sb = new StringBuilder();
        sb.append(endereco.logradouro);
        sb.append("\n");
        sb.append(endereco.bairro);
        sb.append("\n");
        sb.append(endereco.cidade);
        sb.append('/');
        sb.append(endereco.uf);
        sb.append("\n");
        sb.append(endereco.cep);
        return sb.toString();
    }
}

//----------------------------------------------------
// Decorator

class EnderecadorCaixaAlta {
    
    EnderecadorSimples enderecador;
    
    public EnderecadorCaixaAlta(EnderecadorSimples enderecador) {
        super();
        this.enderecador = enderecador;
    }

    public String preparaEndereco(Endereco endereco) {
        return enderecador.preparaEndereco(endereco).toUpperCase();
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