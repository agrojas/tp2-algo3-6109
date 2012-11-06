package pizzeria;

public abstract class Adicional {

	private Item item;
	private float precio;

	public Adicional(Item item) {
		this.validarCombinacion(item);
		this.item = item;
		this.item.agregarAdicional(this);
	}

	protected abstract void validarCombinacion(Item item);
	
	public Object getItem() {
		return this.item;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
		
	}

	public float getPrecio() {
		return this.precio;
	}
}
