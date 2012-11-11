package testAvion;

import java.util.LinkedList;
import java.util.List;

import pista.Helipuerto;
import pista.PistaSimple;
import avion.AvionSimple;
import copControl.Posicion;
import junit.framework.TestCase;

public class AvionSimpleTest extends TestCase {
	
//	public void testUnAvionSimpleSeMueveDeUnaPosicionAOtra(){
//		Posicion posicionInicial= new Posicion(1,1);
//		Posicion posicionFinal= new Posicion(5,5);
//		AvionSimple avion = new AvionSimple(posicionInicial,posicionFinal);	
//		assertEquals(avion.getPosicionActual(), posicionFinal);
//		
//	}
	
	public void testUnAvionSimplePuedeAterrizarEnUnaPistaSimple(){
		Posicion posicionInicial= new Posicion(1,1);
		Posicion posicionFinal= new Posicion(5,5);
		List<Posicion> posicionPista = new LinkedList<Posicion>();
		posicionPista.add(posicionFinal);
		PistaSimple pistaSimple = new PistaSimple(posicionPista);
		
		AvionSimple avion = new AvionSimple(posicionInicial, posicionFinal);
		
		assertTrue(avion.puedeAterrizar(pistaSimple));
	}
	
	public void testUnAvionSimpleNoPuedeAterrizarEnUnHelipuerto(){
		Posicion posicionInicial= new Posicion(1,1);
		Posicion posicionFinal= new Posicion(5,5);
		List<Posicion> posicionPista = new LinkedList<Posicion>();
		posicionPista.add(posicionFinal);
		Helipuerto helipuerto = new Helipuerto(posicionPista);
		
		AvionSimple avion = new AvionSimple(posicionInicial, posicionFinal);
		
		assertFalse(avion.puedeAterrizar(helipuerto));
	}


}
