package avion;


import pista.Pista;

import copControl.Posicion;

public class Helicoptero extends Avion{

	public Helicoptero(Posicion posIni, Posicion posFin) {
		super(posIni, posFin);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void avanzar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moverHacia(Posicion unaPosicion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean puedeAterrizar(Pista pista) {
		return pista.puedeAterrizar(this);
	}

}