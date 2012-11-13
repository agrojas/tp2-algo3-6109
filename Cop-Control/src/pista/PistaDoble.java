package pista;

import java.util.List;

import avion.AvionComputarizado;
import avion.AvionPesado;
import avion.AvionSimple;
import avion.Helicoptero;

import copControl.Posicion;

public class PistaDoble extends Pista {



	public PistaDoble(List<Posicion> posicionesEntrada) throws PosicionesEntradaSobrantesException, PosicionesEntradaVaciaException  {
		super (posicionesEntrada);
		if (posicionesEntrada.size()>2){
			throw new PosicionesEntradaSobrantesException();			
		}
		this.posicionesEntrada= posicionesEntrada;		
				
	}

	@Override
	public boolean puedeAterrizar(AvionSimple avionSimple) {
		// TODO Auto-generated method stub
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
