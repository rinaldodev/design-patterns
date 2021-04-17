package dev.rinaldo.designpatterns.creational;

import java.text.NumberFormat;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Stream;

/**
 * Java Design Patterns - Factory Method (4)
 * 
 * @author youtube.com/RinaldoDev
 */
public class FactoryMethod_4 {

  // Virtual constructor
  
	public static void main(String[] args) {
		// Static Factory Methods
		Calendar.getInstance();
		NumberFormat.getInstance();
		Stream.of(1, 2, 3, 4);
		List.of(1, 2, 3, 4);
		Integer valueOf = Integer.valueOf("1234");
	}

}
// Twitter: twitter.com/rinaldodev
// LinkedIn: linkedin.com/in/rinaldodev/
// Twitch: twitch.tv/rinaldodev
// GitHub: github.com/rinaldodev
// Facebook: facebook.com/rinaldodev/
// Site: rinaldo.dev