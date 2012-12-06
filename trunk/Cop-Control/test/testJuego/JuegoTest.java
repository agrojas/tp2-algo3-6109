package testJuego;

import java.util.LinkedList;
import java.util.List;

import pista.Pista;
import pista.PistaSimple;

import pista.PosicionesEntradaVaciaException;
import avion.AvionSimple;
import copControl.Dificultad;
import copControl.Jugador;
import copControl.Mapa;
import copControl.Nivel;
import copControl.Posicion;
import copControl.Juego;
import junit.framework.TestCase;

public class JuegoTest extends TestCase {
        
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
        
        public void testUnJuegoAvanzaDeNivel() {
        	Nivel nivelActual= juego.getNivelActual();
        	juego.avanzarNivel();
        	assertFalse(nivelActual == juego.getNivelActual());
			
		}
        //TODO cambiarlo por otro
//        public void testUnJuegoAvanzaDeNivelYCuandoNoHayMasSeGanoElJuego() {
//        	//Solo tengo 3 niveles
//        	Nivel nivelActual= juego.getNivelActual();//nivel1
//        	juego.avanzarNivel();//Avanzo al 2
//        	juego.avanzarNivel();//Avanzo al 3
//        	juego.avanzarNivel();//Aca no hay mas niveles
//        	assertTrue(true);
//		}
        
        public void testSiIngresaUnAvionTengoAvionesVolando(){
        		juego.vivir();
                juego.colocarAvion();
             
                assertTrue(juego.getNivelActual().tieneAvionesVolando());
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