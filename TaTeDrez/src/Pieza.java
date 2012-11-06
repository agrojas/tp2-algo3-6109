
public abstract  class Pieza {
	private Posicion posicion;
	
//	public Pieza(Posicion posicion){
//		this.posicion=posicion;		
//	}
	public Posicion getPosicion(){
		return this.posicion;
	}
	public abstract boolean puedeMoverseA(Posicion unaPosicion);
	// Bajar ANT y un manual
}
