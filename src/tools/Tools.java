package tools;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import items.Card;
import items.Deck;

public abstract class Tools {
	
	public static List<Card> createCards() throws Exception {
		List<Card> cardList = new ArrayList<>();
				
		cardList.add(new Card("Espada", 1, 1));
		cardList.add(new Card("Basto", 1, 2));
		cardList.add(new Card("Espada", 7, 3));
		cardList.add(new Card("Oro", 7, 4));
		cardList.add(new Card("Basto", 3, 5));
		cardList.add(new Card("Oro", 3, 5));
		cardList.add(new Card("Espada", 3, 5));
		cardList.add(new Card("Copa", 3, 5));
		cardList.add(new Card("Basto", 2, 6));
		cardList.add(new Card("Oro", 2, 6));
		cardList.add(new Card("Espada", 2, 6));
		cardList.add(new Card("Copa", 2, 6));
		cardList.add(new Card("Copa", 1, 7));
		cardList.add(new Card("Oro", 1, 7));
		cardList.add(new Card("Copa", 12, 8));
		cardList.add(new Card("Oro", 12, 8));
		cardList.add(new Card("Basto", 12, 8));
		cardList.add(new Card("Espada", 12, 8));
		cardList.add(new Card("Copa", 11, 9));
		cardList.add(new Card("Oro", 11, 9));
		cardList.add(new Card("Basto", 11, 9));
		cardList.add(new Card("Espada", 11, 9));
		cardList.add(new Card("Copa", 10, 10));
		cardList.add(new Card("Oro", 10, 10));
		cardList.add(new Card("Basto", 10, 10));
		cardList.add(new Card("Espada", 10, 10));
		cardList.add(new Card("Basto", 7, 11));
		cardList.add(new Card("Copa", 7, 11));
		cardList.add(new Card("Copa", 6, 12));
		cardList.add(new Card("Oro", 6, 12));
		cardList.add(new Card("Basto", 6, 12));
		cardList.add(new Card("Espada", 6, 12));
		cardList.add(new Card("Copa", 5, 13));
		cardList.add(new Card("Oro", 5, 13));
		cardList.add(new Card("Basto", 5, 13));
		cardList.add(new Card("Espada", 5, 13));
		cardList.add(new Card("Copa", 4, 14));
		cardList.add(new Card("Oro", 4, 14));
		cardList.add(new Card("Basto", 4, 14));
		cardList.add(new Card("Espada", 4, 14));
		return cardList;
	}
	
	public static List<Card>[] drawCards(Deck deck){
		Random r = new Random();
		int cardIndex = 0;
		int deckSize = deck.getSize();
		@SuppressWarnings("unchecked")
		List<Card>[] hands = new ArrayList[2];
		
		hands[0] = new ArrayList<Card>();
		hands[1] = new ArrayList<Card>();
		for(int i=0; i<6;i++) {
			if(i<3) {
				cardIndex = r.nextInt(deckSize--);
				hands[0].add(deck.getCards().get(cardIndex));
				deck.getCards().remove(cardIndex);
			} else {
				cardIndex = r.nextInt(deckSize--);
				hands[1].add(deck.getCards().get(cardIndex));
				deck.getCards().remove(cardIndex);
			}
		}
		return hands;
	}
	
	public static boolean isNumeric(String obj) {
		try {
			Double.parseDouble(obj);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static void clearScreen(){  
		System.out.println(new String(new char[100]).replace("\0", "\r\n"));
	}  
}
