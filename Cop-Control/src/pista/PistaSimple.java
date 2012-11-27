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
import pista.PosicionesEntradaSobrantesException;
public class PistaSimple extends Pista{
	
	private final static int ANCHO= 20;
	private final static int ALTO= 20;
	private final static Color COLOR = Color.BLUE;
	
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

	@Override
	public void dibujar(SuperficieDeDibujo superficieDeDibujo) {

		Graphics grafico = ((SuperficiePanel)superficieDeDibujo).getBuffer();
		grafico.setColor(this.COLOR);
		grafico.fillRect((int)getPosicionEntrada().getCoordenadaX() ,(int) getPosicionEntrada().getCoordenadaY()
				, this.ANCHO, this.ALTO);
		
	}

	private Posicion getPosicionEntrada(){
		return this.getPosicionesEntrada().get(0);
		
	}
}
