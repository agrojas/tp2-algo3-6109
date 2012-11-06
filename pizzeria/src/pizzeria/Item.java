package pizzeria;

import java.util.ArrayList;
import java.util.List;

public class Item {

	private String nombre;
	private List adicionales;
	private float precio;

	public Item(String nombre) {
		this.nombre = nombre;
		this.adicionales = new ArrayList();
	}

	public String getNombre() {
		return this.nombre;
	}

	public List getAdicionales() {
		return this.adicionales;
	}

	public void agregarAdicional(Adicional adicional) {
		this.adicionales.add(adicional);
	}

	public void setPrecio(float precio) {
		this.precio = precio;
		
	}

	public float getPrecio() {
		return this.precio;
	}

}
