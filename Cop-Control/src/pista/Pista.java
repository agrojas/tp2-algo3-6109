package pista;

import java.util.List;

import copControl.Posicion;
import fiuba.algo3.titiritero.modelo.ObjetoDibujable;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

import avion.AvionComputarizado;
import avion.AvionPesado;
import avion.AvionSimple;
import avion.Helicoptero;


public abstract class Pista implements ObjetoPosicionable{
	protected List<Posicion> 	posicionesEntrada;
	
	public Pista(List<Posicion> posicionesEntrada) throws PosicionesEntradaVaciaException {
		
		if (posicionesEntrada.isEmpty()){
			throw new PosicionesEntradaVaciaException();
		}
			
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

	public boolean tieneEntradaEn(Posicion posicion) {
		return this.getPosicionesEntrada().contains(posicion);
	}
	

}
