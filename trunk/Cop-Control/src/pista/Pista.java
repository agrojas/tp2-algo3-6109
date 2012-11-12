package pista;

import java.util.List;

import copControl.Posicion;

import avion.AvionComputarizado;
import avion.AvionPesado;
import avion.AvionSimple;
import avion.Helicoptero;

public abstract class Pista {
	private List<Posicion> 	posicionesEntrada;
	
	public Pista(List<Posicion> posicionesEntrada) {
		this.posicionesEntrada= posicionesEntrada;
	}
	
	/**
	 * @param avionSimple
	 * @return
	 */
	public abstract boolean puedeAterrizar(AvionSimple avionSimple);
	/**
	 * @param avionPesado
	 * @return
	 */
	public abstract boolean puedeAterrizar(AvionPesado avionPesado);
	/**
	 * @param avionComputarizado
	 * @return
	 */
	public abstract boolean puedeAterrizar(AvionComputarizado avionComputarizado);
	/**
	 * @param helicoptero
	 * @return
	 */
	public abstract boolean puedeAterrizar(Helicoptero helicoptero);
	
	public List<Posicion> getPosicionesEntrada() {
		// TODO Auto-generated method stub
		return this.posicionesEntrada;
	}
	

}
