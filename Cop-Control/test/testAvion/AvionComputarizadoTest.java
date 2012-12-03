package testAvion;

import java.util.LinkedList;
import java.util.List;

import pista.Helipuerto;
import pista.PistaSimple;
import pista.PosicionesEntradaSobrantesException;
import pista.PosicionesEntradaVaciaException;
import avion.AvionComputarizado;
import copControl.Mapa;
import copControl.Posicion;
import junit.framework.TestCase;

public class AvionComputarizadoTest extends TestCase {
	
	Mapa mapaDeMovimiento;
	
	public void testUnAvionComputarizadoPuedeAterrizarEnUnaPistaSimple() throws PosicionesEntradaVaciaException, PosicionesEntradaSobrantesException{
		Posicion posicionInicial= new Posicion(1,1);
		Posicion posicionFinal= new Posicion(5,5);
		List<Posicion> posicionPista = new LinkedList<Posicion>();
		posicionPista.add(posicionFinal);
		PistaSimple pistaSimple = new PistaSimple(posicionPista);
		
		AvionComputarizado avion = new AvionComputarizado(posicionInicial,this.mapaDeMovimiento);
		
		assertTrue(avion.puedeAterrizar(pistaSimple));
	}
	
	public void testUnAvionComputarizadoNoPuedeAterrizarEnUnHelipuerto() throws PosicionesEntradaVaciaException{
		Posicion posicionInicial= new Posicion(1,1);
		Posicion posicionFinal= new Posicion(5,5);
		List<Posicion> posicionPista = new LinkedList<Posicion>();
		
		
		posicionPista.add(posicionFinal);
		Helipuerto helipuerto = new Helipuerto(posicionPista);
		
		AvionComputarizado avion = new AvionComputarizado(posicionInicial,this.mapaDeMovimiento);
		
		assertFalse(avion.puedeAterrizar(helipuerto));
	}
	
	public void setUp(){
		
		mapaDeMovimiento=new Mapa();
	}

}
