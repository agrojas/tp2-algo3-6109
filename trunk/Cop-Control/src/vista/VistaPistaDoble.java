package vista;

import java.awt.Color;

import fiuba.algo3.titiritero.dibujables.Cuadrado;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

	
	
	

public class VistaPistaDoble extends Cuadrado{

	public VistaPistaDoble(ObjetoPosicionable objetoPosicionable) {
		super(30, 30, objetoPosicionable);
		this.setColor(Color.GREEN);
	}
}



