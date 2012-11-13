package copControl;

import java.awt.Point;

public class Posicion {
	private Point coordenadas;
	
	public Posicion(int i, int j) {	
		coordenadas = new Point(i, j);
				
	}
	
	
	public double getCoordenadaX(){
		return this.coordenadas.getX();
	}
	
	public double getCoordenadaY(){
		return this.coordenadas.getY();
	}
	
	public boolean igualA (Posicion otraPosicion){
		return ((this.getCoordenadaX()== otraPosicion.getCoordenadaX()) && (this.getCoordenadaY()== otraPosicion.getCoordenadaY()));
		
	}
	
	public double distanciaHasta(Posicion otraPosicion){
		
		return this.coordenadas.distance(otraPosicion.getCoordenadaX(),otraPosicion.getCoordenadaY());
		
	}

}
