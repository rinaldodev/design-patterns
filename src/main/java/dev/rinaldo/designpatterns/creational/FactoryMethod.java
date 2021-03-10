package dev.rinaldo.designpatterns.creational;

import java.text.NumberFormat;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Stream;

public class FactoryMethod {

	public static void main(String[] args) {
		// factory methods
		MapaPadrao mapaPadrao = new MapaPadrao();
		Muro novoMuro = mapaPadrao.novoMuro();
		
		// static factory methods
		Calendar.getInstance();
		NumberFormat.getInstance();
		Stream.of(1, 2, 3, 4);
		List.of(1, 2, 3, 4);
		Integer.valueOf("1234");
	}
	
}

interface Mapa {
	Muro novoMuro();
}

interface Muro {
}

class MapaPadrao implements Mapa {
	@Override
	public Muro novoMuro() {
		return new MuroPadrao();
	}
}

class MuroPadrao implements Muro {
}