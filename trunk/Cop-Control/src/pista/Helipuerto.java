package pista;

import java.util.List;

import avion.Avion;
import avion.AvionComputarizado;
import avion.AvionPesado;
import avion.AvionSimple;
import avion.Helicoptero;

import copControl.Posicion;

public class Helipuerto extends Pista{


	public Helipuerto(Posicion posicionEntrada) throws PosicionesEntradaVaciaException{
		super(posicionEntrada);
		this.posicionEntrada= posicionEntrada;		
		this.radioAterrizaje=15;
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
		return (int)getPosicionEntrada().getCoordenadaX();
	}

	@Override
	public int getY() {
		return (int)getPosicionEntrada().getCoordenadaY();
	}
	@Override
	public boolean estaEnZonaAterrizaje(Avion avion) {
		
		Posicion posicion1= this.getPosicionEntrada();
		int radio1 = this.radioAterrizaje;
		Posicion posicion2 = avion.getPosicionActual();
		int radio2 = avion.getRadio();	
		
		return intersects(posicion1.getCoordenadaX(), posicion1.getCoordenadaY(), radio1,
				posicion2.getCoordenadaX(), posicion2.getCoordenadaY(), radio2);
	}

	
	





}
