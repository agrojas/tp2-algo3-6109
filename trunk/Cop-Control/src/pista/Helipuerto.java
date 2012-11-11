package pista;

import java.util.List;

import avion.AvionComputarizado;
import avion.AvionPesado;
import avion.AvionSimple;
import avion.Helicoptero;

import copControl.Posicion;

public class Helipuerto extends Pista{

	private int prueba;
	public Helipuerto(List<Posicion> posicionesHelipuerto) {
		//es un helipuerto
	}
	@Override
	public boolean puedeAterrizar(AvionSimple avionSimple) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean puedeAterrizar(AvionPesado avionPesado) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean puedeAterrizar(AvionComputarizado avionComputarizado) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean puedeAterrizar(Helicoptero helicoptero) {
		// TODO Auto-generated method stub
		return true;
	}


}
