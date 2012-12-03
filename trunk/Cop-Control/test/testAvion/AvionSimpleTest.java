package testAvion;

import java.util.LinkedList;
import java.util.List;

import pista.Helipuerto;
import pista.PistaSimple;
import pista.PosicionesEntradaSobrantesException;
import pista.PosicionesEntradaVaciaException;
import avion.AvionSimple;
import copControl.Mapa;
import copControl.Posicion;
import junit.framework.TestCase;

public class AvionSimpleTest extends TestCase {
	
	Mapa mapaDeJuego;
	public void testUnAvionSimpleSeMueveDeUnaPosicionAOtra(){
	
	}
	
	public void testUnAvionSimplePuedeAterrizarEnUnaPistaSimple() throws PosicionesEntradaVaciaException, PosicionesEntradaSobrantesException{
		Posicion posicionInicial= new Posicion(1,1);
		Posicion posicionFinal= new Posicion(5,5);
		List<Posicion> posicionPista = new LinkedList<Posicion>();
		posicionPista.add(posicionFinal);
		PistaSimple pistaSimple = new PistaSimple(posicionPista);
		
		AvionSimple avion = new AvionSimple(posicionInicial, posicionFinal,mapaDeJuego);
		
		assertTrue(avion.puedeAterrizar(pistaSimple));
	}
	
	public void testUnAvionSimpleNoPuedeAterrizarEnUnHelipuerto() throws PosicionesEntradaVaciaException{
		Posicion posicionInicial= new Posicion(1,1);
		Posicion posicionFinal= new Posicion(5,5);
		List<Posicion> posicionPista = new LinkedList<Posicion>();
		posicionPista.add(posicionFinal);
		Helipuerto helipuerto = new Helipuerto(posicionPista);
		
		AvionSimple avion = new AvionSimple(posicionInicial, posicionFinal,mapaDeJuego);
		
		assertFalse(avion.puedeAterrizar(helipuerto));
	}

	public void testUnaPosicionDentroDelRadioDelAvionDebeDevolverTrue() {
		Posicion posicionInicial= new Posicion(30,30);
		Posicion posicionFinal= new Posicion(3,9);
		Posicion posicionDePrueba=new Posicion(31,31);
		
		
		AvionSimple avion = new AvionSimple(posicionInicial, posicionFinal,mapaDeJuego);
		assertTrue(avion.esPosicionContenida(posicionDePrueba));
		
	}
	
	
	
	public void setUp(){
		
		mapaDeJuego = new Mapa();
	}
	
	
	
}
