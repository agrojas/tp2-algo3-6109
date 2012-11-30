package copControl;


import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import avion.ProximoDestinoNuloException;


public class Trayectoria {
	
	private Posicion posicionActual;
	private List<Posicion> destinos; //al marcar con click se agrega un nuevo destino
	private List<Posicion> vecinos;
	private Mapa mapaDeMovimiento; 
	
	public Trayectoria(Posicion posIni){
		this.posicionActual=posIni;
		
	}
	
	public Trayectoria(Posicion posIni, Posicion posFin,Mapa mapaDeMovimiento) {
		posicionActual = posIni;
		//seteo la posicion fin como si fuesen click para calcular de la misma forma su trayectoria inicial al aparecer en mapa
		destinos = new LinkedList<Posicion>();
		this.setDestino(posFin);
		this.mapaDeMovimiento = mapaDeMovimiento;
		
	}

	
	/**
	 * @return
	 */

	


	public Posicion getPosicionActual() {
		return this.posicionActual;
	}

	//recorrer posicion por posicion calculando trayectoria entre destinos, debe de ser llamado por juego cada sierto tiempo (velocidad de nivel)
	public void avanzar(){   
		
		this.actualizarProximoDestino();
		if (this.destinos.size() >0){
			this.posicionActual= this.posicionActual.getVecinoDeDistanciaMinima(this.getDestinoActual());	
		}
		else{
			
			this.destinos.add(this.mapaDeMovimiento.generarPosicionExtremoAlAzar());
			/*System.out.println("Esta es la posicion Actual:")
			System.out.println(this.posicionActual.getCoordenadaX());
			System.out.println(this.posicionActual.getCoordenadaY());
			System.out.println("Este es el nuevo destino:");
			System.out.println(this.destinos.get(0).getCoordenadaX());
			System.out.println(this.destinos.get(0).getCoordenadaY());*/
		}
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
