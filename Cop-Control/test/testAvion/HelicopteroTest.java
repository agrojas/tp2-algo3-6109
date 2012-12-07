/**
 * 
 */
package testAvion;

import java.util.LinkedList;
import java.util.List;

import pista.Helipuerto;
import pista.PistaSimple;
import pista.PosicionesEntradaVaciaException;
import avion.Helicoptero;
import copControl.Mapa;
import copControl.Posicion;
import junit.framework.TestCase;


/**
 * @author Agu
 *
 */
public class HelicopteroTest extends TestCase {
	
	private Mapa mapaDeJuego;
	
	
	public void testUnHelicopteroNoPuedeAterrizarEnUnaPistaSimple() throws PosicionesEntradaVaciaException{
		Posicion posicionInicial= new Posicion(1,1);
		Posicion posicionFinal= new Posicion(5,5);
		PistaSimple pistaSimple = new PistaSimple(posicionFinal);
		
		Helicoptero helicoptero = new Helicoptero(posicionInicial, posicionFinal,mapaDeJuego);
		
		assertFalse(helicoptero.puedeAterrizar(pistaSimple));
	}
	
	public void testUnHelicopteroPuedeAterrizarEnUnHelipuerto() throws PosicionesEntradaVaciaException{
		Posicion posicionInicial= new Posicion(1,1);
		Posicion posicionFinal= new Posicion(5,5);
		Helipuerto helipuerto = new Helipuerto(posicionFinal);
		
		Helicoptero helicoptero = new Helicoptero(posicionInicial, posicionFinal,mapaDeJuego);
		
		assertTrue(helicoptero.puedeAterrizar(helipuerto));
	}
	
	public void testUnHelicopteroEsDetenible() {
		Posicion posicionInicial= new Posicion(1,1);
		Posicion posicionFinal= new Posicion(5,5);		
		Helicoptero helicoptero = new Helicoptero(posicionInicial, posicionFinal,mapaDeJuego);
		assertTrue(helicoptero.esDetenible());
		
	}
	
	public void testUnHelicopteroSeDetiene() {
		Posicion posicionInicial= new Posicion(1,1);
		Posicion posicionFinal= new Posicion(5,5);		
		Helicoptero helicoptero = new Helicoptero(posicionInicial, posicionFinal,mapaDeJuego);
		helicoptero.detener();
		assertTrue(helicoptero.estaDetenido());
		
	}
	
	public void testSiUnHelicopteroSeDetienePuedeVolverAArrancar() {
		Posicion posicionInicial= new Posicion(1,1);
		Posicion posicionFinal= new Posicion(5,5);		
		Helicoptero helicoptero = new Helicoptero(posicionInicial, posicionFinal,mapaDeJuego);
		helicoptero.detener();
		helicoptero.arrancar();
		assertFalse(helicoptero.estaDetenido());
		
	}
	
	public void setUp(){
	 mapaDeJuego = new Mapa();
	}

}
