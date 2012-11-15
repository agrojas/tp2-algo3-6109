package copControl;

import avion.Avion;

/**
 * @author agu
 *
 */
public class Jugador {
	private String nombre;
	private Avion avionMarcado;
	private Nivel nivelActual;
	
	public Jugador(String nombre) {
		this.nombre=nombre;
		this.avionMarcado=null;
	}

	public String getNombre() {
		return this.nombre;
	}

	/**
	 * @param nivelActual
	 */
	public void setNivelActual(Nivel nivelActual){
		this.nivelActual= nivelActual;
		
	}

	/**
	 * devuelve un booleano si unaPosicion corresponde a un avion en aire
	 * @param unaPosicion
	 * @return
	 */
	public boolean marcarAvion(Posicion unaPosicion) {
		
		avionMarcado=this.nivelActual.getAvionEnPosicion(unaPosicion);		
		return(avionMarcado!=null);
		
	}
	
	public void setDestino(Posicion unDestino){
		
	}
	
	public void click(){
		
	}

}
