package entities;

import java.io.*;
import javax.xml.bind.annotation.*;


public class Player implements Serializable{
	// Variables
	private String name;
	private int score;
	
	// Constructors
	public Player(String name) {
		super();
		this.name = name;
		this.score = 0;
	}
	public Player() {
		super();
	}
	
	// Getters

	public String getName() {
		return this.name;
	}
	

	public int getScore() {
		return this.score;
	}
	
	// Setters
	public void setScore() {
		if(this.score == 0) this.score = 15;
		else if(this.score == 15) this.score = 30;
		else if(this.score == 30) this.score = 40;
		else this.score = 50;
	}
	public void setScore(int _score) {
		this.score = _score;
	}
	
	// Methods
	public void print() {
		if(this.score>40)
			System.out.println(this.name +" : Win Game");
		else
			System.out.println(this.name +" : "+ this.score);
	}
	
}
