package avion;

import pista.Helipuerto;
import pista.Pista;
import pista.PistaDoble;
import pista.PistaLarga;
import pista.PistaSimple;
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
	abstract protected void avanzar();
	/**
	 * @param unaPosicion
	 */
	abstract public void moverHacia(Posicion unaPosicion);
	/**
	 * @param pistaSimple
	 * @return
	 */
	abstract public boolean puedeAterrizar(PistaSimple pistaSimple);
	/**
	 * @param pistaDoble
	 * @return
	 */
	abstract public boolean puedeAterrizar(PistaDoble pistaDoble);
	/**
	 * @param pistaLarga
	 * @return
	 */
	abstract public boolean puedeAterrizar(PistaLarga pistaLarga);
	/**
	 * @param helipuerto
	 * @return
	 */
	abstract public boolean puedeAterrizar(Helipuerto helipuerto);

}
