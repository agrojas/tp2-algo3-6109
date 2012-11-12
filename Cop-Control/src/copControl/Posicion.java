package copControl;

public class Posicion {
	private int x;
	private int y;
	
	public Posicion(int i, int j) {
		
		this.x=i;
		this.y=j;
		
		
	}
	
	
	public int getCoordenadaX(){
		return this.x;
	}
	
	public int getCoordenadaY(){
		return this.y;
	}
	
	public boolean igualA (Posicion otraPosicion){
		
		return ((this.x== otraPosicion.getCoordenadaX()) && (this.y== otraPosicion.getCoordenadaY()));
		
	}

}
