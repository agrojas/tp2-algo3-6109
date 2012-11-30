package testAvion;

import java.util.LinkedList;
import java.util.List;

import pista.Helipuerto;
import pista.PistaLarga;
import pista.PistaSimple;
import pista.PosicionesEntradaSobrantesException;
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
		List<Posicion> posicionPista = new LinkedList<Posicion>();
		posicionPista.add(posicionFinal);
		PistaLarga pistaLarga = new PistaLarga(posicionPista);
		
		AvionPesado avion = new AvionPesado(posicionInicial, posicionFinal,mapaDeJuego);
		
		assertTrue(avion.puedeAterrizar(pistaLarga));
	}
	
	public void testUnAvionPesadoNoPuedeAterrizarEnUnaPistaSimple() throws PosicionesEntradaVaciaException, PosicionesEntradaSobrantesException{
		
		Posicion posicionInicial= new Posicion(1,1);
		Posicion posicionFinal= new Posicion(5,5);
		List<Posicion> posicionPista = new LinkedList<Posicion>();
		posicionPista.add(posicionFinal);
		PistaSimple pistaSimple = new PistaSimple(posicionPista);
		
		AvionPesado avion = new AvionPesado(posicionInicial, posicionFinal,mapaDeJuego);
		
		assertFalse(avion.puedeAterrizar(pistaSimple));
	}
	
	public void testUnAvionPesadoNoPuedeAterrizarEnUnHelipuerto() throws PosicionesEntradaVaciaException{
		Posicion posicionInicial= new Posicion(1,1);
		Posicion posicionFinal= new Posicion(5,5);
		List<Posicion> posicionPista = new LinkedList<Posicion>();
		posicionPista.add(posicionFinal);
		Helipuerto helipuerto = new Helipuerto(posicionPista);
		
		
		AvionPesado avion = new AvionPesado(posicionInicial, posicionFinal,mapaDeJuego);
		
		assertFalse(avion.puedeAterrizar(helipuerto));
	}

	public void setUp() {
		
		mapaDeJuego = new Mapa();
	}
}
