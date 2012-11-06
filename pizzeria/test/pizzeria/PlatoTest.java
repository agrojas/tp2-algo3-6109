package pizzeria;

import junit.framework.TestCase;

public class PlatoTest extends TestCase {
	
	public void testCalcularPrecioCuandoItemSinAdicionalDeberiaSerIgualAlPrecioItem(){
		// arrange
		Item item = new Item("Pizza");
		item.setPrecio(1);
		Plato plato = new Plato(item);
		
		// act
		float precio = plato.calcularPrecio();
		
		// assert
		assertEquals(precio, item.getPrecio());
	}

	public void testCalcularPrecioCuandoItemConAdicionalDeberiaSerIgualAlPrecioItemMasAdicional(){
		// arrange
		Item item = new Item("Pizza");
		item.setPrecio(1);
		
		Adicional aceituna = new Aceituna(item);
		aceituna.setPrecio(1);
		
		Plato plato = new Plato(item);
		
		// act
		float precio = plato.calcularPrecio();
		
		// assert
		assertEquals(precio, item.getPrecio() + aceituna.getPrecio());
	}

}
