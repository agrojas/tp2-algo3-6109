package copControl;

import java.util.List;

public class Trayectoria {
	private List<Posicion> puntos;
	private Posicion posicionActual;
	
	
	public Trayectoria(Posicion posIni, Posicion posFin) {
		// TODO Auto-generated constructor stub
	}


	public Posicion getPosicionActual() {
		return this.posicionActual;
	}


	public void avanzar() {
		this.posicionActual= this.posicionSiguiente();		
	}


	//Falta diseñar el algoritmo de avance segun el nuevo destino
	private Posicion posicionSiguiente() {
		return null;
	}
	
}
