package pista;

import avion.AvionComputarizado;
import avion.AvionPesado;
import avion.AvionSimple;
import avion.Helicoptero;
import copControl.Posicion;
import java.util.List;

public abstract class Pista {
	
	
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
	

}
