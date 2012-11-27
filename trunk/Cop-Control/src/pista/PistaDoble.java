package pista;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import avion.AvionComputarizado;
import avion.AvionPesado;
import avion.AvionSimple;
import avion.Helicoptero;

import copControl.Posicion;
import fiuba.algo3.titiritero.dibujables.SuperficiePanel;
import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;

public class PistaDoble extends Pista {
	private final static int ANCHO= 20;
	private final static int ALTO= 20;
	private final static Color COLOR = Color.RED;
	


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

	@Override
	public void dibujar(SuperficieDeDibujo superficieDeDibujo) {
		Posicion posEntrada = this.getPosicionesEntrada().get(0);
		Graphics grafico = ((SuperficiePanel)superficieDeDibujo).getBuffer();
		grafico.setColor(this.COLOR);
		grafico.fillRect((int)posEntrada.getCoordenadaX() ,(int) posEntrada.getCoordenadaY(), this.ANCHO, this.ALTO);
		
	}



}
