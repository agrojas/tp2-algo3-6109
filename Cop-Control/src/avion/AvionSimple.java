package avion;

import copControl.Posicion;

public class AvionSimple extends Avion{

	public AvionSimple(Posicion posIni, Posicion posFin) {
		super(posIni, posFin);
		this.velocidad=5;
		}

	public void moverHacia(Posicion unaPosicion){
		//Ver si aca se avanza segun lo que diga el titiritero
		//En principio iria un ciclo?
		this.avanzar();
		
	}
	public void avanzar(){
		
		
	}
	

}
