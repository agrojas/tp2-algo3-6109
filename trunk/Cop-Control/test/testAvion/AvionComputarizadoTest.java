package testAvion;

import java.util.LinkedList;
import java.util.List;

import pista.Helipuerto;
import pista.PistaSimple;

import pista.PosicionesEntradaVaciaException;
import avion.AvionComputarizado;
import copControl.Mapa;
import copControl.Posicion;
import junit.framework.TestCase;

public class AvionComputarizadoTest extends TestCase {
	
	Mapa mapaDeMovimiento;
	
	public void testUnAvionComputarizadoPuedeAterrizarEnUnaPistaSimple() throws PosicionesEntradaVaciaException{
		Posicion posicionInicial= new Posicion(1,1);
		Posicion posicionFinal= new Posicion(5,5);
		PistaSimple pistaSimple = new PistaSimple(posicionFinal);
		
		AvionComputarizado avion = new AvionComputarizado(posicionInicial,this.mapaDeMovimiento);
		
		assertTrue(avion.puedeAterrizar(pistaSimple));
	}
	
	public void testUnAvionComputarizadoNoPuedeAterrizarEnUnHelipuerto() throws PosicionesEntradaVaciaException{
		Posicion posicionInicial= new Posicion(1,1);
		Posicion posicionFinal= new Posicion(5,5);
		Helipuerto helipuerto = new Helipuerto(posicionFinal);
		
		AvionComputarizado avion = new AvionComputarizado(posicionInicial,this.mapaDeMovimiento);
		
		assertFalse(avion.puedeAterrizar(helipuerto));
	}
	
	public void testUnAvionComputarizadoNoEsControlable(){
		Posicion posicionInicial= new Posicion(1,1);
		AvionComputarizado avion = new AvionComputarizado(posicionInicial,this.mapaDeMovimiento);
		
		assertFalse(avion.esControlable());
	
	}
	
	
	public void setUp(){
		
		mapaDeMovimiento=new Mapa();
	}

}
