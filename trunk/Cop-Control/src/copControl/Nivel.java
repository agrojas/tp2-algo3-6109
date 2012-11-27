package copControl;

import java.util.List;
import java.util.Iterator;

import org.omg.CosNaming.IstringHelper;

import pista.Pista;

import avion.Avion;

public class Nivel {
	private Mapa mapa;
	private Dificultad dificultad;
	
	public Nivel(Mapa mapa, Dificultad dificultad) {
		this.mapa=mapa;
		this.dificultad=dificultad;
	}

	public Avion getAvionEnPosicion(Posicion unaPosicion) {
		Avion avionRecivido= null; 
		List<Avion> avionesEnAire=this.mapa.getAvionesEnAire();
		Iterator<Avion> it= avionesEnAire.iterator();

		while (it.hasNext()){
			Avion avionActual = it.next();
			if(unaPosicion == avionActual.getPosicionActual()){
				avionRecivido= avionActual;
			}		
		}
		
		return avionRecivido;
	}

	//remueve del aire los aviones que esten en condiciones de aterrizar
	public Integer aterrizarAviones() {
		Integer cantidadDeAterrizados=0;
		
		List<Pista> pistas = this.mapa.getPistas();
		Avion avionAterrizado=null;
		//Recorro las pistas del mapa
		for (Pista pista : pistas) {
			Iterator<Avion> itAvionesEnAire =this.mapa.getAvionesEnAire().iterator();
			while(itAvionesEnAire.hasNext()){				
				Avion avion=itAvionesEnAire.next();
				//Si alguna de las posiciones de entrada de la pista coincide con la posicion del avion
				if(avion.aterrizar(pista)){
					cantidadDeAterrizados++;
					itAvionesEnAire.remove();
					
				}
			}
		
		}
		return cantidadDeAterrizados;
	}
	

	public List<Posicion> getPosicionesExtremos() {
		
		return mapa.getPosicionesExtremos();
	}

	public Posicion getPosicionPistaNoHelipuerto() {
		return (mapa.getPosicionPistaNoHelipuerto());
	}

	public void colocarAvionEnAire(Avion unAvion) {
		mapa.colocarAvionEnAire(unAvion);
	
	}
	public boolean tieneAvionesVolando(){
		return mapa.tieneAvionesVolando();
	}
	
	
	public boolean tienePistaAdecuada(Avion unAvion){       
		List<Pista> pistas=this.mapa.getPistas();
		
		Iterator<Pista> it= pistas.iterator();
		boolean tienePistaAdecuada=false;
		
		while ((it.hasNext()) && !tienePistaAdecuada)
		{
			tienePistaAdecuada= unAvion.puedeAterrizar(it.next());
		}
		
		
		return tienePistaAdecuada;
	
	}

	public boolean huboChoque() {
		
		List<Avion> avionesEnAire =this.mapa.getAvionesEnAire();
		boolean chocoConOtroAvion=false;
		Avion avionActual;
		
		while ((!avionesEnAire.isEmpty()) && (!chocoConOtroAvion)) {
		
			
			Iterator<Avion> it= avionesEnAire.iterator();
			avionActual = it.next();
		
			//Defino nueva variable para almacenar resultado de metodo List.remove
			boolean huboCambio;
			huboCambio= avionesEnAire.remove(avionActual);
									
			chocoConOtroAvion = this.chocoConOtroAvion(avionActual,avionesEnAire);
		
		}		
	
		return chocoConOtroAvion;
	}

	private boolean chocoConOtroAvion(Avion avionActual,List<Avion> avionesEnAire) {
		
		boolean posicionIdentica= false;
		Iterator<Avion> it= avionesEnAire.iterator();
				
		while(it.hasNext() && (!posicionIdentica)){
			Avion avionAComparar = it.next();
			posicionIdentica = (avionAComparar.getPosicionActual().igualA(avionActual.getPosicionActual()));
		}
		
		return posicionIdentica;
	}

	public List<Avion> getAvionesVolando() {
		return mapa.getAvionesEnAire();
	}
	
	public void avanzarAvionesEnAire(){
		 
		List<Avion> avionesEnAire=this.mapa.getAvionesEnAire();
		Iterator<Avion> it= avionesEnAire.iterator();

		while (it.hasNext()){
			
			Avion avionActual = it.next();
			if (avionActual.getDestinoActual()== null)
			{
				avionActual.moverHacia(this.mapa.getPosicionesExtremos().get(0));
			}
			avionActual.vivir();
		}
		
	}
}
