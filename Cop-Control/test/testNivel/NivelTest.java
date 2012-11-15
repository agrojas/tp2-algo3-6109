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
	private Posicion posicionEntradaPistaSimple;
	private Posicion posicionInicioAvion;
	private List<Pista> pistas;
	private List<Posicion> posicionPistaSimple;
	private Posicion posicionFinAvion;
	
	//BORRAR
	private List<Posicion> posicionPistaLarga ;
	private Posicion posicionEntradaPistaLarga;
	private PistaLarga pistaLarga;
	
	public void testUnNivelNoDeberiaAterrizarUnAvionPesadoEnUnaPistaSimple(){
		Posicion posicionFinal = new Posicion(1,1);
		AvionPesado avionPesado = new AvionPesado(posicionEntradaPistaSimple, posicionFinal);
		nivel.colocarAvionEnAire(avionPesado);		
		int cantAvionesVolandoInicialmente = nivel.getAvionesVolando().size();		
		nivel.aterrizarAviones();		
		int cantAvionesVolandoLuegoDeAterrizar =nivel.getAvionesVolando().size();		
		assertTrue(cantAvionesVolandoInicialmente == cantAvionesVolandoLuegoDeAterrizar);
		
	}
	
	public void testUnNivelDeberiaAterrizarAvionesSiHayAlgunAvionConPosicionDePista(){
		Posicion posicionFinal = new Posicion(1,1);
		AvionSimple avionSimple= new AvionSimple(posicionEntradaPistaSimple,posicionFinal);
		nivel.colocarAvionEnAire(avionSimple);
		
		int cantAvionesVolandoInicialmente = nivel.getAvionesVolando().size();
		
		nivel.aterrizarAviones();
		
		int cantAvionesVolandoLuegoDeAterrizar =nivel.getAvionesVolando().size();
		
		assertFalse(cantAvionesVolandoInicialmente == cantAvionesVolandoLuegoDeAterrizar);
		
	}
	
	public void testUnNivelNoDeberiaAterrizarAvionesSiHayAlgunAvionConPosicionDePista(){
		Posicion posicionFinal = new Posicion(1,1);
		AvionSimple avionSimple= new AvionSimple(posicionInicioAvion,posicionFinal);
		nivel.colocarAvionEnAire(avionSimple);
		int cantAvionesVolandoInicialmente = nivel.getAvionesVolando().size();
		 
		nivel.aterrizarAviones();
		int cantAvionesVolandoLuegoDeAterrizar =nivel.getAvionesVolando().size();
		
		assertTrue(cantAvionesVolandoInicialmente == cantAvionesVolandoLuegoDeAterrizar);
		
	}
	
	
	public void testDeberiaHaberChoqueAlColocarAvionesConMismaPosicionInicial(){
		
		Posicion posicionInicial = new Posicion(1,1);
		Posicion posicionInicialBis = new Posicion(2,3);	
		Posicion posicionFinal= new Posicion(2,3);
		
		AvionSimple avionSimple1= new AvionSimple(posicionInicial,posicionFinal);
		AvionSimple avionSimple2= new AvionSimple(posicionInicialBis,posicionFinal);
		AvionPesado avionPesado1= new AvionPesado(posicionInicialBis,posicionFinal);
		
		
		nivel.colocarAvionEnAire(avionSimple1);
		nivel.colocarAvionEnAire(avionSimple2);
		nivel.colocarAvionEnAire(avionPesado1);
		

		assertTrue(nivel.huboChoque());
				
	}
	
	
public void testNoDeberiaHaberChoqueAlColocarAvionesConPosicionInicialDistinta(){
		
		Posicion posicionInicial = new Posicion(1,1);
		Posicion posicionInicialBis = new Posicion(2,3);	
		Posicion posicionFinal= new Posicion(2,8);
		
		AvionSimple avionSimple1= new AvionSimple(posicionInicial,posicionFinal);
		AvionSimple avionSimple2= new AvionSimple(posicionInicialBis,posicionFinal);
		AvionPesado avionPesado1= new AvionPesado(posicionFinal,posicionInicialBis);
		
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
		
		AvionSimple avionSimple= new AvionSimple(posicionInicial,posicionInicial);
		AvionPesado avionPesado= new AvionPesado(posicionInicial,posicionInicial);
		
		avionesVolando.add(avionSimple);
		avionesVolando.add(avionPesado);
		
		verificacion= avionesVolando.remove(avionSimple);
		
		assertTrue(true);
		
		
	}
	
	
	//solo para comprobar. BORRAR
	public void testCompruebaMetodoIgualAPosicion(){
		
		Posicion posicion1= new Posicion (1,1);
		Posicion posicion2 = new Posicion (1,1);
		
		assertTrue(posicion1.igualA(posicion2));
		
		
	}
	
	
	public void testUnNivelAterrizaAvionesQuePuedanAterrizar(){
		
		avionSimple= new AvionSimple(posicionInicioAvion, posicionFinAvion);
		mapa.colocarAvionEnAire(avionSimple);
		nivel.aterrizarAviones();
		assertTrue(nivel.tieneAvionesVolando());
	
	}
	public void testColocarAvionSimpleEnAire(){
		
		avionSimple= new AvionSimple(posicionInicioAvion, posicionFinAvion);
		mapa.colocarAvionEnAire(avionSimple);
		assertTrue(nivel.tieneAvionesVolando());
	}
	
	public void testAlCrearAvionSimpleYPistaSimpleDeberiaTenerPistaAdecuada(){
		
		avionSimple= new AvionSimple(posicionInicioAvion, posicionFinAvion);
		assertTrue(nivel.tienePistaAdecuada(avionSimple));
		
	}
	
	public void testAlCrearAvionPesadoSinPistaLargaNoDeberiaTenerPistaAdecuada() throws PosicionesEntradaVaciaException{
		
		AvionPesado avionPesado= new AvionPesado(posicionInicioAvion, posicionFinAvion);
		assertFalse(nivel.tienePistaAdecuada(avionPesado));
		
	}
	public void setUp() throws PosicionesEntradaVaciaException, PosicionesEntradaSobrantesException{
		dificultad= new Dificultad(1, 1, 1);
		pistas = new ArrayList<Pista>();
		posicionInicioAvion = new Posicion(1, 1);
		posicionFinAvion = new Posicion(2,3);
	
		posicionEntradaPistaSimple = new Posicion(3, 3);
		posicionPistaSimple = new ArrayList<Posicion>();
		posicionPistaSimple.add(posicionEntradaPistaSimple);
		
		posicionEntradaPistaLarga= new Posicion(4,4);
		posicionPistaLarga= new ArrayList<Posicion>();
		posicionPistaLarga.add(posicionEntradaPistaLarga);
		
		pistaSimple= new PistaSimple(posicionPistaSimple);
		pistaLarga= new PistaLarga(posicionPistaLarga);
		pistas.add(pistaLarga);
		pistas.add(pistaSimple);
		mapa = new Mapa(pistas);
		nivel = new Nivel(mapa, dificultad);
		
		
	}
}
