package testAvion;

import java.util.LinkedList;
import java.util.List;

import pista.Helipuerto;
import pista.PistaLarga;
import pista.PistaSimple;
import pista.PosicionesEntradaVaciaException;
import avion.AvionPesado;
import copControl.Mapa;
import copControl.Posicion;
import junit.framework.TestCase;

public class AvionPesadoTest extends TestCase {
	
	private Mapa mapaDeJuego;
	
	public void testUnAvionPesadoPuedeAterrizarEnUnaPistaLarga() throws PosicionesEntradaVaciaException{
		Posicion posicionInicial= new Posicion(1,1);
		Posicion posicionFinal= new Posicion(5,5);
		PistaLarga pistaLarga = new PistaLarga(posicionFinal);
		
		AvionPesado avion = new AvionPesado(posicionInicial, posicionFinal,mapaDeJuego);
		
		assertTrue(avion.puedeAterrizar(pistaLarga));
	}
	
	public void testUnAvionPesadoNoPuedeAterrizarEnUnaPistaSimple() throws PosicionesEntradaVaciaException{
		
		Posicion posicionInicial= new Posicion(1,1);
		Posicion posicionFinal= new Posicion(5,5);
		PistaSimple pistaSimple = new PistaSimple(posicionFinal);
		
		AvionPesado avion = new AvionPesado(posicionInicial, posicionFinal,mapaDeJuego);
		
		assertFalse(avion.puedeAterrizar(pistaSimple));
	}
	
	public void testUnAvionPesadoNoPuedeAterrizarEnUnHelipuerto() throws PosicionesEntradaVaciaException{
		Posicion posicionInicial= new Posicion(1,1);
		Posicion posicionFinal= new Posicion(5,5);
		Helipuerto helipuerto = new Helipuerto(posicionFinal);
		
		
		AvionPesado avion = new AvionPesado(posicionInicial, posicionFinal,mapaDeJuego);
		
		assertFalse(avion.puedeAterrizar(helipuerto));
	}

	public void setUp() {
		
		mapaDeJuego = new Mapa();
	}
}
