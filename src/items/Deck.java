package items;

import java.util.ArrayList;
import java.util.List;

public class Deck {

	private List<Card> cards = new ArrayList<Card>();

	public List<Card> getCards() {
		return cards;
	}

	public Deck(List<Card> cards) {
		this.cards = cards;
	}
	
	public int getSize() {
		return this.cards.size();
	}
	
	
}
