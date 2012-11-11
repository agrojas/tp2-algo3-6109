package avion;

import pista.Helipuerto;
import pista.PistaDoble;
import pista.PistaLarga;
import pista.PistaSimple;
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
	public boolean puedeAterrizar(PistaSimple pista) {
		return pista.puedeAterrizar(this);
	}

	@Override
	public boolean puedeAterrizar(PistaDoble pista) {
		return pista.puedeAterrizar(this);
	}

	@Override
	public boolean puedeAterrizar(PistaLarga pista) {
		return pista.puedeAterrizar(this);
	}

	@Override
	public boolean puedeAterrizar(Helipuerto pista) {
		return pista.puedeAterrizar(this);
	}

}
