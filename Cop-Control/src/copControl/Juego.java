package copControl;

import java.util.List;
import avion.AvionSimple;
import avion.AvionPesado;
import avion.AvionComputarizado;
import avion.Helicoptero;
import avion.Avion;


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
		
		Avion unAvion=null;
		//meter dentro de metodo que retorne unAvion
		switch (enteroAlAzarEntreMyN) {
			//caso AvionSimple
			case 1:
				AvionSimple unAvionSimple = new AvionSimple(posicionesExtremo.get(0),posicionesExtremo.get(1));
				unAvion=unAvionSimple;
				break;
			//caso AvionPesado
			case 2:
				AvionPesado unAvionPesado = new AvionPesado(posicionesExtremo.get(0),posicionesExtremo.get(1));
				unAvion=unAvionPesado;
				break;
			//caso Helicoptero
			case 3:
				Helicoptero unHelicoptero = new Helicoptero(posicionesExtremo.get(0),posicionesExtremo.get(1));
				unAvion= unHelicoptero;
				break;
			//caso AvionComputarizado
			case 4:
				AvionComputarizado unAvionComputarizado = new AvionComputarizado(posicionesExtremo.get(0),nivelActual.getPosicionPistaNoHelipuerto());
				unAvion = unAvionComputarizado;
				break;
		}
		
		if (unAvion.tienePistaAdecuada()){
			nivelActual.colocarAvionEnAire(unAvion);
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
