package testPista;

import junit.framework.TestCase;
import java.util.List;
import copControl.Posicion;
import pista.PistaSimple;
import pista.PosicionesEntradaSobrantesException;
import pista.PosicionesEntradaVaciaException;

public class PistaSimpleTest extends TestCase {

	private List<Posicion> posicionesDeEntrada;
	
	public void crearPistaSimple() throws PosicionesEntradaVaciaException, PosicionesEntradaSobrantesException{
		Posicion unaPosicion= new Posicion (1,1);
		posicionesDeEntrada.add(unaPosicion);
		PistaSimple pistaSimple= new PistaSimple(posicionesDeEntrada);
		//assertEquals(posicionesDeEntrada,pistaSimple.getPosicionesDeEntrada());
		assertTrue((pistaSimple.getPosicionesEntrada()).contains(unaPosicion) );
		
	}
	
	
}


