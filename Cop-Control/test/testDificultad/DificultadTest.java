package testDificultad;

import copControl.Dificultad;
import junit.framework.TestCase;

public class DificultadTest extends TestCase {

	private int cantidadDeAvionesPorAterrizar;
	private int frecuenciaDeAparicion; 
	private int velocidad;
	private int valorDeDificultad;
	private Dificultad dificultad;
	
	public void testGetValorDeDificultad(){
		cantidadDeAvionesPorAterrizar=10;
		frecuenciaDeAparicion=4;
		velocidad=1;
		dificultad= new Dificultad(cantidadDeAvionesPorAterrizar,frecuenciaDeAparicion,velocidad);
		valorDeDificultad= dificultad.getValorDeDificultad();
		assertTrue(valorDeDificultad==15);
	}
}
