package testPosicion;

import copControl.Posicion;
import junit.framework.TestCase;

public class PosicionTest extends TestCase {
	
	public void testLaDistanciaEntreUnaPosicionYOtraDebeSerCoherente(){
		Posicion posicion1= new Posicion(1, 1);
		Posicion posicion2= new Posicion(4, 5);
		//El valor real es 5
		assertTrue(posicion1.distanciaHasta(posicion2)==5);		
		
	}

}
