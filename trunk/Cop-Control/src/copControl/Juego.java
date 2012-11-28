package copControl;


import java.util.List;

import fiuba.algo3.titiritero.modelo.ObjetoVivo;
import avion.AvionSimple;
import avion.AvionPesado;
import avion.AvionComputarizado;
import avion.Helicoptero;
import avion.Avion;


public class Juego implements ObjetoVivo {
	
	private Nivel nivelActual;  	/* implementa comparable, cheque niveles dificultad creciente o hago sort para ordenar bajo exepcion  */
	private Integer cantidadAvionesAterrizados;
	private Jugador jugador;
	private List<Nivel> niveles;
	private boolean ganado;

	public Juego(Jugador jugador,List<Nivel> niveles){
		this.jugador=jugador;
		this.niveles=niveles;
		nivelActual=niveles.get(0);
		cantidadAvionesAterrizados=0;
		ganado=false;
		
	}
	/**
	 * @return the nivelActual
	 */
	public Nivel getNivelActual() {
		return nivelActual;
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

	//llamar en hilo de gameLoop por un timer con tiempo=seteado a convenir
	public boolean huboChoque(){
		
		return this.nivelActual.huboChoque();
		
		
	}

	//llamar en hilo de gameLoop por un timer con tiempo=seteado a convenir
	//Agregue que se modifique la cantidad de aviones aterrizados por cada ciclo
	public void chequearAterrizajes(){
		cantidadAvionesAterrizados=cantidadAvionesAterrizados+nivelActual.aterrizarAviones();
	}

	//llamar en hilo de gameLoop por un timer con tiempo=nivel->dificultad->velocidad
	public void actualizarMovimientoDeAviones(){
		this.nivelActual.avanzarAvionesEnAire();
	}
	
	private Avion crearAvionAlAzar(){
		Integer M= 1; 
		Integer N= 4;
		// Valor random entre M y N, ambos incluidos.
		Integer enteroAlAzarEntreMyN = (int) Math.floor(Math.random()*(N-M+1)+M);  
		List<Posicion> posicionesExtremo = nivelActual.getPosicionesExtremos();
		Avion unAvion=null;
		switch (enteroAlAzarEntreMyN) {
			//caso AvionSimple
			case 1:
				AvionSimple unAvionSimple = new AvionSimple(posicionesExtremo.get(0),posicionesExtremo.get(1));
				return unAvionSimple;
			//caso AvionPesado
			case 2:
				AvionPesado unAvionPesado = new AvionPesado(posicionesExtremo.get(0),posicionesExtremo.get(1));
				return unAvionPesado;
			//caso Helicoptero
			case 3:
				Helicoptero unHelicoptero = new Helicoptero(posicionesExtremo.get(0),posicionesExtremo.get(1));
				return unHelicoptero;
			//caso AvionComputarizado
			case 4:
				AvionComputarizado unAvionComputarizado = new AvionComputarizado(posicionesExtremo.get(0));
				unAvionComputarizado.moverHacia(this.nivelActual.getPosPistaAdecuada(unAvionComputarizado));
				return unAvionComputarizado;
		}
		
		return unAvion;
	}
	
	//llamar en hilo de gameLoop por un timer con tiempo=nivel->dificultad->velocidadDeAparicion
	public void colocarAvion() {
		boolean tienePistaAdecuada= false;
		while (!tienePistaAdecuada){
			
			Avion unAvion= this.crearAvionAlAzar();
			if (nivelActual.tienePistaAdecuada(unAvion)){
				nivelActual.colocarAvionEnAire(unAvion);
				tienePistaAdecuada=true;
			}
			
		}	
		
	}
	
	public void avanzarNivel(){		
		try {
			nivelActual= niveles.get(niveles.indexOf(nivelActual)+1);
		} catch (IndexOutOfBoundsException e) {
			// Si no hay mas niveles en la lista se gana ?
			ganado=true;
		}
	
	}
	public boolean seGano() {
		return this.ganado;
		
	}
	@Override
	public void vivir() {
		this.colocarAvion();
		this.chequearAterrizajes();
		this.huboChoque();
		this.actualizarMovimientoDeAviones();
		
	}
}


