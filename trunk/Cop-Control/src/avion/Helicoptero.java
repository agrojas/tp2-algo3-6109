package avion;


import pista.Pista;

import copControl.Mapa;
import copControl.Posicion;

public class Helicoptero extends Avion{

	public Helicoptero(Posicion posIni, Posicion posFin,Mapa mapaDeMovimiento) {
		super(posIni, posFin,mapaDeMovimiento);
		esControlable=true;
	}

	public void moverHacia(Posicion unaPosicion) {
		this.trayectoria.setDestino(unaPosicion);
		
	}

	@Override
	public boolean puedeAterrizar(Pista pista) {
		return pista.puedeAterrizar(this);
	}

}
