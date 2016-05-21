import sun.plugin2.util.ColorUtil;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Line2D;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.Graphics;
//endregion

/**
 * Klasa <code>GameFrame</code> odpowiedzialna jest za utworzenie ramki, w której
 * odbywać się będzie rozgrywka.
 *
 *
 * @author      Bartłomiej Bielecki <address @ example.com>
 * @author      Jacek Polak <polakjacek@gmail.com>
 * @version     1.1
 * @since       2016-03-26
 */

public class GameFrame extends Frame
{
    GamePanel gamePanel;
    EarthGenerator earthGenerator;
    MicroTanks microTanks;
    Image dbimage;
    Graphics dgb;

    /**
     * Konstruktor klasy <code>GameFrame</code> tworzy planszę na panelu rozgrywki.
     */
    public GameFrame()
    {
        this.width=width/2;
        this.height=height*3/4;
        earthGenerator = new EarthGenerator();
        setPreferredSize(new Dimension(800,600));

    }

    /**
     * Metoda ta tworzy ramkę rozgrywki i dodaje do niej panele:
     * - górny panel faktycznej rozgrywki
     * - dolny panel wyboru parametrów strzału
     * @param frame Ramka gry
     * @param mainMenuframe Ramka menu głównego, do którego można powrócić przyciskiem
     */
    public void createGameFrame(JFrame frame, JFrame mainMenuframe)
    {
        JPanel settingsPanel = new JPanel();
        gamePanel = new GamePanel(frame.getWidth(),frame.getHeight()/4);

        frame.setLayout(new BorderLayout());
        frame.add(settingsPanel,BorderLayout.SOUTH);
        frame.setMinimumSize(new Dimension(getWidth(),500));
        settingsPanel.setVisible(true);
        settingsPanel.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
        Dimension dim = new Dimension(getWidth(),getHeight()/4);
        settingsPanel.setPreferredSize(dim);
        setSettingPanel(settingsPanel,frame,mainMenuframe);


        frame.add(gamePanel,BorderLayout.CENTER);

        gamePanel.setLayout(new GridBagLayout());
        gamePanel.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

    }

    /**
     * Metoda odpowiedzialna za panel ustawień strzału tj. wybór broni, kąta...
     * Zawiera pobieranie ikon z intenetu.
     * @param setPanel Pusty panel
     * @exception MalformedURLException
     * @exception IOException
     * @see MalformedURLException
     * @see IOException
     * @return Stworzony panel ustawień strzału
     */
    private JPanel setSettingPanel(JPanel setPanel, JFrame gameFrame, JFrame mainMenuFrame){
        JButton shoot = new JButton("fire!"), nextTurn=new JButton("Next Turn");
        JButton right, left, rightAngle, leftAngle, rightPower, leftPower, backButton;
        JTextField move, angle,angleMeasure, power, powerMeasure;
        JPanel weaponAndBackPanel,anglePanel,movePanel,powerPanel,backPanel, weaponPanel;
        Choice weapons;
        setPanel.setLayout(new GridLayout(2,2));
        Font ft=new Font("Comic", Font.BOLD, 16);
        Font ft2=new Font("Comic", Font.ITALIC, 14);


        Image imgLeft,imgRight;
        ImageIcon im,im2;
        try
        {
            URL url = new URL("http://www.pd4pic.com/images/computer-back-icon-left-right-arrow-cartoon.png");
            URL url2 = new URL("http://www.pd4pic.com/images/computer-icon-left-right-arrow-cartoon-orange.png");
            imgLeft = ImageIO.read(url);
            imgRight = ImageIO.read(url2);
            imgLeft = imgLeft.getScaledInstance(15,15,100);
            imgRight = imgRight.getScaledInstance(15,15,100);
            im = new ImageIcon(imgLeft);
            im2 = new ImageIcon(imgRight);
            right = new JButton(im2);
            left = new JButton(im);
            rightAngle = new JButton(im2);
            leftAngle = new JButton(im);
            rightPower = new JButton(im2);
            leftPower = new JButton(im);
            backButton = new JButton("BACK TO MENU");
            backButton.setBorder(BorderFactory.createRaisedBevelBorder());


            movePanel = new JPanel(new FlowLayout());
            anglePanel = new JPanel(new FlowLayout());
            weaponAndBackPanel = new JPanel(new BorderLayout());
            backPanel = new JPanel(new FlowLayout());
            weaponPanel = new JPanel(new FlowLayout());
            powerPanel = new JPanel(new FlowLayout());
            movePanel.setBackground(new Color(119,166,206));
            weaponPanel.setBackground(new Color(119,166,206));
            backPanel.setBackground(new Color(119,166,206));
            powerPanel.setBackground(new Color(119,166,206));
            anglePanel.setBackground(new Color(119,166,206));

            move = new JTextField("move");
            move.setEditable(false);
            move.setBorder(BorderFactory.createEmptyBorder());
            move.setFont(ft);
            move.setForeground(new Color(8,124,89));
            move.setBackground(new Color(119,166,206));
            angle = new JTextField("angle");
            angle.setEditable(false);
            angle.setBorder(BorderFactory.createEmptyBorder());
            angle.setFont(ft);
            angle.setForeground(new Color(8,124,89));
            angle.setBackground(new Color(119,166,206));
            power = new JTextField("power");
            power.setBorder(BorderFactory.createEmptyBorder());
            power.setEditable(false);
            power.setFont(ft);
            power.setForeground(new Color(8,124,89));
            power.setBackground(new Color(119,166,206));
            angleMeasure = new JTextField("number");
            angleMeasure.setFont(ft2);
            angleMeasure.setForeground(Color.black);
            angleMeasure.setBackground(new Color(119,166,206));
            angleMeasure.setBorder(BorderFactory.createEmptyBorder());
            powerMeasure = new JTextField("number");
            powerMeasure.setFont(ft2);
            powerMeasure.setForeground(Color.black);
            powerMeasure.setBackground(new Color(119,166,206));
            powerMeasure.setBorder(BorderFactory.createEmptyBorder());
            weapons = new Choice();
            weapons.add("weapon1");

            movePanel.add(move);
            movePanel.add(left);
            movePanel.add(right);
            anglePanel.add(angle);
            anglePanel.add(leftAngle);
            anglePanel.add(angleMeasure);
            anglePanel.add(rightAngle);
            weaponAndBackPanel.add(weaponPanel,BorderLayout.CENTER);
            weaponAndBackPanel.add(backPanel,BorderLayout.SOUTH);
            weaponPanel.add(weapons);
            weaponPanel.add(shoot);
            weaponPanel.add(nextTurn);
            backPanel.add(backButton);
            powerPanel.add(power);
            powerPanel.add(leftPower);
            powerPanel.add(powerMeasure);
            powerPanel.add(rightPower);

            setPanel.add(movePanel);
            setPanel.add(anglePanel);
            setPanel.add(powerPanel);
            setPanel.add(weaponAndBackPanel);

            movePanel.setVisible(true);
            weaponAndBackPanel.setVisible(true);
            backPanel.setVisible(true);
            weaponPanel.setVisible(true);
            powerPanel.setVisible(true);
            anglePanel.setVisible(true);
            move.setVisible(true);
            left.setVisible(true);
            right.setVisible(true);
            angle.setVisible(true);
            angleMeasure.setVisible(true);
            leftAngle.setVisible(true);
            rightAngle.setVisible(true);
            weapons.setVisible(true);
            shoot.setVisible(true);
            nextTurn.setVisible(true);
            power.setVisible(true);
            powerMeasure.setVisible(true);
            leftPower.setVisible(true);
            rightPower.setVisible(true);
            backButton.setVisible(true);

            gamePanel.addKeyListener(gamePanel);
            setPanel.setFocusable(false);
            gamePanel.setFocusable(true);

            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    gameFrame.setVisible(false);
                    gameFrame.remove(gamePanel);
                    gameFrame.remove(setPanel);
                    mainMenuFrame.setVisible(true);

                }
            });

            nextTurn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    gamePanel.nextTurn();
                    gamePanel.requestFocus();
                }
            });

            shoot.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    gamePanel.setAngle(Integer.parseInt(angleMeasure.getText()));
                    gamePanel.setStregth(Integer.parseInt(powerMeasure.getText()));

                    gamePanel.shot();

                    gamePanel.requestFocus();
                }
            });



            right.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        gamePanel.moveOfTank(1);
                        gamePanel.requestFocus();
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
            });

            left.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        gamePanel.moveOfTank(-1);
                        gamePanel.requestFocus();
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
            });




        }
        catch (MalformedURLException e)
        {
            System.err.println("błąd");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return setPanel;
    }
}
