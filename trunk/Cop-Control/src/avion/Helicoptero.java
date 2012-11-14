package avion;


import pista.Pista;

import copControl.Controlable;
import copControl.Posicion;

public class Helicoptero extends Avion implements Controlable{

	public Helicoptero(Posicion posIni, Posicion posFin) {
		super(posIni, posFin);
		// TODO Auto-generated constructor stub
	}

	public void moverHacia(Posicion unaPosicion) {
		this.trayectoria.setDestino(unaPosicion);
		
	}

	@Override
	public boolean puedeAterrizar(Pista pista) {
		return pista.puedeAterrizar(this);
	}

}
