package avion;


import pista.Pista;
import copControl.Posicion;
import copControl.Trayectoria;

public abstract class Avion {
	protected Trayectoria trayectoria;
	protected int velocidad;
	protected boolean estaVolando;

	
	/**
	 * @return
	 */
	public Posicion getPosicionActual() {
		return this.trayectoria.getPosicionActual();
	}
	/**
	 * @param posIni
	 * @param posFin
	 */
	public Avion(Posicion posIni,Posicion posFin){
		this.estaVolando=true;
		this.trayectoria= new Trayectoria(posIni,posFin);
	}
	/**
	 * @return
	 */
	public boolean getEstaVolando(){
		return this.estaVolando;		
	}
	//Ver este metodo
	/**
	 * 
	 */

	public void avanzar(){
		
	}

		
		

		
	/**
	 * @param pista
	 * @return
	 */
	abstract public boolean puedeAterrizar(Pista pista);
	

	
	
	
}
