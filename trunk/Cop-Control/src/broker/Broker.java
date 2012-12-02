package broker;

import java.util.List;
import java.util.Observer;

import avion.Avion;

public class Broker {
	
	private List<Observer> listaDeObservadores;

	//metodo a ser llamado por Juego cuando se pone un avion en el aire para notificar al broker
	public void agregarAvion(Avion unAvion){
		
	}
	
	//metodo a ser llamado por Juego cuando aterrize un avion para notificar al broker
	public void aterrizoAvion (Avion unAvion){
		
	}
	
	//metodo a ser llamado por VentanaPrincipal o alguna otra ventana segun como resolvamos
	public void observarNuevoAvion(Observer unObservador){
	
	}
	
	//metodo a ser llamado por VentanaPrincipal o alguna otra ventana segun como resolvamos
	public void observarAvionAterrizo(Observer unObservador){
		
	}
	
	//crear clase nueva Observador ya que Observer y Observable no nos sirven porque son clases concretas y no interfaz y 
	//no java no permite herencia multiple de clases concretas
	
	private void agregarObservador(Observer unObservador){
		listaDeObservadores.add(unObservador);
	}
	
}
