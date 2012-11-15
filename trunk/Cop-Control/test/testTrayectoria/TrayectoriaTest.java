package testTrayectoria;

import avion.AvionSimple;
import copControl.Posicion;
import copControl.Trayectoria;
import junit.framework.TestCase;

public class TrayectoriaTest extends TestCase {

	private Trayectoria trayectoria;
	private AvionSimple avionSimple;
	private Posicion posicionInicial;
	private Posicion posicionFinal;
	private Posicion nuevoDestino;
	
	public void testAvionSimpleSeCreaConSiguienteDestinoIgualAPosicionFinal(){
		posicionInicial= new Posicion(1,1);
		posicionFinal = new Posicion(5,1);
		avionSimple= new AvionSimple(posicionInicial,posicionFinal);
		assertTrue(avionSimple.getPosicionActual()==posicionInicial);
		Posicion posicionDeDestino= avionSimple.getDestinoActual();
		assertTrue(posicionDeDestino==posicionFinal);
		
	}
	
	public void testAvionSimpleCambiaSuPosicionAlAvanzar(){
		posicionInicial= new Posicion(1,1);
		posicionFinal = new Posicion(5,1);
		avionSimple= new AvionSimple(posicionInicial,posicionFinal);
		avionSimple.avanzar();
		Posicion posicionActual= avionSimple.getPosicionActual();
		assertFalse(posicionActual==posicionInicial);
	}
	

	public void testAvionSimpleVaCambiandoSuPosActualHastaLlegarAPosFinEnCaminoRecto(){
		posicionInicial= new Posicion(1,1);
		posicionFinal = new Posicion(5,1);
		avionSimple= new AvionSimple(posicionInicial,posicionFinal);
		avionSimple.avanzar(); //(2,1)
		avionSimple.avanzar(); //(3,1)
		avionSimple.avanzar(); //(4,1)
		assertFalse(avionSimple.getPosicionActual()==posicionFinal);
		avionSimple.avanzar(); //(5,1)==posFin
		assertTrue(avionSimple.getPosicionActual().igualA(posicionFinal));
		
		/* llega a destino pero hace pasos de mas en el camino que deberia de ser recto, y varias veces retrocede 
		 * de posicion ( ver consola ). Cada vez q ejecuta test genera un recorrido distinto y no deberia haber 
		 * complicaciones en este test porq es un recorrido recto. Si sigo intentando otro avanzar pincha por pointer null 
		 * ya que no hay mas destinos y getDestinoActual le devuelve null. Hay que hacer que al llegar al ultimo 
		 * destino se siga moviendo en la misma direccion hasta el borde del mapa.
		*/

	}
	
	public void testAvionSimpleLlegaAPosFinAtravezDeCaminoDiagonal(){
		posicionInicial= new Posicion(1,1);
		posicionFinal = new Posicion(5,5);
		avionSimple= new AvionSimple(posicionInicial,posicionFinal);
		
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
		avionSimple= new AvionSimple(posicionInicial,posicionFinal);
		
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
		avionSimple= new AvionSimple(posicionInicial,posicionFinal);
		
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
		avionSimple= new AvionSimple(posicionInicial,posicionFinal);
		
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
	public void setUp(){
		
	}
	
}