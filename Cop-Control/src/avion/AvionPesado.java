package avion;

import pista.Pista;

import copControl.Controlable;
import copControl.Posicion;

public class AvionPesado extends Avion implements Controlable{

	public AvionPesado(Posicion posIni, Posicion posFin) {
		super(posIni, posFin);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void avanzar() {
		// TODO Auto-generated method stub
		
	}


	public void moverHacia(Posicion unaPosicion) {
		this.trayectoria.setDestino(unaPosicion);
		
	}

	@Override
	public boolean puedeAterrizar(Pista pista) {
		return pista.puedeAterrizar(this);
	}

}
