package items;

public class Card {

	private String palo;
	private int value;
	private int winOrder;
	
	public String getPalo() {
		return palo;
	}
	
	public int getValue() {
		return value;
	}
	
	public int getWinOrder() {
		return winOrder;
	}
	
	public void setWinOrder(int winOrder) {
		this.winOrder = winOrder;
	}
	
	public Card(String name, int value) {
		this.palo = name;
		this.value = value;
	}
	
	public Card(String name, int value, int winOrder) {
		this.palo = name;
		this.value = value;
		this.winOrder = winOrder;
	}
	
	public String toString() {
		return (value + " de " + palo);
	}
	
	public int obtenerValorEnvido() {
		if(value == 12 || value == 11 || value == 10) {
			return 0;
		} else {
			return value;
		}
	}
	
}
