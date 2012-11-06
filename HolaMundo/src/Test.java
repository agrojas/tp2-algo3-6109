import junit.framework.TestCase;


public class Test extends TestCase {

	public void testDecirHola() {
		ElQueDiceHola s= new ElQueDiceHola();
		Boolean a=s.decirHola()=="hola";
		assertEquals(s.decirHola(),"hola");
	}

}
