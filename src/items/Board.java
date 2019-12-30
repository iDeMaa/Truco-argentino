package items;

import java.io.IOException;
import java.util.Scanner;
import tools.Tools;

public class Board {

	private Player player1;
	private Player player2;
	private Scanner s=null;
	private boolean nextPlayer1;
	private int score1 = 0;
	private int score2 = 0;
	int turn = 0;
	private boolean envidoYaCantado=false;

	//private List<Card> p1Board = new ArrayList<>();
	//private List<Card> p2Board = new ArrayList<>();

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	/*public List<Card> getP1Board() {
		return p1Board;
	}

	public void setP1Board(List<Card> p1Board) {
		this.p1Board = p1Board;
	}

	public List<Card> getP2Board() {
		return p2Board;
	}

	public void setP2Board(List<Card> p2Board) {
		this.p2Board = p2Board;
	}*/

	public Board(Player p1, Player p2) {
		this.player1 = p1;
		this.player2 = p2;
	}

	public String toString() {
		String out = "";
		out += player1.getNombre() + ":\n\t";
		for (int i = 0; i < player1.getBoard().size(); i++) {
			out += (i + 1) + ". " + player1.getBoard().get(i).toString() + "\n";
		}
		out += "\n" + player2.getNombre() + ":\n\t";
		for (int i = 0; i < player2.getBoard().size(); i++) {
			out += (i + 1) + ". " + player2.getBoard().get(i).toString() + "\n";
		}
		return out;
	}

	public boolean selectWinner(boolean nextPlayer1) {
		if (nextPlayer1) {
			if (player1.getBoard().get(player1.getBoard().size() - 1).getWinOrder() < player2.getBoard().get(player2.getBoard().size() - 1).getWinOrder()) {
				return nextPlayer1;
			} else {
				return !nextPlayer1;
			}
		} else {
			if (player2.getBoard().get(player2.getBoard().size() - 1).getWinOrder() < player1.getBoard().get(player1.getBoard().size() - 1).getWinOrder()) {
				return nextPlayer1;
			} else {
				return !nextPlayer1;
			}
		}
	}

	public void start() {
		
		System.out.println("¿Quién empieza?: ");
		try {
			s = new Scanner(System.in);
			String sNextPlayer = s.nextLine();
			if (player1.getNombre().equalsIgnoreCase(sNextPlayer)) {
				nextPlayer1 = true;
			} else if (player2.getNombre().equalsIgnoreCase(sNextPlayer)) {
				nextPlayer1 = false;
			} else {
				System.out.println("Nombre incorrecto");
				return;
			}
			Tools.clearScreen();
			
			while (true) {

				if (score1 == 2) {
					Tools.clearScreen();
					System.out.println("Ganó " + player1.getNombre() + "!!!");
					return;
				} else if (score2 == 2) {
					Tools.clearScreen();
					System.out.println("Ganó " + player2.getNombre() + "!!!");
					return;
				}
				if (nextPlayer1) {
					play(player1,player2);
				} else {
					play(player2,player1);
				}
				
			}
		} catch (InterruptedException | IOException e) {
			System.out.println("Hubo un error:\n\n");
			e.printStackTrace();
		} finally {
			s.close();
		}
	}
	
	public void play(Player actualPlayer, Player otherPlayer) throws InterruptedException, IOException {
		int card = -1;
		String option;
		System.out.println(actualPlayer.getNombre() + " tu turno. ¡" + otherPlayer.getNombre().toUpperCase() + " NO MIRES!\n");
		Thread.sleep(2000);
		actualPlayer.showCards();
		option = s.nextLine();
		if (Tools.isNumeric(option)) {
			card = Integer.parseInt(option);
			actualPlayer.dropCard(card - 1);
			Tools.clearScreen();
			System.out.println(toString());
			if (turn % 2 != 0) {
				nextPlayer1 = selectWinner(nextPlayer1);
				if (nextPlayer1) {
					score1++;
				} else {
					score2++;
				}
			} else {
				nextPlayer1 = !nextPlayer1;
			}
			turn++;
		} else {
			switch (option.toUpperCase()) {
			case "E":
				if(envidoYaCantado) {
					System.out.println("Ya se cantó el envido");
					return;
				} else {
					envidoYaCantado = true;
				}
				if(actualPlayer.calculateEnvido() == Integer.MAX_VALUE) {
					System.out.println("¡" + actualPlayer.getNombre() +  " tiene flor!");
				} else if(actualPlayer.calculateEnvido() > otherPlayer.calculateEnvido()) {
					System.out.println("Envido ganado por " + actualPlayer.getNombre() + ": " + actualPlayer.calculateEnvido() + " contra " + otherPlayer.calculateEnvido());
				} else {
					System.out.println("Envido ganado por " + otherPlayer.getNombre() + ": " + otherPlayer.calculateEnvido() + " contra " + actualPlayer.calculateEnvido());
				}
				
				break;
			case "T":
				break;
			case "M":
				score2 = 2;
				break;
			default:
				System.out.println("Opción incorrecta");
				break;
			}
		}
	}
}
