package dev.rinaldo.designpatterns.creational;

/**
 * Java Design Patterns - Factory Method (2)
 * 
 * @author youtube.com/RinaldoDev
 */
public class FactoryMethod_2 {

  // Criador Concreto
  // Produto Abstrato
  // Produto Concreto  
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Categoria2 categoria2 = new Categoria2();
		Produto2 produto2 = categoria2.novoProduto();
	}

}

interface Produto2 {
}

class ProdutoDigital2 implements Produto2 {
}

class ProdutoFisico2 implements Produto2 {
}

class Categoria2 {
  
//  private String nome;
//  private Tipo tipo;
//  private Integer prioridade;
  
	public Produto2 novoProduto() {
	  // ...
		return new ProdutoFisico2();
	}
}

class CategoriaDigital extends Categoria2 {
  public Produto2 novoProduto() {
    // ...
    return new ProdutoDigital2();
  }
}

// Twitter: twitter.com/rinaldodev
// LinkedIn: linkedin.com/in/rinaldodev
// Twitch: twitch.tv/rinaldodev
// GitHub: github.com/rinaldodev
// Facebook: facebook.com/rinaldodev
// Site: rinaldo.dev
