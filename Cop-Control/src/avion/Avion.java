package avion;


import pista.Pista;
import copControl.Mapa;
import copControl.Posicion;
import copControl.Trayectoria;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public abstract class Avion  implements  ObjetoPosicionable{
	protected Trayectoria trayectoria;
	protected boolean estaVolando;
	protected boolean esControlable;
	protected int radio;
	
	/**
	 * @return the radio
	 */
	public int getRadio() {
		return radio;
	}

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
	public Avion(Posicion posIni,Posicion posFin,Mapa mapaDeMovimiento){
		this.estaVolando=true;
		this.trayectoria= new Trayectoria(posIni,posFin,mapaDeMovimiento);
		
	}
	public Avion(Posicion posIni,Mapa mapaDeMovimiento) {
		this.estaVolando=true;
		this.trayectoria= new Trayectoria(posIni,mapaDeMovimiento);
		
	}
	/**
	 * @return
	 */
	public boolean getEstaVolando(){
		return this.estaVolando;		
	}
	
	public void avanzar(){
		
		if (this.estaVolando){
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
	

	
	public int getX() {
		return ((int)this.getPosicionActual().getCoordenadaX());
	}

	
	public int getY() {
		return ((int)this.getPosicionActual().getCoordenadaY());
	}


	
}
