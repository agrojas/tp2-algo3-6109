package avion;

import pista.Helipuerto;
import pista.PistaDoble;
import pista.PistaLarga;
import pista.PistaSimple;
import copControl.Posicion;

public class AvionComputarizado extends Avion{

	public AvionComputarizado(Posicion posIni, Posicion posFin) {
		super(posIni, posFin);
		// TODO Auto-generated constructor stub
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
