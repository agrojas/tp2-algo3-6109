package testPista;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import copControl.Posicion;

import junit.framework.TestCase;
import pista.*;


public class PistaTest extends TestCase {
		
	private Pista pista;
	private Posicion posicionPista;

	public void testDebeLanzarExcepcionSiNoRecibePosicion() throws PosicionesEntradaSobrantesException{
		try{
			System.out.println(posicionPista);
			pista= new PistaSimple(posicionPista);
			}
		
		catch (PosicionesEntradaVaciaException e){
			
			
		}
		}

}
