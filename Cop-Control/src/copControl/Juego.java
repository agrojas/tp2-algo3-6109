package copControl;

import java.util.List;
import avion.AvionSimple;
import avion.AvionPesado;
import avion.AvionComputarizado;
import avion.Helicoptero;


public class Juego {
	
	private Nivel nivelActual;  	/* implementa comparable, cheque niveles dificultad creciente o hago sort para ordenar bajo exepcion  */
	private Integer cantidadAvionesAterrizados;
	private Jugador jugador;
	private List<Nivel> niveles;


	/**
	 * @return the nivelActual
	 */
	public Nivel getNivelActual() {
		return nivelActual;
	}

	// falta terminar de codear metodo
	public void colocarAvion() {
		Integer M= 1; 
		Integer N= 4;
		// Valor random entre M y N, ambos incluidos.
		Integer enteroAlAzarEntreMyN = (int) Math.floor(Math.random()*(N-M+1)+M);  
		List<Posicion> posicionesExtremo = nivelActual.getPosicionesExtremos();
		switch (enteroAlAzarEntreMyN) {
			//caso AvionSimple
			case 1:
				AvionSimple unAvionSimple = new AvionSimple(posicionesExtremo.get(0),posicionesExtremo.get(1));
				break;
			//caso AvionPesado
			case 2:
				AvionPesado unAvionPesado = new AvionPesado(posicionesExtremo.get(0),posicionesExtremo.get(1));
				break;
			//caso Helicoptero
			case 3:
				Helicoptero unHelicoptero = new Helicoptero(posicionesExtremo.get(0),posicionesExtremo.get(1));
				break;
			//caso AvionComputarizado
			case 4:
				
				break;
			
		}
	}

	/**
	 * @return the cantidadAvionesAterrizados
	 */
	public Integer getCantidadAvionesAterrizados() {
		return cantidadAvionesAterrizados;
	}

	/**
	 * @return the jugador
	 */
	public Jugador getJugador() {
		return jugador;
	}

	/**
	 * @return the niveles
	 */
	public List<Nivel> getNiveles() {
		return niveles;
	}

	

}
