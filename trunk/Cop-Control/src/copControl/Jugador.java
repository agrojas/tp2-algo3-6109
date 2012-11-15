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

	//si habia avion en unaPosicion lo marca, sino adiere destino al avion que ya estaba marcado
	public void click(Posicion unaPosicion) { 
		
		Avion posibleAvion;
		posibleAvion=this.nivelActual.getAvionEnPosicion(unaPosicion);		
		
		if (posibleAvion!=null && posibleAvion.esControlable()){ //con esto aseguro que nunca avionMarcado sea un avionComputarizado (noControlable)
			this.avionMarcado=posibleAvion;
		}
		else{
			this.avionMarcado.moverHacia(unaPosicion);
		}
		
	}
		
}
