package testJugador;

import java.util.ArrayList;
import java.util.List;

import copControl.Dificultad;
import copControl.Helipuerto;
import copControl.Jugador;
import copControl.Mapa;
import copControl.Nivel;
import copControl.PistaDoble;
import copControl.PistaLarga;
import copControl.PistaSimple;
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
	
	
	
	public void setUp(){
		String nombre = "Pepe";	
		
		jugador = new Jugador(nombre);
		pistaSimple = new PistaSimple(posicionesPistaSimple);
		pistaDoble = new PistaDoble(posicionesPistaDoble);
		pistaLarga = new PistaLarga(posicionesPistaLarga);
		helipuerto = new Helipuerto(posicionesHelipuerto);
		mapa = new Mapa(pistaSimple,pistaDoble,pistaLarga,helipuerto);
		dificultad= new Dificultad(1,1,1);
		nivel = new Nivel(mapa,dificultad);
		jugador.setNivelActual(nivel);
		
	}
	

}
