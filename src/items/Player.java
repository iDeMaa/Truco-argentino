package items;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	private String nombre;
	private List<Card> hand = new ArrayList<>();
	private List<Card> board = new ArrayList<>();
	
	public List<Card> getBoard() {
		return board;
	}

	public void setBoard(List<Card> board) {
		this.board = board;
	}

	public List<Card> getHand() {
		return hand;
	}

	public void setHand(List<Card> hand) {
		this.hand = hand;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Player(String nombre) {
		this.nombre = nombre;
	}
	
	public Card dropCard(int cardIndex) {
		Card card = this.getHand().get(cardIndex);
		this.getHand().remove(cardIndex);
		this.board.add(card);
		return card;
	}

	public void showCards() throws InterruptedException {
		System.out.println("Elegí que carta tirar:\n");
		int i = 1;
		for(Card card : getHand()) {
			System.out.println("\t" + i++ + ". " + card.toString() + "\n");
		}
		System.out.println("\tE. Envido\n\n\tT. Truco\n\n\tM. Irse al mazo");
		System.out.println(">>> ");
	}
	
	public int calculateEnvido() {
		if(hand.get(0).getPalo() != hand.get(1).getPalo()
				&& hand.get(0).getPalo() != hand.get(2).getPalo()
				&& hand.get(1).getPalo() != hand.get(2).getPalo()) {
			int max = 0;
			for(Card card : hand) {
				if(card.obtenerValorEnvido() > max) {
					max = card.obtenerValorEnvido();
				}
			}
			return max;
		} else if(hand.get(0).getPalo() == hand.get(1).getPalo()
				&& hand.get(0).getPalo() == hand.get(2).getPalo()
				&& hand.get(1).getPalo() == hand.get(2).getPalo()){
			return Integer.MAX_VALUE;
		} else {
			int envido=0;
			if(hand.get(0).getPalo() == hand.get(1).getPalo()) {
				envido = hand.get(0).obtenerValorEnvido() + hand.get(1).obtenerValorEnvido();
			} else if(hand.get(0).getPalo() == hand.get(2).getPalo()) {
				envido = hand.get(0).obtenerValorEnvido() + hand.get(2).obtenerValorEnvido();
			} else if(hand.get(1).getPalo() == hand.get(2).getPalo()) {
				envido = hand.get(1).obtenerValorEnvido() + hand.get(2).obtenerValorEnvido();
			}
			return envido + 20;
		}
	}
}
