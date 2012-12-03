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
	protected boolean estaMarcado;
	
	public boolean estaMarcado(){
		
		return this.estaMarcado;
	}
	
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
		this.estaMarcado=false;
		
	}
	public Avion(Posicion posIni) {
		this.estaVolando=true;
		this.trayectoria= new Trayectoria(posIni);
		this.estaMarcado=false;
		
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
	
	public abstract void moverHacia(Posicion unaPosicion);
	
		
	public boolean aterrizar(Pista pista){
		
		boolean condicion1 =(pista.estaEnZonaAterrizaje(this)) ;
		boolean condicion2= this.puedeAterrizar(pista);
		return (condicion1 && condicion2);
		
		
	}
	

	
	public int getX() {
		return ((int)this.getPosicionActual().getCoordenadaX());
	}

	
	public int getY() {
		return ((int)this.getPosicionActual().getCoordenadaY());
	}

	
    
    public boolean esPosicionContenida(Posicion unaPosicion) {
        double x1 = unaPosicion.getCoordenadaX();
        double y1 = unaPosicion.getCoordenadaY();
    	double x2 = (double)this.getX();
    	double y2 = (double)this.getY();
        double dx = x1 - x2;
        double dy = y1 - y2;
        double distance = Math.sqrt(dx*dx + dy*dy);
        boolean marcado=distance <= this.radio;
        if(marcado){
        	this.estaMarcado=true;
        	
        }
        
        return marcado;
    }

	public void desmarcar() {
		this.estaMarcado=false;
		
	}


	
}
