package Inicializadores;

import java.util.LinkedList;
import java.util.List;

import pista.Helipuerto;
import pista.Pista;
import pista.PistaSimple;
import pista.PosicionesEntradaSobrantesException;
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
		return new Dificultad(3, 3, 2);
	}

	private static Mapa mapaInicializado(){
		return new Mapa(pistasInicializadas());
	}
	
	private static List<Pista> pistasInicializadas(){
		List<Pista> pistas = new LinkedList<Pista>();
		pistas.add(pistaSimpleInicializada());
		pistas.add(helipuertoInicializado());
		return pistas;		
	}

	private static PistaSimple pistaSimpleInicializada() {
		try {
			return new PistaSimple(posicionesPistaSimple());
		} catch (PosicionesEntradaVaciaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PosicionesEntradaSobrantesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private static Helipuerto helipuertoInicializado() {
		try {
			return new Helipuerto(posicionesHelipuerto());
		} catch (PosicionesEntradaVaciaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private static List<Posicion> posicionesPistaSimple() {
		Posicion posicionEntrada = new Posicion(25, 25);
		List<Posicion> posiciones = new LinkedList<Posicion>();
		posiciones.add(posicionEntrada);
		return posiciones;
	}
	
	private static List<Posicion> posicionesHelipuerto() {
		Posicion posicionEntrada = new Posicion(100, 100);
		List<Posicion> posiciones = new LinkedList<Posicion>();
		posiciones.add(posicionEntrada);
		return posiciones;
	}
}
