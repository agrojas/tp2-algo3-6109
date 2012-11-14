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
		
		assertTrue(avionSimple.getPosicionActual()==posicionInicial);
		Posicion posicionDeDestino= avionSimple.getDestinoActual();
		assertTrue(posicionDeDestino==posicionFinal);
		
	}
	
	public void testAvionSimpleCambiaSuPosicionAlAvanzar(){
		avionSimple.avanzar();
		Posicion posicionActual= avionSimple.getPosicionActual();
		assertFalse(posicionActual==posicionInicial);
	}
	

	public void testAvionSimpleVaCambiandoSuPosActualHastaLlegarAPosFinEnCaminoRecto(){
		avionSimple.avanzar(); //(2,1)
		avionSimple.avanzar(); //(3,1)
		avionSimple.avanzar(); //(4,1)
		assertFalse(avionSimple.getPosicionActual()==posicionFinal);
		avionSimple.avanzar(); //(5,1)==posFin
	
		/* llega a destino pero hace pasos de mas en el camino que deberia de ser recto, y varias veces retrocede 
		 * de posicion ( ver consola ). Cada vez q ejecuta test genera un recorrido distinto y no deberia haber 
		 * complicaciones en este test porq es un recorrido recto. Si sigo intentando otro avanzar pincha por pointer null 
		 * ya que no hay mas destinos y getDestinoActual le devuelve null. Hay que hacer que al llegar al ultimo 
		 * destino se siga moviendo en la misma direccion hasta el borde del mapa.
		*/
		
		assertTrue(avionSimple.getPosicionActual().igualA(posicionFinal));	
		
		//avionSimple.avanzar();
		//avionSimple.avanzar();
		//avionSimple.avanzar(); 
		
	}
	
	public void setUp(){
		posicionInicial= new Posicion(1,1);
		posicionFinal = new Posicion(5,1);
		avionSimple= new AvionSimple(posicionInicial,posicionFinal);
	}
	
}
