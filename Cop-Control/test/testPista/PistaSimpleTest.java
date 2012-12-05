package testPista;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;
import copControl.Posicion;
import pista.PistaSimple;
import pista.PosicionesEntradaSobrantesException;
import pista.PosicionesEntradaVaciaException;

public class PistaSimpleTest extends TestCase {

	private Posicion posicionesDeEntrada;
	
	public void testCrearPistaSimple() throws PosicionesEntradaVaciaException, PosicionesEntradaSobrantesException{
		Posicion posicionDeEntrada= new Posicion (1,1);
	
		PistaSimple pistaSimple= new PistaSimple(posicionDeEntrada);
		//assertEquals(posicionesDeEntrada,pistaSimple.getPosicionesDeEntrada());
		assertTrue(pistaSimple.getPosicionEntrada()==posicionDeEntrada) ;
		
	}
	
	
	
}


