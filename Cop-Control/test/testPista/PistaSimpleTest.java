package testPista;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;
import copControl.Posicion;
import pista.PistaSimple;
import pista.PosicionesEntradaSobrantesException;
import pista.PosicionesEntradaVaciaException;

public class PistaSimpleTest extends TestCase {

	private List<Posicion> posicionesDeEntrada;
	
	public void testCrearPistaSimple() throws PosicionesEntradaVaciaException, PosicionesEntradaSobrantesException{
		Posicion unaPosicion= new Posicion (1,1);
		posicionesDeEntrada= new ArrayList<Posicion>();
		posicionesDeEntrada.add(unaPosicion);
		PistaSimple pistaSimple= new PistaSimple(posicionesDeEntrada);
		//assertEquals(posicionesDeEntrada,pistaSimple.getPosicionesDeEntrada());
		assertTrue((pistaSimple.getPosicionesEntrada()).contains(unaPosicion) );
		
	}
	
	
}


