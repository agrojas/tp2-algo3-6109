package testJuego;

import java.util.LinkedList;
import java.util.List;

import pista.Pista;
import pista.PistaSimple;
import pista.PosicionesEntradaSobrantesException;
import pista.PosicionesEntradaVaciaException;
import avion.AvionPesado;
import avion.AvionSimple;
import copControl.Dificultad;
import copControl.Jugador;
import copControl.Mapa;
import copControl.Nivel;
import copControl.Posicion;
import copControl.Juego;
import junit.framework.TestCase;

public class JuegoTest extends TestCase {
        
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
        private List<Nivel> niveles;
        private Jugador jugador;
        private Juego juego;
        
        public void testColocarAvionListaDeAvionesVolandoNovacia(){
                juego.colocarAvion();
                assertTrue(juego.getNivelActual().tieneAvionesVolando());
        }
        
        

        public void setUp() throws PosicionesEntradaVaciaException, PosicionesEntradaSobrantesException{
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
                //mapa.colocarAvionEnAire(avionSimple);
                nivel = new Nivel(mapa, dificultad);
                niveles = new LinkedList<Nivel>();
                niveles.add(nivel);
                jugador = new Jugador("PEPE");
                juego= new Juego (jugador,niveles);
        
        }
}