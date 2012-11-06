package pizzeria;

import java.util.Iterator;

public class Plato {
	
	private Item item;

	public Plato(Item item){
		this.item = item;
	}

	public float calcularPrecio() {
		float precio = this.item.getPrecio();
		Iterator it = this.item.getAdicionales().iterator();
		while (it.hasNext()) {
			 Adicional adicional = (Adicional)it.next();
			 precio += adicional.getPrecio();
		}
		return precio;
	}
}
