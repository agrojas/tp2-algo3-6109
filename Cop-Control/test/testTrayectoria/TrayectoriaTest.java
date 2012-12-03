package testTrayectoria;

import avion.AvionSimple;
import copControl.Mapa;
import copControl.Posicion;
import junit.framework.TestCase;

public class TrayectoriaTest extends TestCase {

	private AvionSimple avionSimple;
	private Posicion posicionInicial;
	private Posicion posicionFinal;
	private Mapa mapa;
	public void testAvionSimpleSeCreaConSiguienteDestinoIgualAPosicionFinal(){
		posicionInicial= new Posicion(1,1);
		posicionFinal = new Posicion(5,1);
		avionSimple= new AvionSimple(posicionInicial,posicionFinal,mapa);
		assertTrue(avionSimple.getPosicionActual()==posicionInicial);
		Posicion posicionDeDestino= avionSimple.getDestinoActual();
		assertTrue(posicionDeDestino==posicionFinal);
		
	}
	
	public void testAvionSimpleCambiaSuPosicionAlavanzar(){
		posicionInicial= new Posicion(1,1);
		posicionFinal = new Posicion(5,1);
	
		avionSimple= new AvionSimple(posicionInicial,posicionFinal,mapa);
		avionSimple.avanzar();
		Posicion posicionActual= avionSimple.getPosicionActual();
		assertFalse(posicionActual==posicionInicial);
	}
	

	public void testAvionSimpleVaCambiandoSuPosActualHastaLlegarAPosFinEnCaminoRecto(){
		posicionInicial= new Posicion(1,1);
		posicionFinal = new Posicion(5,1);
		avionSimple= new AvionSimple(posicionInicial,posicionFinal, mapa);
		avionSimple.avanzar(); //(2,1)
		avionSimple.avanzar(); //(3,1)
		avionSimple.avanzar(); //(4,1)
		assertFalse(avionSimple.getPosicionActual()==posicionFinal);
		avionSimple.avanzar(); //(5,1)==posFin
		assertTrue(avionSimple.getPosicionActual().igualA(posicionFinal));
		
	}
	
	public void testAvionSimpleLlegaAPosFinAtravezDeCaminoDiagonal(){
		posicionInicial= new Posicion(1,1);
		posicionFinal = new Posicion(5,5);
		avionSimple= new AvionSimple(posicionInicial,posicionFinal, mapa);
		
		avionSimple.mostrarPosEnConsola();//BORRAR
		avionSimple.avanzar(); //(2,1)
		
		avionSimple.mostrarPosEnConsola();//BORRAR
		avionSimple.avanzar(); //(3,3)
		
		avionSimple.mostrarPosEnConsola();//BORRAR
		avionSimple.avanzar(); //(4,4)
		
		avionSimple.mostrarPosEnConsola();//BORRAR
		avionSimple.avanzar(); //(5,5)
		
		avionSimple.mostrarPosEnConsola();//BORRAR
		
		assertTrue(avionSimple.getPosicionActual().igualA(posicionFinal));	
	
	}
	
	public void testAvionSimpleLlegaAPosFinAtravezDeCaminoVertical(){
		posicionInicial= new Posicion(5,4);
		posicionFinal = new Posicion(5,0);
		avionSimple= new AvionSimple(posicionInicial,posicionFinal, mapa);
		
		avionSimple.mostrarPosEnConsola();//BORRAR
		avionSimple.avanzar(); //(5,1)
		
		avionSimple.mostrarPosEnConsola();//BORRAR
		avionSimple.avanzar(); //(5,2)
		
		avionSimple.mostrarPosEnConsola();//BORRAR
		avionSimple.avanzar(); //(5,3)
		
		avionSimple.mostrarPosEnConsola();//BORRAR
		avionSimple.avanzar(); //(5,4)
		
		avionSimple.mostrarPosEnConsola();//BORRAR
		
		assertTrue(avionSimple.getPosicionActual().igualA(posicionFinal));	
	
	}
	
	// con este test se ve que da prioridad al movimiento diagonal ante el recto para ahorrar pasos
	public void testAvionSimpleLlegaAPosFinAtravezDeCaminoIncierto(){
		posicionInicial= new Posicion(0,0);
		posicionFinal = new Posicion(2,4);
		avionSimple= new AvionSimple(posicionInicial,posicionFinal, mapa);
		
		avionSimple.mostrarPosEnConsola();//BORRAR
		avionSimple.avanzar(); //(1,1)
		
		avionSimple.mostrarPosEnConsola();//BORRAR
		avionSimple.avanzar(); //(2,2)
		
		avionSimple.mostrarPosEnConsola();//BORRAR
		avionSimple.avanzar(); //(2,3)
		
		avionSimple.mostrarPosEnConsola();//BORRAR
		avionSimple.avanzar(); //(2,4)
		
		avionSimple.mostrarPosEnConsola();//BORRAR
		
		assertTrue(avionSimple.getPosicionActual().igualA(posicionFinal));	
	
	}
	
	public void testAvionSimpleSeMueveCambiandoDosDestinos(){
		
		posicionInicial= new Posicion(0,0);
		posicionFinal = new Posicion(2,2);
		avionSimple= new AvionSimple(posicionInicial,posicionFinal, mapa);
		
		avionSimple.mostrarPosEnConsola();//BORRAR
		avionSimple.avanzar(); //(1,1)
		
		Posicion nuevoDestino = new Posicion(2,5);
		avionSimple.moverHacia(nuevoDestino);
		
		avionSimple.mostrarPosEnConsola();//BORRAR
		avionSimple.avanzar(); //(2,2)
		
		avionSimple.mostrarPosEnConsola();//BORRAR llego a primer destino
		
		avionSimple.avanzar(); //(2,3)
		avionSimple.mostrarPosEnConsola();//BORRAR
		
		avionSimple.avanzar(); //(2,4)
		avionSimple.mostrarPosEnConsola();//BORRAR
		
		avionSimple.avanzar(); //(2,5)
		avionSimple.mostrarPosEnConsola();//BORRAR
		
		assertTrue(avionSimple.getPosicionActual().igualA(nuevoDestino));
		
	}
	
	public void testAvionSimpleSeMueveEntreTresDestinos(){
		
		posicionInicial= new Posicion(0,0);
		posicionFinal = new Posicion(1,1);
		avionSimple= new AvionSimple(posicionInicial,posicionFinal, mapa);
		
		Posicion nuevoDestino = new Posicion(3,3);
		avionSimple.moverHacia(nuevoDestino);
		
		avionSimple.mostrarPosEnConsola();//BORRAR
		avionSimple.avanzar(); //(1,1)
		
		avionSimple.mostrarPosEnConsola();//BORRAR
		avionSimple.avanzar(); //(2,2)
		
		Posicion otroDestino = new Posicion(3,5);
		avionSimple.moverHacia(otroDestino);
		
		avionSimple.mostrarPosEnConsola();//BORRAR
		
		avionSimple.avanzar(); //(3,3)  llego a primer destino, debe dirijirse hacia (3,5)
		avionSimple.mostrarPosEnConsola();//BORRAR
		
		Posicion otroDestino2 = new Posicion(1,5);
		avionSimple.moverHacia(otroDestino2);
		
		avionSimple.avanzar(); //(3,4)
		avionSimple.mostrarPosEnConsola();//BORRAR
		
		avionSimple.avanzar(); //(3,5) llego a segundo destino, debe dirijirse hacia (1,5)
		avionSimple.mostrarPosEnConsola();//BORRAR
		
		avionSimple.avanzar(); //(2,5)
		avionSimple.mostrarPosEnConsola();//BORRAR
		
		avionSimple.avanzar(); //(1,5)
		avionSimple.mostrarPosEnConsola();//BORRAR
		
		assertTrue(avionSimple.getPosicionActual().igualA(otroDestino2));
		
	}
	public void setUp(){
		mapa= new Mapa();
	}
	
}
