package Observador;

import java.util.List;
import pista.Pista;

import vista.VistaAvionSimple;
import vista.VistaPistaSimple;
import avion.Avion;

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
			this.gameloop.agregar(vistaPista(pista));
		}
	}


	private void actualizarVistasAviones() {
		List<Avion> aviones=this.juego.getNivelActual().getAvionesVolando();
		
		for (Avion avion : aviones) {
			this.gameloop.agregar(nuevaVista(avion));
			
		}
	}

	private ObjetoDibujable vistaPista(Pista pista) {
		return new VistaPistaSimple(pista);
	}
	
	private ObjetoDibujable nuevaVista(Avion  avion) {
		// TODO Auto-generated method stub
		return new VistaAvionSimple(avion);
	}



}
