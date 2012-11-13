package copControl;

import java.util.LinkedList;
import java.util.List;

public class Trayectoria {
	private List<Posicion> puntos;
	private Posicion posicionActual;
	private List<Posicion> destinos; //al marcar con click se agrega un nuevo destino
	
	
	public Trayectoria(Posicion posIni, Posicion posFin) {
		posicionActual = posIni;
		//seteo la posicion ini y fin como si fuesen click para calcular de la misma forma su trayectoria inicial al aparecer en mapa
		destinos = new LinkedList<Posicion>();
		this.setDestino(posIni);
		this.setDestino(posFin);
	}


	public Posicion getPosicionActual() {
		return this.posicionActual;
	}

	//recorrer posicion por posicion calculando trayectoria entre destinos, debe de ser llamado por juego cada sierto tiempo (velocidad de nivel)
	public void avanzar() {   
		this.posicionActual= this.posicionSiguiente();		
	}


	//Falta diseñar el algoritmo de avance segun el nuevo destino
	private Posicion posicionSiguiente() {
		return null;
	}
	
	private List<Posicion> getDestino(){  //lista de posiciones por clicks
		return destinos;
		
	}
	
	public void setDestino(Posicion unaPos){   //usar cuando hay click
		destinos.add(unaPos);
	}
	
}
