package pista;

import java.util.List;

import avion.AvionComputarizado;
import avion.AvionPesado;
import avion.AvionSimple;
import avion.Helicoptero;

import copControl.Posicion;

public class PistaSimple extends Pista{

	public PistaSimple(List<Posicion> posicionesPistaSimple) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public	boolean puedeAterrizar(AvionSimple avionSimple) {
		return true;
	}

	@Override
	public boolean puedeAterrizar(AvionPesado avionPesado) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean puedeAterrizar(AvionComputarizado avionComputarizado) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean puedeAterrizar(Helicoptero helicoptero) {
		// TODO Auto-generated method stub
		return false;
	}

}