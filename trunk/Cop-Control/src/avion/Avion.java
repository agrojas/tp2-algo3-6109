package avion;


import pista.Pista;
import copControl.Posicion;
import copControl.Trayectoria;

public abstract class Avion{
	protected Trayectoria trayectoria;
	protected boolean estaVolando;
	protected boolean esControlable;

	
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
		
		trayectoria.avanzar();
		
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
	
	public boolean esControlable(){
		return esControlable;
	}
	
	public void moverHacia(Posicion unaPosicion){
		
	}
	
		
	public boolean aterrizar(Pista pista){
		boolean condicion1 =(pista.tieneEntradaEn(this.trayectoria.getPosicionActual())) ;
		boolean condicion2= this.puedeAterrizar(pista);
		return (condicion1 && condicion2);
		
		
	}
	
	
}
