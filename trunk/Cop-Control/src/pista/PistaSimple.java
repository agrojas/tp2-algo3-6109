package pista;


import java.util.List;

import avion.Avion;
import avion.AvionComputarizado;
import avion.AvionPesado;
import avion.AvionSimple;
import avion.Helicoptero;

import copControl.Posicion;

import pista.PosicionesEntradaSobrantesException;
public class PistaSimple extends Pista{

	
	public PistaSimple(List<Posicion> posicionesEntrada) throws PosicionesEntradaVaciaException, PosicionesEntradaSobrantesException {
		super (posicionesEntrada);
		if (posicionesEntrada.size()>1){
			throw new PosicionesEntradaSobrantesException();			
		}
		this.posicionesEntrada= posicionesEntrada;		
				
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



	private Posicion getPosicionEntrada(){
		return this.getPosicionesEntrada().get(0);
		
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
		
		Posicion posicion1= this.getPosicionesEntrada().get(0);
		int radio1 = this.radioAterrizaje;
		Posicion posicion2 = avion.getPosicionActual();
		int radio2 = avion.getRadio();	
		
		return intersects(posicion1.getCoordenadaX(), posicion1.getCoordenadaY(), radio1,
				posicion2.getCoordenadaX(), posicion2.getCoordenadaY(), radio2);
	}
}
