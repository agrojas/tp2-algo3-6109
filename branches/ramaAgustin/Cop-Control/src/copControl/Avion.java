package copControl;

public abstract class Avion {
	private Trayectoria trayectoria;
	private int velocidad;
	
	public Posicion getPosicionActual() {
		return this.trayectoria.getPosicionActual();
	}

}
