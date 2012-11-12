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
	
	public void testGenerarPosicionExtremoAlAzarConDimensionMax(){
		Posicion posicionExtremoAlAzar = mapa.generarPosicionExtremoAlAzar();
		Integer posX = (posicionExtremoAlAzar.getCoordenadaX());
		Integer posY = (posicionExtremoAlAzar.getCoordenadaY());
		Boolean posicionDentroDeDimension=false;
		posicionDentroDeDimension= ((posX<=mapa.getDimension()) && (posX>=0) && (posY<=mapa.getDimension()) && (posY>=0));
		
		assertTrue(posicionDentroDeDimension);
	}
	public void testGetPosicionExtremoDevuelveListaConDosPosicionesExtremoAlAzar(){
		List<Posicion> posicionesExtremoAlAzar = mapa.getPosicionesExtremos();
		
		Integer pos0X = (posicionesExtremoAlAzar.get(0).getCoordenadaX());
		Integer pos0Y = (posicionesExtremoAlAzar.get(0).getCoordenadaY());
		
		Integer pos1X = (posicionesExtremoAlAzar.get(1).getCoordenadaX());
		Integer pos1Y = (posicionesExtremoAlAzar.get(1).getCoordenadaY());
		
		Boolean posicion0DentroDeDimension=false;
		posicion0DentroDeDimension= ((pos0X<=mapa.getDimension()) && (pos0X>=0) && (pos0Y<=mapa.getDimension()) && (pos0Y>=0));
		
		Boolean posicion1DentroDeDimension=false;
		posicion1DentroDeDimension= ((pos1X<=mapa.getDimension()) && (pos1X>=0) && (pos1Y<=mapa.getDimension()) && (pos1Y>=0));
		
		assertTrue(posicion0DentroDeDimension);
		assertTrue(posicion1DentroDeDimension);
		
	}
	


}
	
