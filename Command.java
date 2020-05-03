import java.util.ArrayList;

public class Command {
	ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();

	public String showStatus(ArrayList<Pokemon> pokemons,int member){
        String name = "############################ Status ########################### \n"+"Name: "+ pokemons.get(member).getName();
        String hp = "\nHealth: "+pokemons.get(member).getHealth() + "/" + pokemons.get(member).getMaxHealth();
        String level = "\nLevel: " + pokemons.get(member).getLevel() + " ";  
        String relationship = "\nRelationship: " + pokemons.get(member).getRelationship() + " points";
        return name+hp+level+relationship;
    }
	
	public void eatBlueBerry(int member){
        Berry berry = new Berry(0);
        pokemons.get(member).eat(berry);
	}
	
	public void eatRedBerry(int member){
        Berry berry = new Berry(1);
        pokemons.get(member).eat(berry);
	}
	
	public void eatYellowBerry(int member){
        Berry berry = new Berry(2);
        pokemons.get(member).eat(berry);
	}
	
	public void battle(int member) {
		pokemons.get(member).battle();
	}
	
	
	public double getRelationship(int member) {
		return pokemons.get(member).getRelationship();
	}
	
	public void goodRelationship(int member) {
		pokemons.get(member).goodRelationship();
	}
	
	public void badRelationship(int member) {
		pokemons.get(member).badRelationship();
	}
	
    
    public double getLevel (int member) {
		return pokemons.get(member).getLevel();
    }
	
}