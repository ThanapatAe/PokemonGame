import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class GUI extends JFrame{
    private JLabel Pokemon, selectItem, selectPokemon, backgoundLabel, pokemonIcon;
    private JPanel panel;
    private JTextArea statusArea;
    private Icon backgound, pichuIcon, pikachuIcon, pichuLazy, koikingIcon, gyaradosIcon, start;
    private JComboBox itemBox;
    private JRadioButton pichu,pikachu,raichu,koiking;
    private String itemNames[];
    private JButton useItemButton, battleButton;
    private Command command;

    int pichuMember, pikachuMember, raichuMember, koikingMember, gyaradosMember;


    public GUI(){
    super("PokemonGUI");
    Container c = getContentPane();
    c.setBounds(100, 100, 850, 550);

    itemNames = new String[]{
        "Blue Berry",
        "Red Berry"
    };

    command = new Command();
    command.pokemons.add(new Pichu());
    command.pokemons.add(new Pikachu());
    command.pokemons.add(new Raichu());
    

    panel = new JPanel();
    panel.setLayout(null);

    //Create components and set position
    Pokemon = new JLabel("Pokemon");
    Pokemon.setFont(new Font("Tahoma", Font.PLAIN, 18));
    Pokemon.setBounds(380, 10, 73, 22);
    selectItem = new JLabel("Select Item");
    selectItem.setFont(new Font("Tahoma", Font.PLAIN, 12));
    selectItem.setBounds(680, 40, 65, 29);
    selectPokemon = new JLabel("Select Pokemons");
    selectPokemon.setFont(new Font("Tahoma", Font.PLAIN, 12));
    selectPokemon.setBounds(66, 47, 98, 14);

    statusArea = new JTextArea("",425,227);
    statusArea.setBounds(202, 249, 425, 227);

    useItemButton = new JButton("Use Item");
    useItemButton.setBounds(668, 108, 89, 23);
    battleButton =  new JButton("Battle");
    battleButton.setBounds(668, 146, 89, 23);
    
    itemBox = new JComboBox<Object>(itemNames);
    itemBox.setBounds(619, 71, 183, 20);

    pichu = new JRadioButton("Pichu");
    pichu.setBounds(80, 70, 109, 23);
    koiking = new JRadioButton("Koiking");
    koiking.setBounds(80, 96, 109, 23);

    ButtonGroup group = new ButtonGroup();
    group.add(pichu);
    group.add(koiking);
    group.add(raichu);


    //Create Icon
    start = new ImageIcon(getClass().getResource("StartGame.png"));
    backgound = new ImageIcon(getClass().getResource("Backgound1.png"));
    pichuIcon = new ImageIcon(getClass().getResource("Pichu.png"));
    pikachuIcon = new ImageIcon(getClass().getResource("Pikachu.png"));
    koikingIcon = new ImageIcon(getClass().getResource("Koiking.png"));
    gyaradosIcon = new ImageIcon(getClass().getResource("Gyarados.png"));

    pichuLazy = new ImageIcon(getClass().getResource("Pichulazy.png"));
    pokemonIcon = new JLabel("");

    backgoundLabel = new JLabel("");
    pokemonIcon.setIcon(start);
    pokemonIcon.setBounds(274, 43, 280, 188);
    backgoundLabel.setIcon(backgound);
    backgoundLabel.setBounds(0, 0, 1024, 576);

    useItemButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent event){
            if(pichu.isSelected()){
                if((command.getRelationship(pichuMember) >= 500) && (command.getLevel(pichuMember) >= 20)) {
                    pichuMember = pikachuMember;
                    pokemonIcon.setIcon(pikachuIcon);
                }
                else {
                    pokemonIcon.setIcon(pichuIcon);
                }
                command.pokemons.get(pichuMember);
                switch (itemBox.getSelectedIndex()) {
                    case 0 :
     
                        command.eatBlueBerry(pichuMember);
                        break;
                    case 1 :
                        command.eatRedBerry(pichuMember);
                        break;
                
                }
                statusArea.setText(command.showStatus(command.pokemons,pichuMember));
            }

            else if(koiking.isSelected()){
                if((command.getRelationship(koikingMember) >= 500) && (command.getLevel(koikingMember) >= 20)) {
                    koikingMember = gyaradosMember;
                    pokemonIcon.setIcon(gyaradosIcon);
                }
                else {
                    pokemonIcon.setIcon(koikingIcon);
                }
                command.pokemons.get(koikingMember);
                switch (itemBox.getSelectedIndex()) {
                    case 0 :
     
                        command.eatBlueBerry(koikingMember);
                        break;
                    case 1 :
                        command.eatRedBerry(koikingMember);
                        break;
                
                }
                statusArea.setText(command.showStatus(command.pokemons,koikingMember));
            }
        }
    });
    

    //Exercise battle listener
    battleButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent event) {
            if(pichu.isSelected()){
                if((command.getRelationship(pichuMember) >= 200) && (command.getLevel(pichuMember) >= 20)) {
                    pichuMember = pikachuMember;
                    pokemonIcon.setIcon(pikachuIcon);
                }
                else {
                    pokemonIcon.setIcon(pichuIcon);
                }
                command.pokemons.get(pichuMember);
                command.battle(pichuMember);
                command.badRelationship(pichuMember);
                statusArea.setText(command.showStatus(command.pokemons,pichuMember));
            }

            else if(koiking.isSelected()){
                if((command.getRelationship(koikingMember) >= 200) && (command.getLevel(koikingMember) >= 20)) {
                    koikingMember = gyaradosMember;
                    pokemonIcon.setIcon(gyaradosIcon);
                }
                else {
                    pokemonIcon.setIcon(koikingIcon);
                }
                command.pokemons.get(koikingMember);
                command.battle(koikingMember);
                command.badRelationship(koikingMember);
                statusArea.setText(command.showStatus(command.pokemons,koikingMember));
            }
            else if( (command.getLevel(pichuMember) < 20) || (command.getRelationship(pichuMember) <= 200)){
                pokemonIcon.setIcon(pichuIcon);
                command.pokemons.get(pichuMember);
                command.battle(pichuMember);
                command.badRelationship(pichuMember);
                statusArea.setText(command.showStatus(command.pokemons,pichuMember));
            }

            else if( (command.getLevel(koikingMember) < 20) || (command.getRelationship(koikingMember) <= 200)){
                pokemonIcon.setIcon(koikingIcon);
                command.pokemons.get(koikingMember);
                command.battle(koikingMember);
                command.badRelationship(koikingMember);
                statusArea.setText(command.showStatus(command.pokemons,koikingMember));
            }
        }
    });

    //JRidoButton action listener
    pichu.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent event) {
            if((command.getRelationship(pichuMember) >= 500)) {
                pichuMember = pikachuMember;
                pokemonIcon.setIcon(pikachuIcon);
            }
            else {
                pokemonIcon.setIcon(pichuIcon);
            }
            pichuMember = 0;
            statusArea.setText(command.showStatus(command.pokemons,pichuMember));
            
        }
    });

    pichu.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent event) {
            if((command.getRelationship(koikingMember) >= 500)) {
                koikingMember = pikachuMember;
                pokemonIcon.setIcon(gyaradosIcon);
            }
            else {
                pokemonIcon.setIcon(koikingIcon);
            }
            koikingMember = 0;
            statusArea.setText(command.showStatus(command.pokemons,koikingMember));
            
        }
    });
    

    
    pikachuMember = 4;
    gyaradosMember = 5;

    //Set layout
    panel.add(Pokemon);
    panel.add(pokemonIcon);
    panel.add(selectPokemon);
    panel.add(statusArea);
    panel.add(useItemButton);
    panel.add(battleButton);
    panel.add(selectItem);
    panel.add(itemBox);
    panel.add(pichu);
	panel.add(koiking);

    panel.add(backgoundLabel);
    c.add(panel);
            
    //Set others
    
    setLocationRelativeTo(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(850, 550);
    setVisible(true);
    }

    
}