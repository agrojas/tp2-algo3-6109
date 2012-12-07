package testAvion;

import copControl.Mapa;
import copControl.Posicion;
import avion.Avion;
import avion.AvionSimple;
import junit.framework.TestCase;

public class AvionTest extends TestCase {
	
	
	Mapa mapaDeJuego;
	/**
	 * Vale en general para todas las clases que heredan de avion
	 */
	public void testUnAvionSabeSiEstaVolando(){
		Posicion posicionInicial= new Posicion(2,2);
		Posicion posicionFinal= new Posicion(3,3);
		AvionSimple avion = new AvionSimple(posicionInicial,posicionFinal,mapaDeJuego);
		assertTrue(avion.getEstaVolando());
		
	}
	
	public void testUnAvionSeCreaDesmarcado(){
		Posicion posicionInicial= new Posicion(2,2);
		Posicion posicionFinal= new Posicion(3,3);
		Avion avion = new AvionSimple(posicionInicial, posicionFinal, mapaDeJuego);
		assertFalse(avion.estaMarcado());
		
	}
	
	public void testUnAvionSabeSiEsControlable(){
		Posicion posicionInicial= new Posicion(2,2);
		Posicion posicionFinal= new Posicion(3,3);
		Avion avion = new AvionSimple(posicionInicial, posicionFinal, mapaDeJuego);
		assertTrue(avion.esControlable());
		
	}
	
	public void testUnAvionSabeSiEsDetenible(){
		Posicion posicionInicial= new Posicion(2,2);
		Posicion posicionFinal= new Posicion(3,3);
		Avion avion = new AvionSimple(posicionInicial, posicionFinal, mapaDeJuego);
		assertFalse(avion.esDetenible());
		
	}
	
	public void testUnAvionSeMarcaSiIndicoUnaPosicionQueEsteDentroDeSuRadio(){
		
		Posicion posicionInicial= new Posicion(2,2);
		Posicion posicionFinal= new Posicion(3,3);
		Posicion posicionQueMarca = new Posicion((int)posicionInicial.getCoordenadaX()+1, (int)posicionInicial.getCoordenadaY());
		Avion avion = new AvionSimple(posicionInicial, posicionFinal, mapaDeJuego);
		avion.esPosicionContenida(posicionQueMarca);
		assertTrue(avion.estaMarcado());
		
		
	}
	
	public void testSiUnAvionEstaMarcadoLoPuedoDesmarcar(){
		
		Posicion posicionInicial= new Posicion(2,2);
		Posicion posicionFinal= new Posicion(3,3);
		Posicion posicionQueMarca = new Posicion((int)posicionInicial.getCoordenadaX()+1, (int)posicionInicial.getCoordenadaY());
		Avion avion = new AvionSimple(posicionInicial, posicionFinal, mapaDeJuego);
		avion.esPosicionContenida(posicionQueMarca);
		avion.desmarcar();
		assertFalse(avion.estaMarcado());
		
		
	}
	
	public void setUp(){
		mapaDeJuego= new Mapa();
	}
	
	
	
}
