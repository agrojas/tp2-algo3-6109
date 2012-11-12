package copControl;

import java.util.List;


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
		switch (enteroAlAzarEntreMyN) {
			//caso AvionSimple
			case 1:
				List<Posicion> posicionesExtremos = nivelActual.getPosicionesExtremos();
				break;
			//caso AvionPesado
			case 2:
				
				break;
			//caso Helicoptero
			case 3:
				
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
