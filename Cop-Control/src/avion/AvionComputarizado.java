package avion;


import pista.Pista;
import copControl.Mapa;
import copControl.Posicion;

public class AvionComputarizado extends Avion {

	public AvionComputarizado(Posicion posIni) {
		super(posIni);
		esControlable=false;
	}

	public AvionComputarizado(Posicion posIni, Posicion posFin, Mapa mapaDeJuego){
		super(posIni,posFin,mapaDeJuego);
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
