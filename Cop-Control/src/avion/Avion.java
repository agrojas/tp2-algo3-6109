package avion;

import copControl.Posicion;
import copControl.Trayectoria;

public abstract class Avion {
	protected Trayectoria trayectoria;
	protected int velocidad;
	protected boolean estaVolando;

	
	public Posicion getPosicionActual() {
		return this.trayectoria.getPosicionActual();
	}
	public Avion(Posicion posIni,Posicion posFin){
		this.estaVolando=true;
		this.trayectoria= new Trayectoria(posIni,posFin);
	}
	public boolean getEstaVolando(){
		return this.estaVolando;		
	}
	//Ver este metodo
	protected void avanzar() {
		// TODO Auto-generated method stub
		
	}
	public void moverHacia(Posicion unaPosicion){
		
		
	}
}
