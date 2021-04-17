package dev.rinaldo.designpatterns.creational;

/**
 * Java Design Patterns - Factory Method (1)
 * 
 * @author youtube.com/RinaldoDev
 */
public class FactoryMethod_1 {

	// Criador Abstrato
	// Produto Abstrato
	// Criador Concreto
	// Produto Concreto
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Categoria categoria = new Digital();
		Produto produto = categoria.novoProduto();
	}

}

interface Produto {
}

class ProdutoDigital implements Produto {
}

class ProdutoFisico implements Produto {
}

interface Categoria {
	Produto novoProduto();
}

class Digital implements Categoria {
	@Override
	public Produto novoProduto() {
	  // ...
		return new ProdutoDigital();
	}
}

class Fisico implements Categoria {
	@Override
	public Produto novoProduto() {
    // ...	  
		return new ProdutoFisico();
	}
}

// Mais flex�vel para cria��o de objetos
// Permite trabalhar com hierarquias paralelas

// Twitter: twitter.com/rinaldodev
// LinkedIn: linkedin.com/in/rinaldodev
// Twitch: twitch.tv/rinaldodev
// GitHub: github.com/rinaldodev
// Facebook: facebook.com/rinaldodev
// Site: rinaldo.dev
