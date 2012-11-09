package avion;

import copControl.Posicion;
import copControl.Trayectoria;

public abstract class Avion {
	private Trayectoria trayectoria;
	private int velocidad;
	private boolean estaVolando;
	
	public Posicion getPosicionActual() {
		return this.trayectoria.getPosicionActual();
	}

}
