import java.io.*;
import java.util.Scanner;

public  class Pokemon {
    public String name;
    public int maxHp;
    public int currHp;
    public int maxPp;
    public int currPp;
    public int level;
    public int exp;
    public int maxExp;

    public Pokemon(){
        this.exp = 0;
        this.maxExp = 65;
        this.maxHp = 25;
        this.level = 1;
        this.currHp = 25;
    }

    public int currentLevel(){
        level = level;
        return level;
    }

    public int levelUp(){
        level = level+1;
        this.currentLevel();
        return level;
    }

    public int killPokemon(){
        exp = exp+30;
        this.hpDown();
         if(exp >= maxExp){
            this.levelUp();   
        }
        exp = exp % maxExp;
        return level;
    }

    public int currentExp(){
        exp = exp;
        return exp;
    }

    public int hpUp(){
        if(currHp < maxHp){
            currHp = currHp+10;
        }
        this.currentHp();
        return currHp;
    }

    public int hpDown(){
        if(currHp <= 0){
            currHp = 0;
            System.out.println("YOUR POKEMON DIE!!");
        }

        else if(currHp > 0){
            currHp = currHp-10;

        }

        this.currentHp();

        return currHp;
    }

    public int usePotion(){
        if(currHp < maxHp){
            this.hpUp();
        }
        else if(currHp >= maxHp){
            System.out.println("HP FULL!!");
        }
        return currHp;

    }

    public int currentHp(){
        currHp = currHp;
        return currHp;
    }
    
}