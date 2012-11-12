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
		avionesEnAire=null;
		this.setPistas(pistas);
		//tamaño de la "matriz" de posiciones 50x50
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


	public boolean tieneAvionesVolando() {
		return (avionesEnAire!=null);
		
	}

	public List<Posicion> getPosicionesExtremos() {
		
		List<Posicion> posicionesExtremos= new ArrayList<Posicion>();
		Posicion unaPosicionExtremo= new Posicion(50,50); // reemplazar linea de codigo por obtencion de posicion margen en random
		Posicion otraPosicionExtremo= new Posicion(0,0); // reemplazar linea de codigo por obtencion de posicion margen en random
		posicionesExtremos.add(unaPosicionExtremo);
		posicionesExtremos.add(otraPosicionExtremo);
		return posicionesExtremos;
	}

	public Posicion getPosicionPistaNoHelipuerto() {
		Posicion unaPosicionPistaNoHelipuerto= new Posicion(25,25); //reemplazar por codigo real
		return unaPosicionPistaNoHelipuerto;
	}

	public void colocarAvionEnAire(Avion unAvion) {
		avionesEnAire.add(unAvion);
	}


}
