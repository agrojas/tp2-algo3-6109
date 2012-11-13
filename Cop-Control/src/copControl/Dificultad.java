package copControl;

public class Dificultad {
	
	private int cantidadDeAvionesPorAterrizar;
	private int frecuenciaDeAparicion; 
	private int velocidad;
	private int valorDeDificultad;

	public Dificultad(int cantidadDeAvionesPorAterrizar, int frecuenciaDeAparicion, int velocidad) {
		this.cantidadDeAvionesPorAterrizar=cantidadDeAvionesPorAterrizar;
		this.frecuenciaDeAparicion=frecuenciaDeAparicion;
		this.velocidad=velocidad;
		this.valorDeDificultad=(this.cantidadDeAvionesPorAterrizar+this.frecuenciaDeAparicion+this.velocidad);
		
	}
	
	public int getCantidadDeAvionesPorAterrizar(){
		return this.cantidadDeAvionesPorAterrizar;
	}
	
	public int getfrecuenciaDeAparicion(){
		return this.frecuenciaDeAparicion;
	}
	
	public int getVelocidad(){
		return this.velocidad;
	}
	
	public int getValorDeDificultad(){
		return this.valorDeDificultad;
	}

}
