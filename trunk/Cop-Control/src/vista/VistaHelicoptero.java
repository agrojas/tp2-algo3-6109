package vista;

import java.awt.Color;

import fiuba.algo3.titiritero.dibujables.Circulo;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class VistaHelicoptero extends Circulo{
	
	public VistaHelicoptero(ObjetoPosicionable modelo) {
		super(25,  modelo);
		this.setColor(Color.BLUE);
	}

}
