package pizzeria;

import java.util.List;

import junit.framework.TestCase;

public class AdicionalTest extends TestCase {

	public void testConstructorDeberiaSetearElItem(){
		
		Item item = new Item("Pizza de muzzarela");
		Adicional aceituna = new Aceituna(item);
		
		assertEquals(item, aceituna.getItem());
	}
	
	public void testConstructorDeberiaAgregarElAdicionaAlItem(){
		
		Item item = new Item("Pizza de muzzarela");
		Adicional aceituna = new Aceituna(item);
		
		List adicionalesDelItem = item.getAdicionales();
		
		assertTrue(adicionalesDelItem.contains(aceituna));
	}
}
