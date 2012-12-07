package testJugador;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import avion.Avion;
import avion.AvionSimple;

import pista.Helipuerto;
import pista.Pista;
import pista.PistaDoble;
import pista.PistaLarga;
import pista.PistaSimple;
import pista.PosicionesEntradaVaciaException;

import copControl.Dificultad;
import copControl.Juego;
import copControl.Jugador;
import copControl.Mapa;
import copControl.Nivel;
import copControl.Posicion;
import junit.framework.TestCase;

public class JugadorTest extends TestCase {
    private Nivel nivel1;
    private Nivel nivel2;
    private Nivel nivel3;
    private Mapa mapa;
    private Dificultad dificultad;
    private AvionSimple avionSimple;
    private PistaSimple pistaSimple;
    private Posicion posicionEntradaPista;
    private Posicion posicionInicioAvion;
    private List<Pista> pistas;
    private List<Posicion> posicionPista;
    private Posicion posicionFinAvion;
    private List<Nivel> niveles;
    private Jugador jugador;
    private Juego juego;
    
	public void testJugadorDebeInicializarseConNombre(){
		String nombre = "PEPE";
		assertEquals(nombre, jugador.getNombre());
	}
	
	public void testUnJugadorDeberiaPoderMarcarUnAvionSiEligeUnaPosicionDentroDelRadioDelAvion(){
		juego= new Juego (jugador,niveles);
		juego.vivir();
        juego.colocarAvion();
        Posicion posicionDelAvionCreado = juego.getNivelActual().getAvionesVolando().get(0).getPosicionActual();
        Avion avionEnJuego = juego.getNivelActual().getAvionEnPosicion(posicionDelAvionCreado);
        jugador.moverHacia((int)posicionDelAvionCreado.getCoordenadaX(),(int)posicionDelAvionCreado.getCoordenadaY());
        assertTrue(avionEnJuego.estaMarcado());
		
	}	
	
	public void testUnJugadorDeberiaPoderMarcarEIndicarleUnaNuevaTrayectoriaAUnAvion(){
		juego= new Juego (jugador,niveles);
		juego.vivir();
        juego.colocarAvion();
        Posicion posicionDelAvionCreado = juego.getNivelActual().getAvionesVolando().get(0).getPosicionActual();
        Avion avionEnJuego = juego.getNivelActual().getAvionEnPosicion(posicionDelAvionCreado);
        jugador.moverHacia((int)posicionDelAvionCreado.getCoordenadaX(),(int)posicionDelAvionCreado.getCoordenadaY());
        Posicion nuevaPosicion = new Posicion(10, 10);
        jugador.moverHacia((int)nuevaPosicion.getCoordenadaX(),(int)nuevaPosicion.getCoordenadaY());
        
        assertTrue(avionEnJuego.getDestinoActual().igualA(nuevaPosicion));
		
	}	
	
	
	public void testUnJugadorDeberiaPoderMarcarUnAvionYLuegoOtroQuedandoElPrimeroDesmarcado(){
		
		juego= new Juego (jugador,niveles);
		juego.vivir();
        juego.colocarAvion();
        
    	juego.vivir();
        juego.colocarAvion();
        
        Posicion posicionDelAvionCreado = juego.getNivelActual().getAvionesVolando().get(0).getPosicionActual();
        Avion primerAvionMarcado = juego.getNivelActual().getAvionEnPosicion(posicionDelAvionCreado);
        
        jugador.moverHacia((int)posicionDelAvionCreado.getCoordenadaX(),(int)posicionDelAvionCreado.getCoordenadaY());
      
        
        Posicion posicionDelSegundoAvionCreado = juego.getNivelActual().getAvionesVolando().get(1).getPosicionActual();
       // Avion segundoAvionMarcado = juego.getNivelActual().getAvionEnPosicion(posicionDelSegundoAvionCreado);
        jugador.moverHacia((int)posicionDelSegundoAvionCreado.getCoordenadaX(),(int)posicionDelSegundoAvionCreado.getCoordenadaY());
        
        assertFalse(primerAvionMarcado.estaMarcado());
	}
	public void setUp() throws PosicionesEntradaVaciaException{
	    dificultad= new Dificultad(1, 1, 1);
        pistas = new LinkedList<Pista>();
        posicionEntradaPista = new Posicion(3, 3);
        posicionInicioAvion = new Posicion(1, 1);
        posicionFinAvion = new Posicion(2,3);
        pistaSimple= new PistaSimple(posicionEntradaPista);
        pistas.add(pistaSimple);
        mapa = new Mapa(pistas);
        avionSimple= new AvionSimple(posicionInicioAvion, posicionFinAvion, mapa);
        //mapa.colocarAvionEnAire(avionSimple);
        nivel1 = new Nivel(mapa, dificultad);
        nivel2 = new Nivel(mapa, dificultad);
        nivel3 = new Nivel(mapa, dificultad);
        niveles = new LinkedList<Nivel>();
        niveles.add(nivel1);
        niveles.add(nivel2);
        niveles.add(nivel3);
        jugador = new Jugador("PEPE");
        juego= new Juego (jugador,niveles);
		
	}
	

}
