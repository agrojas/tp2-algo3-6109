package pista;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import avion.Avion;
import avion.AvionComputarizado;
import avion.AvionPesado;
import avion.AvionSimple;
import avion.Helicoptero;

import copControl.Posicion;
import fiuba.algo3.titiritero.dibujables.SuperficiePanel;
import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;

public class PistaDoble extends Pista {

	


	public PistaDoble(Posicion posicionEntrada) throws PosicionesEntradaSobrantesException, PosicionesEntradaVaciaException  {
		super (posicionEntrada);
//		if (posicionEntrada>2){
//			throw new PosicionesEntradaSobrantesException();			
//		}
		this.posicionEntrada= posicionEntrada;		
				//TODO CALCULAR LA OTRA ENTRADA
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



	/**
	 * @return Posicion de la primer entrada
	 */
	private Posicion getPosicionEntradaPrincipal(){
		return this.getPosicionEntrada();
		
	}

	@Override
	public int getX() {
		return (int)getPosicionEntradaPrincipal().getCoordenadaX();
	}

	@Override
	public int getY() {
		return (int)getPosicionEntradaPrincipal().getCoordenadaY();
	}

	@Override
	public boolean estaEnZonaAterrizaje(Avion avion) {
		
		Posicion posicion1= this.getPosicionEntradaPrincipal();
		int radio1 = this.radioAterrizaje;
		Posicion posicion2 = avion.getPosicionActual();
		int radio2 = avion.getRadio();	
		
		return intersects(posicion1.getCoordenadaX(), posicion1.getCoordenadaY(), radio1,
				posicion2.getCoordenadaX(), posicion2.getCoordenadaY(), radio2);
	}

}
