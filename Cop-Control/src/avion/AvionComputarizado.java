package avion;


import pista.Pista;
import copControl.Posicion;

public class AvionComputarizado extends Avion {

	public AvionComputarizado(Posicion posIni) {
		super(posIni);
		esControlable=false;
	}


	@Override
	public boolean puedeAterrizar(Pista pista) {
		return pista.puedeAterrizar(this);
	}

	public void moverHacia(Posicion unaPosicion){
		//no deberia dejar llamarse a este metodo en esta clase
	}

}
