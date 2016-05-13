import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Klasa ta odpowiada za panel rozgrywki, umieszczony on jest w klasie <code>GameFrame</code>.
 *
 */
public class GamePanel extends JPanel implements KeyListener {
    private int width,height;
    private int numberOfTanks=3;
    private int turnNumber=1;
    private Tank[] tank;
    private Tank currentTank;
    Thread[] tankThreads;
    private Player player1 = new Player(NewGame.getColor1(),NewGame.getName1());
    private Player player2 = new Player(NewGame.getColor2(),NewGame.getName2());

    /**
     * Konstruktor klasy <code>GamePanel</code> przyjmuje wartości szerokości i wysokości panelu rozgrywki.
     * @param x Szerokość panelu gry
     * @param y Wysokość panelu gry
     */

    public GamePanel(int x,int y) {
        width=x;
        height=y;
        setPreferredSize(new Dimension(width, height));
        tank = new Tank[numberOfTanks];
        tankThreads = new Thread[numberOfTanks];
        createTanks(tank);
        setFocusable(true);

    }

    public Tank[] createTanks(Tank[] tank){
        for (int i=0;i<numberOfTanks;i++) {
            tankThreads[i]=new Thread(tank[i]);
            tank[i] = new Tank(width, 200, tankThreads[i]);
        }

        selectATank(tank[1]);
        return tank;
    }

    public void selectATank(Tank tank){

        currentTank=tank;
        addKeyListener(this);
        System.out.println("teraz czolg"+currentTank.getX());
        //currentTank.addNotify();
        repaint();
    }

    public void nextTurn(){
        System.out.println("zmiana"+turnNumber + "    "+numberOfTanks);
        if(turnNumber<numberOfTanks) {
            turnNumber+=1;

        }
        else
            turnNumber=1;

        System.out.println("zmiana"+turnNumber);
        selectATank(tank[turnNumber-1]);
    }

    /**
     * Metoda rysująca planszę w zależności od podanej jej funkcji matematycznej,
     * a także czołgi.
     *
     * @param g Kontekst graficzny
     * @return Brak
     */
    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        double x,x2,y,y2;
        int[] formax = new int[2];
        loadMap(formax);

        for(int i=0;i<getWidth();i++)
        {
            x=i;
            x2=(i+1);
            y =  200 + formax[0] * Math.sin((double)i/50) + formax[1];
            y2 =  200 + formax[0] * Math.sin((double)(i+1)/50) + formax[1];
            for(int j=0;j<numberOfTanks;j++) {
                tank[j].setyCoordinates((int) y, i);
            }
            //y=200+((Math.sin(i/10))*100);
            //y = 200 + Integer.parseInt(a) * Math.pow(i,2) + Integer.parseInt(b) + i;
            //y2 = 200 + Integer.parseInt(a) * Math.pow(i+1,2) + Integer.parseInt(b) + (i+1);
            //y2 = 200 + (Math.sin((i + 1) / 10) * 100));
            g.setColor(Color.black);
            // line[i]=new Line2D.Double(x,y,x2,y2);
            g.drawLine((int)x,(int)y,(int)x2,(int)y2);
        }

        System.out.println(currentTank.getX()+"current Tank");
        try {
            currentTank.move();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(int j=0;j<numberOfTanks;j++) {
            tank[j].setRandomY();
            tank[j].draw(g);
        }

        g.drawString(player1.getName(),getWidth()/20,getHeight()/20);
        g.drawString(player2.getName(),7*getWidth()/8,getHeight()/20);
        g.drawString(Integer.toString(player1.getPoints()),getWidth()/20,getHeight()/20 + 20);
        g.drawString(Integer.toString(player2.getPoints()),7*getWidth()/8,getHeight()/20 + 20);

        repaint();
    }



    public void setTanksCoordinates(int x)
    {

    }
    /**
     * Metoda parsująca informacje o planszy do utworzenia z plików
     * konfiguracyjnych.
     * @return Współczynniki funkcji
     * @throws IOException
     */

    private int[] loadMap(int[] form)
    {
        String a = "1",b = "2";
        try {
            File mapFile = new File("maplvl2.properties");
            Properties pro = new Properties();
            FileInputStream fis = new FileInputStream(mapFile);
            pro.load(fis);
            a = pro.getProperty("a");
            b = pro.getProperty("b");
        } catch (IOException e) {
            e.printStackTrace();
        }
        form[0] = Integer.parseInt(a);
        form[1] = Integer.parseInt(b);

        return form;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * Metoda ustawiająca kierunek czołgu.
     * @param e KeyEvent
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == e.VK_LEFT) {
            currentTank.setXDirection(-1);
            // System.out.println("dziala");
        }
        if (keyCode == e.VK_RIGHT) {
            currentTank.setXDirection(1);
        }
        if(keyCode == e.VK_SPACE){
            currentTank.releaseTheBullet();
        }
    }

    /**
     * Metoda zatrzymująca czołg w momencie puszczenia klawisza kierunkowego(srzałki).
     *
     * @param e KeyEvent
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == e.VK_LEFT) {
            currentTank.setXDirection(0);
        }
        if (keyCode == e.VK_RIGHT) {
            currentTank.setXDirection(0);
        }
    }

    public void turn (){


    }
}
