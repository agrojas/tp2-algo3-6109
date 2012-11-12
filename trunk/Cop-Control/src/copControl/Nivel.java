package copControl;

import java.util.List;
import java.util.Iterator;

import avion.Avion;

public class Nivel {
	private Mapa mapa;
	private Dificultad dificultad;
	
	public Nivel(Mapa mapa, Dificultad dificultad) {
		this.mapa=mapa;
		this.dificultad=dificultad;
	}

	public Avion getAvionEnPosicion(Posicion unaPosicion) {
		Avion avionRecivido= null; 
		List<Avion> avionesEnAire=this.mapa.getAvionesEnAire();
		Iterator<Avion> it= avionesEnAire.iterator();

		while (it.hasNext()){
			Avion avionActual = it.next();
			if(unaPosicion == avionActual.getPosicionActual()){
				avionRecivido= avionActual;
			}		
		}
		
		return avionRecivido;
	}


	public void aterrizarAviones() {
		// TODO Auto-generated method stub
		
	}

	public List<Posicion> getPosicionesExtremos() {
		
		return mapa.getPosicionesExtremos();
	}

	public Posicion getPosicionPistaNoHelipuerto() {
		return (mapa.getPosicionPistaNoHelipuerto());
	}

	public void colocarAvionEnAire(Avion unAvion) {
		mapa.colocarAvionEnAire(unAvion);
	
	}
	public boolean tieneAvionesVolando(){
		return mapa.tieneAvionesVolando();
	}
	public boolean tienePistaAdecuada(Avion unAvion){       
		return mapa.tienePistaAdecuada(unAvion);
	
	}

	public boolean huboChoque() {
		
		List<Avion> avionesEnAire =this.mapa.getAvionesEnAire();
		boolean chocoConOtroAvion=false;
		Avion avionActual;
		
		while ((!avionesEnAire.isEmpty()) && (!chocoConOtroAvion)) {
		
			
			Iterator<Avion> it= avionesEnAire.iterator();
			avionActual = it.next();
		
			//Defino nueva variable para almacenar resultado de metodo List.remove
			boolean huboCambio;
			huboCambio= avionesEnAire.remove(avionActual);
									
			chocoConOtroAvion = this.chocoConOtroAvion(avionActual,avionesEnAire);
		
		}		
	
		return chocoConOtroAvion;
	}

	private boolean chocoConOtroAvion(Avion avionActual,List<Avion> avionesEnAire) {
		
		boolean posicionIdentica= false;
		Iterator<Avion> it= avionesEnAire.iterator();
				
		while(it.hasNext() && (!posicionIdentica)){
			Avion avionAComparar = it.next();
			posicionIdentica = (avionAComparar.getPosicionActual().igualA(avionActual.getPosicionActual()));
		}
		
		return posicionIdentica;
	}
}
