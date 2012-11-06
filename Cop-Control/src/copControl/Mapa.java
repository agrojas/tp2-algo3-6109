package copControl;

import java.util.ArrayList;
import java.util.List;

public class Mapa {
	private List<Avion> avionesEnAire;
	
	public Mapa(PistaSimple pistaSimple, PistaDoble pistaDoble,
			PistaLarga pistaLarga, Helipuerto helipuerto) {
		this.avionesEnAire= new ArrayList<Avion>();
	}

	public List<Avion> getAvionesEnAire() {
		return avionesEnAire;
	}

}
