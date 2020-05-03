public class Pokemon {
    protected String name;
    public final double maxHp;
    protected double hp;
    protected int level,  relationship;

    public Pokemon(String name, double maxHp,int level, int relationship){
        this.name = name;
        this.hp = maxHp;
        this.maxHp = maxHp;
        this.level = level;
        this.relationship = relationship;
    }
    
    public double getLevel(){
    	return this.level;
    }

    public double getHealth(){
		return this.hp;
    }
    
    public double getMaxHealth(){
		return this.maxHp;
    }
    
    public String getName(){
		return this.name;
    }
    
    public double getRelationship(){
		return this.relationship;
    }
    
    public void battle(){
        this.level +=1;
        this.hp -= 10;
        this.relationship +=20;
        if(this.hp < 0)
            this.hp = 0;  
    }

    public void eat(Berry berry){
		this.relationship += berry.getRestoreValue();
		//if(this.hp > this.maxHp)
		//	this.hp = this.maxHp;
    }
    
    public void goodRelationship() {
		this.relationship += 10;
	}
	
	public void badRelationship( ) {
		this.relationship -= 5 ;
		if(this.relationship < 0)
			relationship = 0;
	}

    /*public void levelUp(){
        this.level = level+1;
        this.getLevel();
    }*/
}