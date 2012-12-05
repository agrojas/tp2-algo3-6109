package Inicializadores;

import java.util.LinkedList;
import java.util.List;

import pista.Helipuerto;
import pista.Pista;
import pista.PistaDoble;
import pista.PistaSimple;
import pista.PosicionesEntradaVaciaException;

import copControl.Dificultad;
import copControl.Juego;
import copControl.Jugador;
import copControl.Mapa;
import copControl.Nivel;
import copControl.Posicion;

public class InicializadorJuego {
	private Juego juego;

	public InicializadorJuego (Juego juego){
		
		this.juego=juego; 
	}
	
	public static Juego juegoInicializado(){
		return new Juego(jugadorInicializado(), nivelesJuego());
		
	}

	
	private static Jugador jugadorInicializado() {
		return new Jugador("Manolo");
	}

	private static List<Nivel> nivelesJuego (){
		List<Nivel> niveles = new LinkedList<Nivel>();
		niveles.add(nivelInicializado());
		return niveles;
	}
	private static Nivel nivelInicializado(){
		return new Nivel(mapaInicializado(), dificultadInicializada());		
	}
	
	private static Dificultad dificultadInicializada() {
		return new Dificultad(5, 3, 2);
	}

	private static Mapa mapaInicializado(){
		return new Mapa(pistasInicializadas());
	}
	
	private static List<Pista> pistasInicializadas(){
		List<Pista> pistas = new LinkedList<Pista>();
		pistas.add(pistaSimpleInicializada());
		pistas.add(helipuertoInicializado());
		pistas.add(pistaDobleInicializada());
		return pistas;		
	}

	private static PistaDoble pistaDobleInicializada(){
		Posicion posicionPistaDoble = new Posicion(100,200);
		try {
			return new PistaDoble(posicionPistaDoble);
		} catch (PosicionesEntradaVaciaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	private static PistaSimple pistaSimpleInicializada() {
		try {
			return new PistaSimple(posicionPistaSimple());
		} catch (PosicionesEntradaVaciaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private static Helipuerto helipuertoInicializado() {
		try {
			return new Helipuerto(posicionHelipuerto());
		} catch (PosicionesEntradaVaciaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private static Posicion posicionPistaSimple() {
		Posicion posicionEntrada = new Posicion(25, 25);
		return posicionEntrada;
	}
	
	private static Posicion posicionHelipuerto() {
		Posicion posicionEntrada = new Posicion(100, 100);
		return posicionEntrada;
	}
}
