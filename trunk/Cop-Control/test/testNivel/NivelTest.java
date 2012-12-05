package testNivel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


import pista.Pista;
import pista.PistaLarga;
import pista.PistaSimple;
import pista.PosicionesEntradaSobrantesException;
import pista.PosicionesEntradaVaciaException;
import avion.Avion;
import avion.AvionSimple;
import avion.AvionPesado;
import avion.Helicoptero;
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
	private Posicion posicionPista;
	private Posicion posicionFinAvion;
	
	//BORRAR
	private List<Posicion> posicionPistaLarga ;
	private Posicion posicionEntradaPistaLarga;
	private PistaLarga pistaLarga;
	
	public void testUnNivelDeberiaAterrizarAvionesSiHayAlgunAvionConPosicionDePista(){
		Posicion posicionFinal = new Posicion(1,1);
		AvionSimple avionSimple= new AvionSimple(posicionEntradaPista,posicionFinal, mapa);
		
		assertTrue (nivel.getAvionesVolando().isEmpty());
		
		nivel.colocarAvionEnAire(avionSimple);
		
		assertFalse (nivel.getAvionesVolando().isEmpty());
		
		int cantidadAvionesAterrizados= nivel.aterrizarAviones();
		
		assertTrue(cantidadAvionesAterrizados==1);
		
	}
	
	public void testUnNivelNoDeberiaAterrizarAvionesSiNoHayAlgunAvionConPosicionDePista(){
		Posicion posicionFinal = new Posicion(1,1);
		AvionSimple avionSimple= new AvionSimple(posicionInicioAvion,posicionFinal, mapa);
		nivel.colocarAvionEnAire(avionSimple);

		assertTrue((nivel.aterrizarAviones())==1); 
		
		
	}
	
	
	public void testDeberiaHaberChoqueAlColocarAvionesConMismaPosicionInicial(){
		
		Posicion posicionInicial = new Posicion(1,1);
		Posicion posicionInicialBis = new Posicion(2,3);	
		Posicion posicionFinal= new Posicion(2,3);
		
		AvionSimple avionSimple1= new AvionSimple(posicionInicial,posicionFinal,mapa);
		AvionSimple avionSimple2= new AvionSimple(posicionInicialBis,posicionFinal,mapa);
		AvionPesado avionPesado1= new AvionPesado(posicionInicialBis,posicionFinal,mapa);
		
		
		nivel.colocarAvionEnAire(avionSimple1);
		nivel.colocarAvionEnAire(avionSimple2);
		nivel.colocarAvionEnAire(avionPesado1);
		

		assertTrue(nivel.huboChoque());
				
	}
	
	
public void testNoDeberiaHaberChoqueAlColocarAvionesConPosicionInicialDistinta(){
		
		Posicion posicionInicial = new Posicion(1,1);
		Posicion posicionInicialBis = new Posicion(100,30);	
		Posicion posicionFinal= new Posicion(21,82);
		
		AvionSimple avionSimple1= new AvionSimple(posicionInicial,posicionFinal,mapa);
		AvionSimple avionSimple2= new AvionSimple(posicionInicialBis,posicionFinal,mapa);
		AvionPesado avionPesado1= new AvionPesado(posicionFinal,posicionInicialBis,mapa);
		
		nivel.colocarAvionEnAire(avionSimple1);
		nivel.colocarAvionEnAire(avionPesado1);
		nivel.colocarAvionEnAire(avionSimple2);
			

		assertFalse(nivel.huboChoque());
				
	}
	
	
	//Borrar luego. Solo sirve para chequear metodo remove
	public void testRemueveElementoDeLaLista(){
		
		List<Avion> avionesVolando= new LinkedList();
		boolean verificacion;
		Posicion posicionInicial= new Posicion(1,2);
		
		AvionSimple avionSimple= new AvionSimple(posicionInicial,posicionInicial, mapa);
		AvionPesado avionPesado= new AvionPesado(posicionInicial,posicionInicial, mapa);
		
		avionesVolando.add(avionSimple);
		avionesVolando.add(avionPesado);
		
		verificacion= avionesVolando.remove(avionSimple);
		
		assertTrue(true);
		
		
	}
	
	
	public void testUnNivelAterrizaAvionesQuePuedanAterrizar(){
		
		avionSimple= new AvionSimple(posicionInicioAvion, posicionFinAvion, mapa);
		mapa.colocarAvionEnAire(avionSimple);
		int cantidadAvionesAterrizados= nivel.aterrizarAviones();
		assertFalse(nivel.tieneAvionesVolando());
	
	}
	public void testColocarAvionSimpleEnAire(){
		
		avionSimple= new AvionSimple(posicionInicioAvion, posicionFinAvion,mapa);
		mapa.colocarAvionEnAire(avionSimple);
		assertTrue(nivel.tieneAvionesVolando());
	}
	
	public void testAlCrearAvionSimpleYPistaSimpleDeberiaTenerPistaAdecuada(){
		
		avionSimple= new AvionSimple(posicionInicioAvion, posicionFinAvion,mapa);
		assertTrue(nivel.tienePistaAdecuada(avionSimple));
		
	}
	
	public void testAlCrearHelicopteroSinHelipuertoNoDeberiaTenerPistaAdecuada() throws PosicionesEntradaVaciaException{
		
		Helicoptero helicoptero= new Helicoptero(posicionInicioAvion, posicionFinAvion,mapa);
		assertFalse(nivel.tienePistaAdecuada(helicoptero));
		
	}
	public void setUp() throws PosicionesEntradaVaciaException, PosicionesEntradaSobrantesException{
		dificultad= new Dificultad(1, 1, 1);
		pistas = new ArrayList<Pista>();
		posicionInicioAvion = new Posicion(1, 1);
		posicionFinAvion = new Posicion(2,3);
	
		posicionPista = new Posicion(3, 3);
		pistaSimple= new PistaSimple(posicionPista);
		pistas.add(pistaSimple);
		mapa = new Mapa(pistas);
		nivel = new Nivel(mapa, dificultad);
		
		
	}
}
