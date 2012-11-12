package testAvion;

import java.util.LinkedList;
import java.util.List;

import pista.Helipuerto;
import pista.PistaSimple;
import avion.AvionComputarizado;
import copControl.Posicion;
import junit.framework.TestCase;

public class AvionComputarizadoTest extends TestCase {
	
	public void testUnAvionComputarizadoPuedeAterrizarEnUnaPistaSimple(){
		Posicion posicionInicial= new Posicion(1,1);
		Posicion posicionFinal= new Posicion(5,5);
		List<Posicion> posicionPista = new LinkedList<Posicion>();
		posicionPista.add(posicionFinal);
		PistaSimple pistaSimple = new PistaSimple(posicionPista);
		
		AvionComputarizado avion = new AvionComputarizado(posicionInicial, posicionFinal);
		
		assertTrue(avion.puedeAterrizar(pistaSimple));
	}
	
	public void testUnAvionComputarizadoNoPuedeAterrizarEnUnHelipuerto(){
		Posicion posicionInicial= new Posicion(1,1);
		Posicion posicionFinal= new Posicion(5,5);
		List<Posicion> posicionPista = new LinkedList<Posicion>();
		
		
		posicionPista.add(posicionFinal);
		Helipuerto helipuerto = new Helipuerto(posicionPista);
		
		AvionComputarizado avion = new AvionComputarizado(posicionInicial, posicionFinal);
		
		assertFalse(avion.puedeAterrizar(helipuerto));
	}

}
