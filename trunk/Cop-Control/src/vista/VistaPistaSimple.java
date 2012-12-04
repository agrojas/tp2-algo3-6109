package vista;

import java.awt.Color;

import fiuba.algo3.titiritero.dibujables.Circulo;
import fiuba.algo3.titiritero.dibujables.Cuadrado;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class VistaPistaSimple extends Circulo{

	public VistaPistaSimple(ObjetoPosicionable objetoPosicionable) {
		super(30, objetoPosicionable);
		this.setColor(Color.YELLOW);
	}

}
