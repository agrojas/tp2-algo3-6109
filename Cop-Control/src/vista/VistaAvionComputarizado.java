package vista;

import java.awt.Color;

import fiuba.algo3.titiritero.dibujables.Circulo;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class VistaAvionComputarizado extends Circulo{
	
	public VistaAvionComputarizado(ObjetoPosicionable modelo) {
		super(30,  modelo);
		this.setColor(Color.WHITE);
	}	

}
