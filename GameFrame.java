
//region Import pakietów
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
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
        microTanks = new MicroTanks();
        setPreferredSize(new Dimension(300,300));
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });

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
        settingsPanel.setVisible(true);
        settingsPanel.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
        settingsPanel.setBackground(Color.GREEN);
        Dimension dim = new Dimension(getWidth(),getHeight()/4);
        settingsPanel.setPreferredSize(dim);
        setSettingPanel(settingsPanel);

        frame.add(gamePanel,BorderLayout.CENTER);

        gamePanel.setVisible(true);



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
    private JPanel setSettingPanel(JPanel setPanel){
        JButton shoot = new JButton("fire!");
        JButton right, left, rightAngle, leftAngle, rightPower, leftPower;
        JTextField move, angle,angleMeasure, power, powerMeasure;
        JPanel weaponPanel,anglePanel,movePanel,powerPanel;
        Choice weapons;
        setPanel.setLayout(new GridLayout(2,2));


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

            movePanel = new JPanel(new FlowLayout());
            anglePanel = new JPanel(new FlowLayout());
            weaponPanel = new JPanel(new FlowLayout());
            powerPanel = new JPanel(new FlowLayout());

            move = new JTextField("move");
            move.setEditable(false);
            move.setBorder(BorderFactory.createEmptyBorder());
            angle = new JTextField("angle");
            angle.setEditable(false);
            angle.setBorder(BorderFactory.createEmptyBorder());
            power = new JTextField("power");
            power.setBorder(BorderFactory.createEmptyBorder());
            power.setEditable(false);
            angleMeasure = new JTextField("number");
            powerMeasure = new JTextField("number");
            weapons = new Choice();
            weapons.add("weapon1");



            movePanel.add(move);
            movePanel.add(left);
            movePanel.add(right);
            anglePanel.add(angle);
            anglePanel.add(leftAngle);
            anglePanel.add(angleMeasure);
            anglePanel.add(rightAngle);
            weaponPanel.add(weapons);
            weaponPanel.add(shoot);
            powerPanel.add(power);
            powerPanel.add(leftPower);
            powerPanel.add(powerMeasure);
            powerPanel.add(rightPower);

            setPanel.add(movePanel);
            setPanel.add(anglePanel);
            setPanel.add(weaponPanel);
            setPanel.add(powerPanel);

            movePanel.setVisible(true);
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
            power.setVisible(true);
            powerMeasure.setVisible(true);
            leftPower.setVisible(true);
            rightPower.setVisible(true);



        }
        catch (MalformedURLException e)
        {
            System.err.println("Wyjebało błąd");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return setPanel;
    }

    /**
     * Metoda wywołująca rysowanie komponentów.
     * @param g Kontekst graficzny
     */
    public void paint(Graphics g){
        paintComponent(g);
    }

    /**
     * Metoda rysująca komponenty.
     * @param g Kontekst graficzny
     */
    public void paintComponent(Graphics g) {
        //earthGenerator.earthBuilder(gamePanel,g);
        g.setColor(Color.BLUE);
        g.drawLine(100,100,200,200);
/*
        for (int i = 1; i < 100; i++) {
            x = gamePanel.getWidth() / 100 * i;
            x2 = gamePanel.getWidth() / 100 * (i + 1);
            y = (int) Math.sin(x) / x;
            y2 = (int) Math.sin(x2) / (x2);
            line[i] = new Line2D.Double(x, y, x2, y2);
            g2.drawLine(x, y, x2, y2);
            g2.setColor(Color.black);
            }
*/
        repaint();
    }
}
