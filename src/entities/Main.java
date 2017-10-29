package entities;

import java.util.Random;

public class Main {
	public static void main (String arg[])
	{
		Player p1= new Player("P1");
		Player p2= new Player("P2");	
		
		SetGame s = new SetGame(p1, p2);
		s.runSet();
		
	}
}
