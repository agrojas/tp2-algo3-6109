package avion;

import pista.Helipuerto;
import pista.PistaDoble;
import pista.PistaLarga;
import pista.PistaSimple;
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
	@Override
	public boolean puedeAterrizar(PistaSimple pista) {
		return pista.puedeAterrizar(this);
	}

	@Override
	public boolean puedeAterrizar(PistaDoble pista) {
		return pista.puedeAterrizar(this);
	}

	@Override
	public boolean puedeAterrizar(PistaLarga pista) {
		return pista.puedeAterrizar(this);
	}

	@Override
	public boolean puedeAterrizar(Helipuerto pista) {
		return pista.puedeAterrizar(this);
	}

	
	

}
