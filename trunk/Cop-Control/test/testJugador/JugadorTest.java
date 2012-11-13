package testJugador;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import pista.Helipuerto;
import pista.Pista;
import pista.PistaDoble;
import pista.PistaLarga;
import pista.PistaSimple;
import pista.PosicionesEntradaSobrantesException;
import pista.PosicionesEntradaVaciaException;

import copControl.Dificultad;
import copControl.Jugador;
import copControl.Mapa;
import copControl.Nivel;
import copControl.Posicion;
import junit.framework.TestCase;

public class JugadorTest extends TestCase {
	private Nivel nivel;
	private Jugador jugador;
	private Mapa mapa;
	private PistaSimple pistaSimple;
	private PistaDoble pistaDoble;
	private PistaLarga pistaLarga;
	private Helipuerto helipuerto;
	private List<Pista> pistas;
	private Dificultad dificultad;
	private List<Posicion> posicionesPistaSimple= new ArrayList<Posicion>();
	private List<Posicion> posicionesPistaDoble= new ArrayList<Posicion>();
	private List<Posicion> posicionesPistaLarga= new ArrayList<Posicion>();
	private List<Posicion> posicionesHelipuerto= new ArrayList<Posicion>();
	
	public void testJugadorDebeInicializarseConNombre(){
		String nombre = "Pepe";
		assertEquals(nombre, jugador.getNombre());
	}
	
	public void testMarcarAvionRecibePosicionQueNoContieneAvionDevuelveFalse (){

		Posicion unaPosicion = new Posicion(2,1);
		assertFalse(jugador.marcarAvion(unaPosicion));	
	}
	
	
	
	public void setUp() throws PosicionesEntradaVaciaException, PosicionesEntradaSobrantesException{
		String nombre = "Pepe";	
		
		jugador = new Jugador(nombre);
		posicionesPistaSimple.add(new Posicion(1,2));
		posicionesPistaDoble.add(new Posicion(2,3));
		posicionesPistaLarga.add(new Posicion(3,4));
		posicionesHelipuerto.add(new Posicion(2,1));
		pistaSimple = new PistaSimple(posicionesPistaSimple);
		pistaDoble = new PistaDoble(posicionesPistaDoble);
		pistaLarga = new PistaLarga(posicionesPistaLarga);
		helipuerto = new Helipuerto(posicionesHelipuerto);
		pistas=new LinkedList<Pista>();
		pistas.add(pistaSimple);
		pistas.add(pistaDoble);
		pistas.add(pistaLarga);
		pistas.add(helipuerto);
		mapa = new Mapa(pistas);
		dificultad= new Dificultad(1,1,1);
		nivel = new Nivel(mapa,dificultad);
		jugador.setNivelActual(nivel);
		
	}
	

}
