package testAvion;

import avion.AvionSimple;
import copControl.Posicion;
import junit.framework.TestCase;

public class AvionSimpleTest extends TestCase {
	
	public void testUnAvionSimpleSeMueveDeUnaPosicionAOtra(){
		Posicion posicionInicial= new Posicion(1,1);
		Posicion posicionFinal= new Posicion(5,5);
		AvionSimple avion = new AvionSimple(posicionInicial,posicionFinal);	
		assertEquals(avion.getPosicionActual(), posicionFinal);
		
	}
	public void testUnAvionSimplePuedeAterrizarEnUnaPistaSimple(){

	}

}
