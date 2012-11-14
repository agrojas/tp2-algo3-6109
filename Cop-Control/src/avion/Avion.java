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
		//borrar, esta para ver test
		/*System.out.println("Avion esta en (x,y): ");
		System.out.println((int)this.getPosicionActual().getCoordenadaX());
		System.out.println((int)this.getPosicionActual().getCoordenadaY());
		*/
	
		trayectoria.actualizarProximoDestino();
		trayectoria.avanzar();
			//borrar esta para ver test
			System.out.println("Avion llego a a (x,y): ");
			System.out.println((int)this.getPosicionActual().getCoordenadaX());
			System.out.println((int)this.getPosicionActual().getCoordenadaY());
			
			System.out.println("Destino de Avion es (x,y): ");
			System.out.println((int)this.getDestinoActual().getCoordenadaX());
			System.out.println((int)this.getDestinoActual().getCoordenadaY());
		}
				
	//}

	public Posicion getDestinoActual(){
		return trayectoria.getDestinoActual();
	}
		
	public void setDestinoNuevo(Posicion nuevoDestino){
		trayectoria.setDestino(nuevoDestino);
	}
		
	/**
	 * @param pista
	 * @return
	 */
	abstract public boolean puedeAterrizar(Pista pista);
	

	
	
	
}
