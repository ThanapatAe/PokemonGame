import java.io.*;
import java.util.Scanner;

public  class PokemonGame {
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        int select ;
        Pokemon pokemon = new Pokemon();

        

        do {
            System.out.println("Plese Enter Number For Pokemon Do");
            System.out.println("1 For Kill Pokemon");
            System.out.println("2 For Eat Potion");
            //System.out.println("3 For Eat poison");
            System.out.println("0 For End");

            System.out.print("Enter number : ");
            select = Sc.nextInt();

            if(select == 1){
                System.out.println("Your level is "+pokemon.killPokemon());
                System.out.println("Your EXP is "+pokemon.currentExp());
                System.out.println("Your HP is "+pokemon.currentHp());
            }
            else if (select == 2){
                System.out.println("Your Hp is "+pokemon.usePotion());
            }
            /*else if (number == 3){
                System.out.println("Your Hp is "+novice.eatPoison());
            }*/

        }while (select != 0);
    }
}