package copControl;


import java.util.HashMap;
import java.util.Iterator;
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
		//seteo la posicion fin como si fuesen click para calcular de la misma forma su trayectoria inicial al aparecer en mapa
		destinos = new LinkedList<Posicion>();
		this.setDestino(posFin);
		
	}

	
	/**
	 * @return
	 */
	//retorna una Posicion de un vecino con distancia minima a la Posicion de Destino Final
	private Posicion getVecinoDeDistanciaMinima(){
		this.calcularVecinos();
		Map<Double, Posicion> distancias = new HashMap<Double, Posicion>();
		double distancia=0;
		Posicion posicionFinal = this.getDestinoActual();
		
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
	 * llamar dentro de getVecinoDeDistanciaMinima para mantener actualizada la lista de vecinos
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
		
		this.actualizarProximoDestino();
		this.posicionActual= this.getVecinoDeDistanciaMinima();	
		
	}

	//retorna posicion de un destino ( click ) a la cual debe dirigirse parcialmente el avion
	public Posicion getDestinoActual(){  
		Posicion destinoActual=null;
		if(!destinos.isEmpty()){
			destinoActual=destinos.get(0);  //el primer destino de la lista de destinos siempre debe de ser el parcial al cual quiero ir e irse borrando de la lista cuando llego a algun destino
		}
		return destinoActual;
		
	}
	
	public void setDestino(Posicion unaPos){   //usar cuando hay click, llamado por avion.moverHacia(unaPos)
		destinos.add(unaPos);
	}
	
	//para que cuando llega a un destino lo borre de la lista. Llamar siempre al principio de trayectoria.avanzar()
	private void actualizarProximoDestino(){
		boolean llegoAunDestino=false;
		Iterator<Posicion> itDestinos = destinos.iterator();
		while (itDestinos.hasNext() && !llegoAunDestino){
			llegoAunDestino= posicionActual.igualA(itDestinos.next());
			if (llegoAunDestino){
				System.out.println("remueve destino ya alcanzado");
				itDestinos.remove();
			}
		}
		
		
	}
	
}
