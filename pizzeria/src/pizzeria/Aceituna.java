package pizzeria;

public class Aceituna extends Adicional {


	public Aceituna(Item item) {
		super(item);
	}

	protected void validarCombinacion(Item item) {
		if (!item.getNombre().contains("Pizza")) {
			throw new CombinacionNoValidaException();
		}
	}

}
