package avion;

import pista.Pista;

import copControl.Controlable;
import copControl.Posicion;

public class AvionSimple extends Avion implements Controlable{

	public AvionSimple(Posicion posIni, Posicion posFin) {
		super(posIni, posFin);
		esControlable=true;
		}

	public void moverHacia(Posicion unaPosicion){
		this.trayectoria.setDestino(unaPosicion);
		
	}
	
	@Override
	public boolean puedeAterrizar(Pista pista) {
		return pista.puedeAterrizar(this);
	}


	
	

}