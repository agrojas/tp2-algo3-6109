package testPista;


import copControl.Posicion;

import junit.framework.TestCase;
import pista.*;


public class PistaTest extends TestCase {
		
	private Pista pista;
	private Posicion posicionPista;

	public void testDebeLanzarExcepcionSiNoRecibePosicion() {
		try{
			System.out.println(posicionPista);
			pista= new PistaSimple(posicionPista);
			}
		
		catch (PosicionesEntradaVaciaException e){
			
			
		}
		}

}
