package testPista;

import junit.framework.TestCase;


import copControl.Posicion;
import pista.PistaSimple;
import pista.PosicionesEntradaVaciaException;

public class PistaSimpleTest extends TestCase {

	private Posicion posicionesDeEntrada;
	
	public void testCrearPistaSimple() throws PosicionesEntradaVaciaException{
		Posicion posicionDeEntrada= new Posicion (1,1);
	
		PistaSimple pistaSimple= new PistaSimple(posicionDeEntrada);
		//assertEquals(posicionesDeEntrada,pistaSimple.getPosicionesDeEntrada());
		assertTrue(pistaSimple.getPosicionEntrada()==posicionDeEntrada) ;
		
	}
	
	
	
}


