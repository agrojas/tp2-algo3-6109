package testAvion;

import copControl.Posicion;
import avion.AvionSimple;
import junit.framework.TestCase;

public class AvionTest extends TestCase {
	
	/**
	 * Vale en general para todas las clases que heredan de avion
	 */
	public void testUnAvionSabeSiEstaVolando(){
		Posicion posicionInicial= new Posicion(2,2);
		Posicion posicionFinal= new Posicion(3,3);
		AvionSimple avion = new AvionSimple(posicionInicial,posicionFinal);
		assertTrue(avion.getEstaVolando());
		
	}
	
	
	
	
}
