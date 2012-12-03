package pista;

import java.util.List;

import copControl.Posicion;
import fiuba.algo3.titiritero.modelo.ObjetoDibujable;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

import avion.Avion;
import avion.AvionComputarizado;
import avion.AvionPesado;
import avion.AvionSimple;
import avion.Helicoptero;


public abstract class Pista implements ObjetoPosicionable{
	protected List<Posicion> 	posicionesEntrada;
	protected int radioAterrizaje;
	
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


	public abstract boolean estaEnZonaAterrizaje(Avion avion);
	
    // does circle (x1, y1, r1) intersect circle (x2, y2, r2)?
    protected boolean intersects(double x1, double y1, double r1,
                                     double x2, double y2, double r2) {
        double dx = x1 - x2;
        double dy = y1 - y2;
        double distance = Math.sqrt(dx*dx + dy*dy);
        return distance <= r1 + r2;
        
    }

}
