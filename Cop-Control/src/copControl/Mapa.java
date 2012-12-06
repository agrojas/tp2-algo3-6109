package copControl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import pista.Pista;
import avion.Avion;
import avion.AvionComputarizado;

public class Mapa {
	private List<Avion> avionesEnAire;
	private List<Pista> pistas;

	private Integer dimension;
	
	public Mapa(List<Pista>pistas) {
		this.avionesEnAire= new ArrayList<Avion>();
		this.setPistas(pistas);
		//tama�o de la "matriz" de posiciones 50x50
		this.dimension = 400;
	}

	public Mapa() {
		this.avionesEnAire= new ArrayList<Avion>();
		this.setPistas(null);
		this.dimension=400;
	}

	public List<Avion> getAvionesEnAire() {
		return avionesEnAire;
	}

	public List<Pista> getPistas() {
		return pistas;
	}

	public void setPistas(List<Pista> pistas) {
		this.pistas = pistas;
	}


	public boolean tieneAvionesVolando() {
		return (!avionesEnAire.isEmpty());
		
	}

	//cambiar a private
	public Posicion generarPosicionExtremoAlAzar(){
		
		Posicion posicionADevolver=null;
		
		Integer M= 1; 
		Integer N= 4;
		// Valor random entre M y N, ambos incluidos para utilizar en el switch.
		Integer enteroAlAzarEntreMyN = (int) Math.floor(Math.random()*(N-M+1)+M);  
			
		
		Integer MinimoDimension= 0; 
		Integer MaximoDimension= this.dimension;
		// Valor random entre 0 y Dimension, ambos incluidos para crear Posicion Extremo.
		Integer enteroAlAzarEntreCeroYDimension = (int) Math.floor(Math.random()*(MaximoDimension-MinimoDimension+1)+MinimoDimension);
		System.out.println("Entero al azar entre cero y dimension:");
		System.out.println(enteroAlAzarEntreCeroYDimension);
		
		switch (enteroAlAzarEntreMyN) {
		//Posicion Extremo superior
		case 1:
			posicionADevolver= new Posicion(enteroAlAzarEntreCeroYDimension,0);
			break;
		//Posicion Extremo inferior
		case 2:
			posicionADevolver= new Posicion(enteroAlAzarEntreCeroYDimension,this.dimension);
			break;
		//Posicion Extremo izquierdo
		case 3: 
			posicionADevolver= new Posicion(0,enteroAlAzarEntreCeroYDimension);
			break;
		//Posicion Extremo Derecho
		case 4:
			posicionADevolver= new Posicion(this.dimension,enteroAlAzarEntreCeroYDimension);
			break;			
		}
			
		return posicionADevolver;
		
	}
	
	public Posicion getPosPistaAdecuada(Avion unAvion) {
		
//		List<Pista> pistas=this.getPistas();
		Iterator<Pista> itPistas= this.pistas.iterator();
		Pista pistaAEvaluar= null;
		boolean pistaEncontrada = false;
				
		while (itPistas.hasNext() && !pistaEncontrada){
				pistaAEvaluar=itPistas.next();
				pistaEncontrada= unAvion.puedeAterrizar(pistaAEvaluar);
				
			}
		
		
		 return (pistaAEvaluar.getPosicionEntrada());
		}
	
	
	//retorna una lista de dos posiciones dentro de dimension de mapa al azar
	public List<Posicion> getPosicionesExtremos() {
		
		List<Posicion> posicionesExtremos= new ArrayList<Posicion>();
 
		posicionesExtremos.add(this.generarPosicionExtremoAlAzar());
		posicionesExtremos.add(this.generarPosicionExtremoAlAzar());
		
		return posicionesExtremos;
	}

	public Posicion getPosicionPistaNoHelipuerto() {
		Posicion unaPosicionPistaNoHelipuerto= new Posicion(25,25); //reemplazar por invocacion a metodo con codigo real
		return unaPosicionPistaNoHelipuerto;
	}

	public void colocarAvionEnAire(Avion unAvion) {
		avionesEnAire.add(unAvion);
	}

	
	public Integer getDimension() {
		
		return this.dimension;
	}
	
	public Posicion getPosicionAleatoria(){
		Integer MinimoDimension= 0; 
		Integer MaximoDimension= this.dimension;
		// Valor random entre 0 y Dimension, ambos incluidos para crear Posicion Extremo.
		int enteroAlAzarX = (int) Math.floor(Math.random()*(MaximoDimension-MinimoDimension+1)+MinimoDimension);
		int enteroAlAzarY = (int) Math.floor(Math.random()*(MaximoDimension-MinimoDimension+1)+MinimoDimension);
		
		return new Posicion(enteroAlAzarX, enteroAlAzarY);
	}


	public boolean esPosicionExtremo(Posicion unaPosicion){
		
		double x1 = unaPosicion.getCoordenadaX();
		double y1 = unaPosicion.getCoordenadaY();
		
		//boolean bordeIzq= ((x1==0)&&(y1>=0)&&(y1<=this.dimension));
		  //boolean bordeSup=((y1==0)&&(x1>=0)&&(x1<=this.dimension));
		boolean bordeIzq= ((x1==0)||(y1>=0)&&(y1<=this.dimension));
		boolean bordeSup=((y1==0)||(x1>=0)&&(x1<=this.dimension));
		boolean bordeInf=((y1==this.dimension)&&((x1>=0)&&(x1<=this.dimension)));
		boolean bordeDer=((x1==this.dimension)&&((y1>=0)&&(y1<=this.dimension)));
	
		
		return (bordeIzq || bordeDer || bordeSup || bordeInf);
	}

}
