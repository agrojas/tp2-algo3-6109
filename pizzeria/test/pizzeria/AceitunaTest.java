package pizzeria;

import junit.framework.TestCase;

public class AceitunaTest extends TestCase {

	public void testConstructorDeberiaLanzarExceptionAlCombinarConCerveza() {
		
		Item item = new Item("Cerveza");
		
		try{
			Aceituna aceituna = new Aceituna(item);
			fail();
		}
		catch(CombinacionNoValidaException e){
			
		}
		catch(Exception ex){
			fail();
		}
		
		
		
	}

}
