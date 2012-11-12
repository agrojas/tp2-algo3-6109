package testNivel;

import java.util.LinkedList;
import java.util.List;

import pista.Pista;
import pista.PistaSimple;
import avion.Avion;
import avion.AvionSimple;
import copControl.Dificultad;
import copControl.Mapa;
import copControl.Nivel;
import copControl.Posicion;
import junit.framework.TestCase;

public class NivelTest extends TestCase {
	
	/**
	 * Variables para el setUp
	 */
	private Nivel nivel;
	private Mapa mapa;
	private Dificultad dificultad;
	private AvionSimple avionSimple;
	private PistaSimple pistaSimple;
	private Posicion posicionEntradaPista;
	private Posicion posicionInicioAvion;
	private List<Pista> pistas;
	private List<Posicion> posicionPista;
	private Posicion posicionFinAvion;
	
	
	
	
	
	
	public void testUnNivelAterrizaAvionesQuePuedanAterrizar(){
		
		nivel.aterrizarAviones();
		assertTrue(nivel.tieneAvionesVolando());
	
	}
	public void testColocarAvionSimpleEnAire(){
		assertTrue(nivel.tieneAvionesVolando());
	}
	
	
	

	public void setUp(){
		dificultad= new Dificultad(1, 1, 1);
		pistas = new LinkedList<Pista>();
		posicionEntradaPista = new Posicion(3, 3);
		posicionInicioAvion = new Posicion(1, 1);
		posicionFinAvion = new Posicion(2,3);
		posicionPista = new LinkedList<Posicion>();
		posicionPista.add(posicionEntradaPista);
		pistaSimple= new PistaSimple(posicionPista);
		pistas.add(pistaSimple);
		mapa = new Mapa(pistas);
		avionSimple= new AvionSimple(posicionInicioAvion, posicionFinAvion);
		mapa.colocarAvionEnAire(avionSimple);
		nivel = new Nivel(mapa, dificultad);
		
		
	}
}
