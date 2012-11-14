package copControl;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Trayectoria {
	
	private Posicion posicionActual;
	private List<Posicion> destinos; //al marcar con click se agrega un nuevo destino
	private List<Posicion> vecinos;
	
	
	public Trayectoria(Posicion posIni, Posicion posFin) {
		posicionActual = posIni;
		//seteo la posicion ini y fin como si fuesen click para calcular de la misma forma su trayectoria inicial al aparecer en mapa
		destinos = new LinkedList<Posicion>();
		this.setDestino(posIni);
		this.setDestino(posFin);
	}

	
	/**
	 * @return
	 */
	private Posicion getVecinoDeDistanciaMinima(){
		this.calcularVecinos();
		Map<Double, Posicion> distancias = new HashMap<Double, Posicion>();
		double distancia=0;
		Posicion posicionFinal = this.posicionSiguiente();
		
		for (Posicion posicionVecina : this.vecinos) {
			distancia= posicionVecina.distanciaHasta(posicionFinal);
			distancias.put(distancia, posicionVecina);
		}
		//Ordeno por distancia minima
		TreeMap<Double, Posicion> treeMap = new TreeMap<Double, Posicion>(distancias);
		//Obtengo la minima distancia
		
		Posicion posicionMinima=treeMap.get(treeMap.firstKey())  ;
		
		
		
		return posicionMinima;
		
		
		
		
	}
	/**
	 * Llamar cuando se cambia la posicion actual, para mantener actualizada la lista de vecinos
	 */
	private void calcularVecinos(){
		
		this.vecinos = new LinkedList<Posicion>();
		
		int posX=(int)this.posicionActual.getCoordenadaX();
		int posY=(int)this.posicionActual.getCoordenadaY();
		int incDerecha=(int) (this.posicionActual.getCoordenadaX()+1);
		int incIzquierda=(int) (this.posicionActual.getCoordenadaX()-1);
		int incArriba=(int) (this.posicionActual.getCoordenadaY()+1);
		int incAbajo=(int) (this.posicionActual.getCoordenadaY()-1);
		
		Posicion posDerecha = new Posicion(incDerecha, posY);
		Posicion posIzquierda = new Posicion(incIzquierda,posY);
		Posicion posArriba = new Posicion(posX,incArriba);
		Posicion posAbajo = new Posicion(posX,incAbajo);
		
		Posicion posDiagArribaIzquierda = new Posicion(incIzquierda,incArriba);
		Posicion posDiagArribaDerecha = new Posicion(incDerecha,incArriba);
		Posicion posDiagAbajoIzquierda = new Posicion(incIzquierda,incAbajo);
		Posicion posDiagAbajoDerecha = new Posicion(incDerecha,incAbajo);
		
		this.vecinos.add(posDerecha);
		this.vecinos.add(posAbajo);
		this.vecinos.add(posIzquierda);
		this.vecinos.add(posArriba);
		this.vecinos.add(posDiagArribaDerecha);
		this.vecinos.add(posDiagArribaIzquierda);
		this.vecinos.add(posDiagAbajoIzquierda);
		this.vecinos.add(posDiagAbajoDerecha);
	}
	
	


	public Posicion getPosicionActual() {
		return this.posicionActual;
	}

	//recorrer posicion por posicion calculando trayectoria entre destinos, debe de ser llamado por juego cada sierto tiempo (velocidad de nivel)
	public void avanzar() {   
		this.posicionActual= this.posicionSiguiente();		
	}


	//Falta dise�ar el algoritmo de avance segun el nuevo destino
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
