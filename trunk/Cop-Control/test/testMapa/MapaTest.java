package testMapa;

import java.util.LinkedList;
import java.util.List;

import pista.Pista;
import pista.PistaSimple;
import avion.Avion;
import avion.AvionSimple;
import copControl.Mapa;
import copControl.Posicion;
import junit.framework.TestCase;

public class MapaTest extends TestCase {

	private Mapa mapa;
	private AvionSimple avionSimple;
	private PistaSimple pistaSimple;
	private Posicion posicionEntradaPista;
	private Posicion posicionInicioAvion;
	private List<Pista> pistas;
	private List<Posicion> posicionPista;
	
	public void setUp(){
		pistas = new LinkedList<Pista>();
		posicionEntradaPista = new Posicion(3, 3);
		posicionInicioAvion = new Posicion(1, 1);
		posicionPista = new LinkedList<Posicion>();
		posicionPista.add(posicionEntradaPista);
		pistaSimple= new PistaSimple(posicionPista);
		pistas.add(pistaSimple);
		mapa = new Mapa(pistas);
		avionSimple= new AvionSimple(posicionInicioAvion, posicionInicioAvion);
	}
	
	public void testColocarAvionSimpleEnAire(){
		mapa.colocarAvionEnAire(avionSimple);
		List<Avion> avionesEnAire= mapa.getAvionesEnAire();
		assertTrue(avionesEnAire.contains(avionSimple));
	}
	
	//x<50  y=0
	public void testGenerarPosicionExtremoSuperiorAlAzarConDimensionMax50(){
		Posicion posicionExtremoAlAzar = mapa.generarPosicionExtremoAlAzar();
		Integer posX = (posicionExtremoAlAzar.getCoordenadaX());
		Integer posY = (posicionExtremoAlAzar.getCoordenadaY());
		Boolean posicionDentroDeDimension=false;
		posicionDentroDeDimension= ((posX<=50) && (posX>=0) && (posY<=50) && (posY>=0));
		
		System.out.println(posX);
		System.out.println(posY);
		System.out.println(posicionDentroDeDimension);
		
		assertTrue(posicionDentroDeDimension);
	}

}
	
