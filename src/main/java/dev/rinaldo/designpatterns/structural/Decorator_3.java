package dev.rinaldo.designpatterns.structural;

/**
 * Java Design Patterns - Decorator (3)
 * 
 * @author youtube.com/RinaldoDev
 */
public class Decorator_3 {

    public static void main(String[] args) {
        Endereco3 endereco = new Endereco3("Rua 4 Casa 133", "Centro", "São José", "RN", "50930-133");

        Enderecador3 enderecador = new EnderecadorSimples3();
        enderecador = new EnderecadorCaixaAlta3(enderecador);
        enderecador = new EnderecadorComBorda3(enderecador);

        String enderecoFormatado = enderecador.preparaEndereco(endereco);

        System.out.println(enderecoFormatado);
    }

}

//----------------------------------------------------

class Endereco3 {
    final String logradouro;
    final String bairro;
    final String cidade;
    final String uf;
    final String cep;

    public Endereco3(String logradouro, String bairro, String cidade, String uf, String cep) {
        super();
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
    }
}

//----------------------------------------------------

interface Enderecador3 {
    String preparaEndereco(Endereco3 endereco);
}

//----------------------------------------------------

class EnderecadorSimples3 implements Enderecador3 {
    public String preparaEndereco(Endereco3 endereco) {
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

class EnderecadorCaixaAlta3 implements Enderecador3 {

    Enderecador3 enderecador;

    public EnderecadorCaixaAlta3(Enderecador3 enderecador) {
        super();
        this.enderecador = enderecador;
    }

    public String preparaEndereco(Endereco3 endereco) {
        return enderecador.preparaEndereco(endereco).toUpperCase();
    }
}

//----------------------------------------------------

class EnderecadorComBorda3 implements Enderecador3 {

    Enderecador3 enderecador;

    public EnderecadorComBorda3(Enderecador3 enderecador) {
        super();
        this.enderecador = enderecador;
    }

    public String preparaEndereco(Endereco3 endereco) {
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