package Observador;

import java.util.List;

import pista.Helipuerto;
import pista.Pista;
import pista.PistaSimple;

import vista.VistaAvionSimple;
import vista.VistaHelicoptero;
import vista.VistaHelipuerto;
import vista.VistaPistaSimple;
import avion.Avion;
import avion.AvionSimple;
import avion.Helicoptero;

import copControl.Juego;
import fiuba.algo3.titiritero.modelo.GameLoop;
import fiuba.algo3.titiritero.modelo.ObjetoDibujable;

public class AdministradorDeVistas implements Observador {
	
	private Juego juego;	
	private GameLoop gameloop;
	
	public AdministradorDeVistas (Juego juego,GameLoop gameloop){
		this.juego= juego;		
		this.gameloop = gameloop;
		this.actualizar();
	}
	
	
	@Override
	public void actualizar() {
		
		if(juego.estaJugandose()){
			
			this.gameloop.removerObjetosDibujables();
			actualizarVistasAviones();			
			actualizarVistasPistas();	
			
		}else{
			this.gameloop.detenerEjecucion();
			
		}

	}


	/**
	 * 
	 */
	private void actualizarVistasPistas() {
		List<Pista> pistas = this.juego.getNivelActual().getMapa().getPistas();
		
		for (Pista pista : pistas) {
			this.gameloop.agregar(nuevaVistaDePista(pista));
		}
	}


	private void actualizarVistasAviones() {
		List<Avion> aviones=this.juego.getNivelActual().getAvionesVolando();
		
		for (Avion avion : aviones) {
			this.gameloop.agregar(nuevaVistaDeAvion(avion));
			
		}
	}

	private ObjetoDibujable nuevaVistaDePista(Pista pista) {
		if(pista.getClass()==PistaSimple.class){
			return new VistaPistaSimple(pista);
		}
		if(pista.getClass()==Helipuerto.class){
			return new VistaHelipuerto(pista);
		}
		return null;
	}
	
	private ObjetoDibujable nuevaVistaDeAvion(Avion  avion) {
		if(avion.getClass()==AvionSimple.class){
			return new VistaAvionSimple(avion);
		}
		if(avion.getClass()==Helicoptero.class){
			return new VistaHelicoptero(avion);
		}
		return null;
	}



}
