package testAvion;

import java.util.LinkedList;
import java.util.List;

import pista.Helipuerto;
import pista.PistaLarga;
import pista.PistaSimple;
import avion.AvionPesado;
import copControl.Posicion;
import junit.framework.TestCase;

public class AvionPesadoTest extends TestCase {
	
	public void testUnAvionPesadoPuedeAterrizarEnUnaPistaLarga(){
		Posicion posicionInicial= new Posicion(1,1);
		Posicion posicionFinal= new Posicion(5,5);
		List<Posicion> posicionPista = new LinkedList<Posicion>();
		posicionPista.add(posicionFinal);
		PistaLarga pistaLarga = new PistaLarga(posicionPista);
		
		AvionPesado avion = new AvionPesado(posicionInicial, posicionFinal);
		
		assertTrue(avion.puedeAterrizar(pistaLarga));
	}
	
	public void testUnAvionPesadoNoPuedeAterrizarEnUnaPistaSimple(){
		Posicion posicionInicial= new Posicion(1,1);
		Posicion posicionFinal= new Posicion(5,5);
		List<Posicion> posicionPista = new LinkedList<Posicion>();
		posicionPista.add(posicionFinal);
		PistaSimple pistaSimple = new PistaSimple(posicionPista);
		
		AvionPesado avion = new AvionPesado(posicionInicial, posicionFinal);
		
		assertFalse(avion.puedeAterrizar(pistaSimple));
	}
	
	public void testUnAvionPesadoNoPuedeAterrizarEnUnHelipuerto(){
		Posicion posicionInicial= new Posicion(1,1);
		Posicion posicionFinal= new Posicion(5,5);
		List<Posicion> posicionPista = new LinkedList<Posicion>();
		posicionPista.add(posicionFinal);
		Helipuerto helipuerto = new Helipuerto(posicionPista);
		
		AvionPesado avion = new AvionPesado(posicionInicial, posicionFinal);
		
		assertFalse(avion.puedeAterrizar(helipuerto));
	}

}
