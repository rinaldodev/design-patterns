package dev.rinaldo.designpatterns.structural;

/**
 * Java Design Patterns - Decorator (4)
 * 
 * @author youtube.com/RinaldoDev
 */
public class Decorator_4 {

    public static void main(String[] args) {
        Endereco4 endereco = new Endereco4("Rua 4 Casa 144", "Centro", "São José", "RN", "50940-144");

        Enderecador4 enderecador = new EnderecadorSimples4();
        enderecador = new EnderecadorCaixaAlta4(enderecador);
        enderecador = new EnderecadorComBorda4(enderecador);

        String enderecoFormatado = enderecador.preparaEndereco(endereco);

        System.out.println(enderecoFormatado);
    }

}

//----------------------------------------------------

class Endereco4 {
    final String logradouro;
    final String bairro;
    final String cidade;
    final String uf;
    final String cep;

    public Endereco4(String logradouro, String bairro, String cidade, String uf, String cep) {
        super();
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
    }
}

//----------------------------------------------------

interface Enderecador4 {
    String preparaEndereco(Endereco4 endereco);
}

//----------------------------------------------------

class EnderecadorSimples4 implements Enderecador4 {
    public String preparaEndereco(Endereco4 endereco) {
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

abstract class EnderecadorDecorator implements Enderecador4 {
    Enderecador4 enderecador;

    public EnderecadorDecorator(Enderecador4 enderecador) {
        super();
        this.enderecador = enderecador;
    }
}

//----------------------------------------------------

class EnderecadorCaixaAlta4 extends EnderecadorDecorator {
    
    public EnderecadorCaixaAlta4(Enderecador4 enderecador) {
        super(enderecador);
    }
    
    public String preparaEndereco(Endereco4 endereco) {
        return enderecador.preparaEndereco(endereco).toUpperCase();
    }
    
}

//----------------------------------------------------

class EnderecadorComBorda4 extends EnderecadorDecorator {

    public EnderecadorComBorda4(Enderecador4 enderecador) {
        super(enderecador);
    }

    public String preparaEndereco(Endereco4 endereco) {
        String preparaEndereco = enderecador.preparaEndereco(endereco);
        StringBuilder sb = new StringBuilder();
        sb.append("---------------------\n");
        preparaEndereco.lines().forEach(l -> sb.append("| " + l + "\n"));
        sb.append("---------------------");
        return sb.toString();
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