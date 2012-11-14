package avion;


import pista.Pista;
import copControl.Posicion;

public class AvionComputarizado extends Avion {

	public AvionComputarizado(Posicion posIni, Posicion posFin) {
		super(posIni, posFin);
		// TODO Auto-generated constructor stub
	}


	@Override
	public boolean puedeAterrizar(Pista pista) {
		return pista.puedeAterrizar(this);
	}



}
