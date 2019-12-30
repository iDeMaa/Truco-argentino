package main;

import java.util.List;

import items.Deck;
import items.Player;
import items.Card;
import items.Board;
import tools.Tools;

public class Main {

	public static void main(String[] args) {
		try {
			Deck deck = new Deck(Tools.createCards());

			// System.out.print("Ingrese el nombre del primer jugador: ");
			// Player player1 = new Player(s.nextLine());
			Player player1 = new Player("Facundo");
			// System.out.print("\nIngrese el nombre del segundo jugador: ");
			// Player player2 = new Player(s.nextLine());
			Player player2 = new Player("Tamara");

			List<Card>[] hands = Tools.drawCards(deck);
			player1.setHand(hands[0]);
			player2.setHand(hands[1]);
			Board board = new Board(player1, player2);
			board.start();
		} catch (Exception e) {
			System.out.println("Hubo un error:\n");
			e.printStackTrace();
		}
	}

}
