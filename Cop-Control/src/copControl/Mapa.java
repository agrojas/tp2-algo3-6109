package copControl;

import java.util.ArrayList;
import java.util.List;

import pista.Pista;
import avion.Avion;
import avion.AvionSimple;

public class Mapa {
	private List<Avion> avionesEnAire;
	private List<Pista> pistas;
	
	public Mapa(List<Pista>pistas) {
		this.avionesEnAire= new ArrayList<Avion>();
		this.setPistas(pistas);
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

}