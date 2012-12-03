package copControl;


import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import pista.Pista;

import avion.Avion;
import avion.ProximoDestinoNuloException;


public class Trayectoria {
	
	private Posicion posicionActual;
	private List<Posicion> destinos; //al marcar con click se agrega un nuevo destino
	private List<Posicion> vecinos;
	private Mapa mapaDeMovimiento; 
	
	public Trayectoria(Posicion posIni, Mapa mapaDeMovimiento){
		this.posicionActual=posIni;
		destinos= new LinkedList<Posicion>();
		this.mapaDeMovimiento=mapaDeMovimiento;
		//destinos.add(mapaDeMovimiento.)
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
		
		try {
			this.actualizarProximoDestino();
			//System.out.println("Posicion avion: "+this.posicionActual.toString());
			if (this.destinos.size() >0){
				this.posicionActual= this.posicionActual.getVecinoDeDistanciaMinima(this.getDestinoActual());	
			}
			else{
				
				this.destinos.add(this.mapaDeMovimiento.generarPosicionExtremoAlAzar());
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//retorna posicion de un destino ( click ) a la cual debe dirigirse parcialmente el avion
	public Posicion getDestinoActual(){  
		try {
			Posicion destinoActual=null;
			if(!destinos.isEmpty()){
				destinoActual=destinos.get(0);  //el primer destino de la lista de destinos siempre debe de ser el parcial al cual quiero ir e irse borrando de la lista cuando llego a algun destino
			}
			
			return destinoActual;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return posicionActual;
		
	}
	
	public void setDestino(Posicion unaPos){   //usar cuando hay click, llamado por avion.moverHacia(unaPos)
		destinos.add(unaPos);
	}
	
	//para que cuando llega a un destino lo borre de la lista. Llamar siempre al principio de trayectoria.avanzar()
	private void actualizarProximoDestino(){
		try {
			boolean llegoAunDestino=false;
			Iterator<Posicion> itDestinos = destinos.iterator();
			while (itDestinos.hasNext() && !llegoAunDestino){
				llegoAunDestino= posicionActual.igualA(itDestinos.next());
				if (llegoAunDestino){
					System.out.println("remueve destino ya alcanzado");
					itDestinos.remove();
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
		
		
	}
	
}
