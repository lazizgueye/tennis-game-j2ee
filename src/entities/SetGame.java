package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.*;
import javax.xml.bind.annotation.*;


@XmlRootElement(name = "setgame")
public class SetGame implements Serializable{
	
	// Variables
	public static int INIT_NUMBER = 99;
	
	ArrayList<Player> Players = new ArrayList<Player>();
	ArrayList<Game> Games = new ArrayList<Game>();
	ArrayList<String> historic_set_scoreP1 = new ArrayList<String>();
	ArrayList<String> historic_set_scoreP2 = new ArrayList<String>();
	ArrayList<String> historic_game_score = new ArrayList<String>();
	
	private Boolean over = false;
	private int winner = INIT_NUMBER;
	private int game_number = 0;
	private Boolean tie_break = false;
	
	private int score_set_player1 = 0;
	private int score_set_player2 = 0;
	
	// Constructors
	/**
     * New set.
     *
     * @param player1  the first player
     * @param player2 the second player
     * @return a new set;
     */
	public SetGame(Player player1, Player player2) {
		super();
		Game game1 = new Game(player1, player2);
		this.Games.add(game1);
		this.Players.add(player1);
		this.Players.add(player2);
		runSet();		
	}
	public SetGame() {
		super();
	}
	
	// Getters && Setters
	@XmlElement(name = "score1")
	public int getScore_set_playe1() {
		return this.score_set_player1;
	}
	
	@XmlElement(name = "historic_score1")
	public ArrayList<String> getHistoric_set_scoreP1() {
		return this.historic_set_scoreP1;
	}
	@XmlElement(name = "score2")
	public int getScore_set_playe2() {
		return this.score_set_player2;
	}
	@XmlElement(name = "historic_score2")
	public  ArrayList<String> getHistoric_set_scoreP2() {
		return this.historic_set_scoreP2;
	}	
	@XmlElement(name = "historic_game_score")
	public ArrayList<String> getHistoric_game_score() {
		return this.historic_game_score;
	}	
	@XmlElement(name = "winner")
	public int getWinner() {
		if(this.getScore_set_playe1()<this.getScore_set_playe2())
			return 1;
		return 0;
	}
	
	public Boolean matchOver() {
		return this.over;
	}		
	
	
	// Methods
	public void runSet() {
		while(!matchOver()) {			
			this.Games.get(game_number).playGame();
			
			incrementScorePlayer(game_number);			
			
			/* game winner, tie_break rule */
			if((this.score_set_player1 == 6 && this.score_set_player2 <=4)|| (this.score_set_player2 == 6 && this.score_set_player1 <= 4)) {
				this.over = true;
			}
			if((this.score_set_player1 == 7 || this.score_set_player2 == 7) && !this.tie_break) {
				this.over = true;
			}
			else if(this.score_set_player1 == 6 && this.score_set_player2 == 6) {
				this.tie_break = true;
			}
			else if((((this.score_set_player1 - this.score_set_player2)>=2 && this.score_set_player1>=6)|| 
					((this.score_set_player2 - this.score_set_player1)>=2 && this.score_set_player2>=6)) && this.tie_break) {
				this.over = true;
			}			
			else {
				game_number++;
				Game newGame = new Game(this.Players.get(0), this.Players.get(1));
				this.Games.add(newGame);
			}
		}
		printScore();
		printHistoricSet();
	}
	
	public void incrementScorePlayer(int gameNumber) {
		if(this.Games.get(gameNumber).getWinner()==0)
			this.score_set_player1++;
		else
			this.score_set_player2++;
		
		this.historic_game_score.add(this.Games.get(game_number).resultGame());
		addHistorical(score_set_player1+"", score_set_player2+"");
	}
			
	public void addHistorical(String score1, String score2) {
		this.historic_set_scoreP1.add(score1);
		this.historic_set_scoreP2.add(score2);
	}
	
	
	// Print resultat
	public void printScore() {
		System.out.println("the set result");
		System.out.println("P1 : " + this.getScore_set_playe1());
		System.out.println("P2 : " + this.getScore_set_playe2());
	}
	
	public void printHistoricSet() {
		System.out.print("P1 | ");
		for(int i=0; i<this.historic_set_scoreP1.size(); i++) {
			System.out.print(this.historic_set_scoreP1.get(i)+"\t|");
		}
		System.out.println("");
		System.out.print("P2 | ");
		for(int i=0; i<this.historic_set_scoreP2.size(); i++) {
			System.out.print(this.historic_set_scoreP2.get(i)+"\t|");
		}
		System.out.println("");
		System.out.println("");
	}
	
	
}
