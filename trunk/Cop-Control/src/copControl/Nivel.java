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

	public Mapa getMapa() {
		// TODO Auto-generated method stub
		return null;
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
}
