package testInicializador;

import copControl.Juego;
import Inicializadores.InicializadorJuego;
import junit.framework.TestCase;

public class TestInicializadorJuego extends TestCase {
	
	public void testInicializadorMeDevuelveUnJuegoConEstado(){
		
		Juego nuevoJuego = InicializadorJuego.juegoInicializado();
		assert(nuevoJuego != null);
	}

}
