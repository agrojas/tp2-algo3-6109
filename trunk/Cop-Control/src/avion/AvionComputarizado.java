package avion;


import pista.Pista;
import copControl.Posicion;

public class AvionComputarizado extends Avion {

	public AvionComputarizado(Posicion posIni, Posicion posFin) {
		super(posIni, posFin);
		esControlable=false;
	}


	@Override
	public boolean puedeAterrizar(Pista pista) {
		return pista.puedeAterrizar(this);
	}



}
