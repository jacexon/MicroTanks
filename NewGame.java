import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Klasa <code>NewGame</code> odpowiedzialna jest za stworzenie ramki
 * opcji nowej gry. Klasa dziedziczy po klasie abstrakcyjnej
 * <code>Frame</code>.
 *
 * @author      Bartłomiej Bielecki <address @ example.com>
 * @author      Jacek Polak <polakjacek@gmail.com>
 * @version     1.1
 * @since       2016-03-26
 */


public class NewGame extends Frame {

    private Font janusz = new Font("Serif", Font.BOLD, 20);
    private GameFrame gameFrame = new GameFrame();

    /**
     *  Konstruktor klasy <code>NewGame</code> inicjalizuje  ramki w zależności od
     * rozmiaru ekranu urządzenia wykonującego
     * program.
     */
    public NewGame() {
        this.width=width/2;
        this.height=height*3/4;
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
    }

    /**
     * Metoda służąca do utworzenia ramki nowej gry, są w niej wszystkie opcje potrzebne do
     * uruchomienia rozgrywki, a także przyciski powrotu do menu głównego.
     *
     * @param newGameFrame Ramka, która zostanie przekazana z MainMenu
     * @param mainMenuFrame Ramka menu głównego, do której powrócimy klikając przycisk
     *
     * @return Brak
     */
    public void createNewGameFrame(JFrame newGameFrame, JFrame mainMenuFrame){

        int buttonHeight = height/8;
        int buttonWidth = width/4;
        JButton startGameButton = createAButton(width, height, 5, "START GAME");
        JButton pauseButton = createAButton(width, height, 5, "EXIT");
        JFrame gFrame = gameFrame.createAFrame(gameFrame.getWidth(), gameFrame.getHeight(), "Micro Tanks");

        newGameFrame.setResizable(false);
        newGameFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        JTextField p1 = new JTextField("Podaj prosze imie gracza 1");
        JTextField p2 = new JTextField("Podaj prosze imie gracza 2");
        p1.setEditable(false);
        p2.setEditable(false);
        p1.setBounds(width/10, height / 10 +(0*buttonHeight+0*20),2*buttonWidth,buttonHeight/2);
        p2.setBounds(width /10, height / 10 +(1*buttonHeight+1*20),2*buttonWidth,buttonHeight/2);
        p1.setVisible(true);
        p2.setVisible(true);
        p1.setFont(janusz);
        p2.setFont(janusz);
        p1.setBorder(BorderFactory.createEmptyBorder());
        p2.setBorder(BorderFactory.createEmptyBorder());
        newGameFrame.add(p2);
        newGameFrame.add(p1);

        JTextField player1 = new JTextField("     player 1");
        JTextField player2 = new JTextField("     player 2");
        player1.setBounds(width / 10 +buttonWidth*4/2, height / 10 +(0*buttonHeight+0*20),buttonWidth,buttonHeight/2);
        player2.setBounds(width / 10 +buttonWidth*4/2, height / 10 +(1*buttonHeight+1*20),buttonWidth,buttonHeight/2);
        player1.setVisible(true);
        player2.setVisible(true);
        player1.setFont(ft2);
        player2.setFont(ft2);

        newGameFrame.add(player1);
        newGameFrame.add(player2);

        JTextField tankColor1 = new JTextField("Wybierz kolor czolgu 1");
        JTextField tankColor2 = new JTextField("Wybierz kolor czolgu 2");
        tankColor1.setEditable(false);
        tankColor2.setEditable(false);
        tankColor1.setBounds(width/10, height / 10 +(2*buttonHeight+2*20),2*buttonWidth,buttonHeight/2);
        tankColor2.setBounds(width /10 + buttonWidth*4/2, height / 10 +(2*buttonHeight+2*20),2*buttonWidth,buttonHeight/2);
        tankColor1.setVisible(true);
        tankColor2.setVisible(true);
        tankColor1.setFont(janusz);
        tankColor2.setFont(janusz);
        tankColor1.setBorder(BorderFactory.createEmptyBorder());
        tankColor2.setBorder(BorderFactory.createEmptyBorder());
        newGameFrame.add(tankColor2);
        newGameFrame.add(tankColor1);

        Choice jaco = new Choice();
        jaco.add("Czerwony");
        jaco.add("Niebieski");
        jaco.add("Zielony");
        jaco.setBounds(width / 6 , height / 9 +(3*buttonHeight+3*2),buttonWidth/2,buttonHeight/2);
        jaco.setVisible(true);
        newGameFrame.add(jaco);

        Choice jaco2 = new Choice();
        jaco2.add("Czerwony");
        jaco2.add("Niebieski");
        jaco2.add("Zielony");
        jaco2.setBounds(width / 6 +buttonWidth*2, height / 9 +(3*buttonHeight+3*2),buttonWidth/2,buttonHeight/2);
        jaco2.setVisible(true);
        newGameFrame.add(jaco2);

        JTextField tanksNumber= new JTextField("Wybierz liczbe czolgow");
        tanksNumber.setEditable(false);
        tanksNumber.setBounds(width / 2 - (buttonWidth*3/5), height / 10 +(4*buttonHeight+4*2),2*buttonWidth,buttonHeight/2);
        tanksNumber.setVisible(true);
        tanksNumber.setFont(janusz);
        tanksNumber.setBorder(BorderFactory.createEmptyBorder());
        newGameFrame.add(tanksNumber);

        Choice tanksNum = new Choice();
        tanksNum.add("1");
        tanksNum.add("2");
        tanksNum.add("3");
        tanksNum.setBounds(width / 2 - (buttonWidth / 3) , height / 9 +(buttonHeight*9/2)+4*2,buttonWidth/2,buttonHeight/2);
        tanksNum.setVisible(true);
        newGameFrame.add(tanksNum);

        startGameButton.setBounds(width / 6 +buttonWidth*2, height / 8 +(5*buttonHeight), buttonWidth, buttonHeight/2);
        startGameButton.setVisible(true);
        startGameButton.setBorder(BorderFactory.createRaisedBevelBorder());
        newGameFrame.add(startGameButton);

        pauseButton.setBounds(width / 6-buttonWidth/4, height / 8 +(5*buttonHeight), buttonWidth, buttonHeight/2);
        pauseButton.setBorder(BorderFactory.createRaisedBevelBorder());
        pauseButton.setVisible(true);
        newGameFrame.add(pauseButton);


        pauseButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                newGameFrame.setVisible(false);
                mainMenuFrame.setVisible(true);

            }
        });

        startGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newGameFrame.setVisible(false);
                gameFrame.createGameFrame(gFrame,mainMenuFrame);
                gFrame.setVisible(true);
            }
        });
    }


}
