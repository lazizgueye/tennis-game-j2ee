package ws;

import entities.*;
import java.util.*;
import javax.ws.rs.*;

import javax.ws.rs.core.MediaType;


@Path("setgame")
public class SetGameRestful {
	
	@GET
	@Path("findall")
	@Produces(MediaType.APPLICATION_JSON)
	public List<SetGame> findAll(){
		List<SetGame> result = new ArrayList<SetGame>();
		Player p1= new Player("P1");
		Player p2= new Player("P2");		
		result.add(new SetGame(p1, p2));
		return result;		
	}
}
