package copControl;

import java.util.ArrayList;
import java.util.List;

import pista.Pista;
import avion.Avion;
import avion.AvionSimple;

public class Mapa {
	private List<Avion> avionesEnAire;
	private List<Pista> pistas;
	private Posicion posicionMaxima;
	
	public Mapa(List<Pista>pistas) {
		this.avionesEnAire= new ArrayList<Avion>();
		this.setPistas(pistas);
		//tama�o de la "matriz" de posiciones 50x50
		this.posicionMaxima = new Posicion(50,50);
	}

	public List<Avion> getAvionesEnAire() {
		return avionesEnAire;
	}

	public List<Pista> getPistas() {
		return pistas;
	}

	private void setPistas(List<Pista> pistas) {
		this.pistas = pistas;
	}

	public void colocarAvionEnAire(AvionSimple avionSimple) {
		// TODO Auto-generated method stub
		
	}

	public boolean tieneAvionesVolando() {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Posicion> getPosicionesExtremos() {
		
		List<Posicion> posicionesExtremos= new ArrayList<Posicion>();
		Posicion unaPosicionExtremo= new Posicion(50,50); // reemplazar linea de codigo por obtencion de posicion margen en random
		posicionesExtremos.add(unaPosicionExtremo);
		return posicionesExtremos;
	}


}
