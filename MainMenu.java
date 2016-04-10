import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Klasa <code>MainMenu</code> odpowiada za utworzenie ramki menu głównego,
 * zawiera przyciski, za pomocą których można się dostać w odpowiednie miejsca
 * aplikacji.
 *
 *  Klasa <code>MainMenu</code> dziedziczy po klasie <code>Frame</code>
 *
 * @author      Bartłomiej Bielecki <address @ example.com>
 * @author      Jacek Polak <polakjacek@gmail.com>
 * @version     1.1
 * @since       2016-03-26
 */

public class MainMenu extends Frame {

    /**
     * Konstruktor klasy <code>MainMenu</code> inicjalizuje  ramki w zależności od
     * rozmiaru ekranu urządzenia wykonującego
     * program.
     */
    public MainMenu(){
        this.width=width/2;
        this.height=height*3/4;
    }

    //region Ramki
    private int buttonWidth=0, buttonHeight=0;
    private Rules rules = new Rules();
    private Authors authors = new Authors();
    private BestScores bestScores = new BestScores();
    private Exit exit = new Exit();
    private NewGame newGame = new NewGame();
    //endregion

    /**
     * Metoda służąca do tworzenia przycisków w menu głównym,
     * ich obsługi zdarzeniowej, a także tworzone są tu ramki
     * poszczególnych opcji wyboru, które przekazujemy do klas.
     *
     * @param frame Ramka menu głównego
     * @return Brak
     */
    public void createFrameButtons(JFrame frame) {

        JFrame newGameFrame;
        JFrame rulesFrame;
        JFrame authorsFrame;
        JFrame bestScoresFrame;
        JFrame exitFrame;

        JButton newGameButton = createAButton(width, height, 0, "New Game");
        JButton rulesButton = createAButton(width, height, 1, "Rules");
        JButton authorButton = createAButton(width, height, 2, "Author");
        JButton bestScoresButton = createAButton(width,height, 3, "Best Scores");
        JButton exitButton = createAButton(width,height, 4, "EXIT");

        newGameFrame = newGame.createAFrame(newGame.getWidth(), newGame.getHeight(), "New Game");
        rulesFrame = rules.createAFrame(rules.getWidth(), rules.getHeight(), "Rules");
        authorsFrame = authors.createAFrame(authors.getWidth(), authors.getHeight(), "Authors");
        bestScoresFrame = bestScores.createAFrame(bestScores.getWidth(), bestScores.getHeight(), "Best Scores");
        exitFrame = exit.createAFrame(exit.getWidth(), exit.getHeight(), "Exit");

        frame.add(newGameButton);
        frame.add(rulesButton);
        frame.add(authorButton);
        frame.add(bestScoresButton);
        frame.add(exitButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        newGameButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                newGame.createNewGameFrame(newGameFrame, frame);
                frame.setVisible(false);
                newGameFrame.setVisible(true);

            }
        });
        rulesButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                rulesFrame.setVisible(true);
                rules.createARulesFrame(rulesFrame,frame);
            }
        });
        authorButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                authorsFrame.setVisible(true);
                frame.setVisible(false);
                authors.createAnAuthorsFrame(authorsFrame,frame);
            }
        });
        bestScoresButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                bestScores.createABestScoresFrame(bestScoresFrame, frame);
                bestScoresFrame.setVisible(true);
            }
        });
        exitButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                exit.createAnExitFrame(exitFrame);
                exitFrame.setVisible(true);
            }
        });
    }


}
