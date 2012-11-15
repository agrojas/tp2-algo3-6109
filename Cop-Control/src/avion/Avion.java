package avion;


import pista.Pista;
import copControl.Posicion;
import copControl.Trayectoria;

public abstract class Avion{
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
		if(this.getDestinoActual().igualA(this.getPosicionActual())){
			trayectoria.actualizarProximoDestino();//ver que al agregar varios destinos pincha
		}
		else {
			trayectoria.avanzar();
		}

	}
				
	

	public Posicion getDestinoActual(){
		return trayectoria.getDestinoActual();
	}
		
		
	/**
	 * @param pista
	 * @return
	 */
	abstract public boolean puedeAterrizar(Pista pista);
	
	//borrar metodo es para testear por consola 
	public void mostrarPosEnConsola(){
		if(this.getDestinoActual().igualA(this.getPosicionActual())){
			System.out.println("Avion llego a destino!! ");
		}
		else {
			System.out.println("Avion llego a a (x,y): ");
			System.out.println((int)this.getPosicionActual().getCoordenadaX());
			System.out.println((int)this.getPosicionActual().getCoordenadaY());
		
			System.out.println("Destino de Avion es (x,y): ");
			System.out.println((int)this.getDestinoActual().getCoordenadaX());
			System.out.println((int)this.getDestinoActual().getCoordenadaY());
		}
		
		
	}
	
	
	
}
