package pista;

import java.util.List;

import avion.AvionComputarizado;
import avion.AvionPesado;
import avion.AvionSimple;
import avion.Helicoptero;

import copControl.Posicion;

public class Helipuerto extends Pista{


	public Helipuerto(List<Posicion> posicionesEntrada) throws PosicionesEntradaVaciaException{
		super(posicionesEntrada);
		// TODO Auto-generated constructor stub
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
	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}


}
