package testPista;


import copControl.Posicion;

import junit.framework.TestCase;
import pista.*;


public class PistaTest extends TestCase {
		

	private Posicion posicionPista;

	public void testDebeLanzarExcepcionSiNoRecibePosicion() {
		try{
			System.out.println(posicionPista);
			PistaSimple pista = new PistaSimple(posicionPista);
			}
		
		catch (PosicionesEntradaVaciaException e){
			
			
		}
		}

}
