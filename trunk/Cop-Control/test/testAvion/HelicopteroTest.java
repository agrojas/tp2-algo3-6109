/**
 * 
 */
package testAvion;

import java.util.LinkedList;
import java.util.List;

import pista.Helipuerto;
import pista.PistaSimple;
import avion.Helicoptero;
import copControl.Posicion;
import junit.framework.TestCase;

/**
 * @author Agu
 *
 */
public class HelicopteroTest extends TestCase {
	
	public void testUnHelicopteroNoPuedeAterrizarEnUnaPistaSimple(){
		Posicion posicionInicial= new Posicion(1,1);
		Posicion posicionFinal= new Posicion(5,5);
		List<Posicion> posicionPista = new LinkedList<Posicion>();
		posicionPista.add(posicionFinal);
		PistaSimple pistaSimple = new PistaSimple(posicionPista);
		
		Helicoptero helicoptero = new Helicoptero(posicionInicial, posicionFinal);
		
		assertFalse(helicoptero.puedeAterrizar(pistaSimple));
	}
	
	public void testUnHelicopteroPuedeAterrizarEnUnHelipuerto(){
		Posicion posicionInicial= new Posicion(1,1);
		Posicion posicionFinal= new Posicion(5,5);
		List<Posicion> posicionPista = new LinkedList<Posicion>();
		posicionPista.add(posicionFinal);
		Helipuerto helipuerto = new Helipuerto(posicionPista);
		
		Helicoptero helicoptero = new Helicoptero(posicionInicial, posicionFinal);
		
		assertTrue(helicoptero.puedeAterrizar(helipuerto));
	}

}
