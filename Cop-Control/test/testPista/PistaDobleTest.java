package testPista;

import avion.AvionComputarizado;
import avion.AvionPesado;
import avion.AvionSimple;
import avion.Helicoptero;
import copControl.Mapa;
import copControl.Posicion;
import pista.PistaDoble;
import pista.PosicionesEntradaVaciaException;
import junit.framework.TestCase;

public class PistaDobleTest extends TestCase {
	
	
	private Mapa mapaDeJuego;
	
	
	public void testUnaPistaDobleDeberiaTenerUnaEntradaSecundariaAUnaDistanciaDelLargoDeLaPista() throws PosicionesEntradaVaciaException{
		
		Posicion posicionEntrada= new Posicion(2, 2);
		PistaDoble pista = new PistaDoble(posicionEntrada);
		double distanciaEntreEntradas= pista.getPosicionEntradaSecundaria().distanciaHasta(pista.getPosicionEntradaPrincipal());
		assertEquals(pista.getLargo(), (int)distanciaEntreEntradas);
	}
	
	public void testUnaPistaDobleDeberiaDejarAterrizarEnCualquieraDeLasDosEntradas() throws PosicionesEntradaVaciaException{
		
		Posicion posicionEntrada= new Posicion(2, 2);
		Posicion posicionInicio = new Posicion(22, 2);
		Posicion posFin= new Posicion(3, 3);;
		AvionSimple avion = new AvionSimple(posicionInicio, posFin, mapaDeJuego);
		PistaDoble pista = new PistaDoble(posicionEntrada);
		assertTrue(avion.aterrizar(pista));
		
	}
	
	public void testUnHelicopteroNoDeberiaPoderAterrizarEnUnaPistaDoble() throws PosicionesEntradaVaciaException{
		Posicion posicionEntrada= new Posicion(2, 2);
		Posicion posicionInicio = new Posicion(22, 2);
		Posicion posFin= new Posicion(3, 3);;
		Helicoptero avion = new Helicoptero(posicionInicio, posFin, mapaDeJuego);
		PistaDoble pista = new PistaDoble(posicionEntrada);
		assertFalse(avion.aterrizar(pista));
		
	}
	
	public void testUnAvionPesadoNoDeberiaPoderAterrizarEnUnaPistaDoble() throws PosicionesEntradaVaciaException{
		Posicion posicionEntrada= new Posicion(2, 2);
		Posicion posicionInicio = new Posicion(22, 2);
		Posicion posFin= new Posicion(3, 3);;
		AvionPesado avion = new AvionPesado(posicionInicio, posFin, mapaDeJuego);
		PistaDoble pista = new PistaDoble(posicionEntrada);
		assertFalse(avion.aterrizar(pista));
		
	}
	
	public void testUnAvionComputarizadoDeberiaPoderAterrizarEnUnaPistaDoble() throws PosicionesEntradaVaciaException{
		Posicion posicionEntrada= new Posicion(2, 2);
		Posicion posicionInicio = new Posicion(22, 2);
	
		AvionComputarizado avion = new AvionComputarizado(posicionInicio,  mapaDeJuego);
		PistaDoble pista = new PistaDoble(posicionEntrada);
		assertTrue(avion.aterrizar(pista));
		
	}
	
	public void setUp(){
		 mapaDeJuego = new Mapa();
		}


}
