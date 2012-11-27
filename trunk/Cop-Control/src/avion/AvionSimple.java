package avion;

import java.awt.Color;
import java.awt.Graphics;

import pista.Pista;
import copControl.Posicion;
import fiuba.algo3.titiritero.dibujables.SuperficiePanel;
import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;

public class AvionSimple extends Avion{
	
	private final static int ANCHO= 10;
	private final static int ALTO= 10;
	private final static Color COLOR = Color.YELLOW;

	public AvionSimple(Posicion posIni, Posicion posFin) {
		super(posIni, posFin);
		esControlable=true;
		}

	public void moverHacia(Posicion unaPosicion){
		this.trayectoria.setDestino(unaPosicion);
		
	}
	
	@Override
	public boolean puedeAterrizar(Pista pista) {
		return pista.puedeAterrizar(this);
	}



	@Override
	public int getX() {
		return ((int)this.getPosicionActual().getCoordenadaX());
	}

	@Override
	public int getY() {
		return ((int)this.getPosicionActual().getCoordenadaY());
	}


	
	

}
