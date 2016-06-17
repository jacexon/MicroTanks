import javax.swing.*;
import java.awt.*;


/**
 * Klasa implementująca pojedynczy czołg.
 * @author      Bartłomiej Bielecki <address @ example.com>
 * @author      Jacek Polak <polakjacek@gmail.com>
 * @version     1.1
 * @since       2016-03-26
 */

public class Tank extends JPanel implements Runnable {

    private Rectangle bulletFigure, tankFigure;
    private int widthOfTank, heightOfTank;
    private int lenghtOfCannon, widthOfCannon;
    private int sizeOfBullet;
    private int strengthOfShot, angleOfShot;
    private double speedY=600, speedX=8;
    private double time;
    private int x,y,xDirection,xBullet,yBullet,deltaX, widthOfPanel, heightOfPanel;
    private int currentTankStartPosition;
    private static final int g=50;
    private int[] yCoordinates;
    private Thread moveThread;
    private boolean bulletReleased=false,readyToShot=false, endOfMove=true, collisionsDetected=false;
    public Color colorOfTank;
    private int level=1;
    private Weapon weapon;
    private int choosenWeapon = 1;
    private Image weaponImageStar=null;

    /**
     * Konstruktor klasy <code>Tank</code> tworzy czołg w zależności od współrzędnych,
     * na których chcemy go umieścić.
     * @param width Współrzędna 'x' ekranu
     * @param height Współrzędna 'y' ekranu
     */
    public Tank(int width,int height, Thread tThread){
        widthOfPanel=width;
        heightOfPanel=height;
        moveThread=tThread;
        int rand = (int)(Math.random()*widthOfPanel);
        this.x=rand;
        this.yCoordinates=new int[width*3];

        xBullet=x;
        yBullet=y;
        widthOfTank=40;
        heightOfTank=10;
        lenghtOfCannon= 15;
        widthOfCannon= 3;
        sizeOfBullet=3;
        deltaX=4;
        setDoubleBuffered(true);
        bulletFigure = new Rectangle(xBullet-widthOfCannon/2,yBullet-heightOfTank-lenghtOfCannon,sizeOfBullet,sizeOfBullet);
        tankFigure = new Rectangle(x-widthOfTank/2, y-heightOfTank, widthOfTank, heightOfTank);
    }
    /**
     * Metoda ustawiająca współrzędne Y pojedynczego czołgu.
     * @param yy Współrzędna Y
     * @param i iterator
     */
    public void setyCoordinates(int yy,int i){
        yCoordinates[i]=yy;

    }


    /**
     *
     * Metoda losująca umieszczenie czołgów przy starcie gry.
     */
    public void setRandomY(){
        y=yCoordinates[this.x];
    }
    /**
     * Metoda rysująca pojedynczy czołg, pociski i sterująca rodzajem broni.
     * @param g Kontekst graficzny
     */
    public void draw(Graphics g) {
        //bulletFigure.setLocation(xBullet-widthOfCannon/2,yBullet-heightOfTank-lenghtOfCannon);

        switch (choosenWeapon) {
            case 1: {
                bulletFigure.setSize(sizeOfBullet,sizeOfBullet);
                bulletFigure.setLocation(xBullet-widthOfCannon/2,yBullet-heightOfTank-lenghtOfCannon);
                g.setColor(Color.black);
                g.fillRect((int) bulletFigure.getX(), (int) bulletFigure.getY(), (int) bulletFigure.getWidth(), (int) bulletFigure.getHeight());
                break;
            }
            case 2: {
                bulletFigure.setLocation(xBullet-widthOfCannon/2,yBullet-heightOfTank-lenghtOfCannon);
                g.setColor(Color.black);
                bulletFigure.setSize(sizeOfBullet*3,sizeOfBullet*3);
                g.fillRect((int)bulletFigure.getX(),(int)bulletFigure.getY(),(int)bulletFigure.getWidth(),(int)bulletFigure.getHeight());
                break;
            }
            case 3:{
                g.setColor(Color.red);
                bulletFigure.setSize(sizeOfBullet,sizeOfBullet);
                if(bulletReleased) {
                    bulletFigure.setLocation(xBullet - widthOfCannon / 2, (int) (yBullet - heightOfTank - lenghtOfCannon - ((yBullet - heightOfTank - lenghtOfCannon )*Math.sin((xBullet - widthOfCannon / 2) / 50))));
                    g.fillRect(xBullet-widthOfCannon/2,(int)(yBullet-heightOfTank-lenghtOfCannon-(((yBullet-heightOfTank-lenghtOfCannon)*Math.sin((xBullet-widthOfCannon/2)/50)))),(int)bulletFigure.getWidth(),(int)bulletFigure.getHeight());
                }
                break;
            }
            case 4:{
                g.setColor(Color.LIGHT_GRAY);
                bulletFigure.setLocation(xBullet-widthOfCannon/2,yBullet-heightOfTank-lenghtOfCannon);
                bulletFigure.setSize(sizeOfBullet*4,sizeOfBullet*4);
                drawWeapon(g,weaponImageStar,xBullet-widthOfCannon/2-widthOfPanel/20,yBullet-heightOfTank-lenghtOfCannon-heightOfPanel/20,widthOfPanel/10,heightOfPanel/8);

                break;
            }



            default: {
                g.setColor(Color.black);
                g.fillRect((int) bulletFigure.getX(), (int) bulletFigure.getY(), (int) bulletFigure.getWidth(), (int) bulletFigure.getHeight());
                break;
            }
        }

        g.setColor(colorOfTank);
        tankFigure.setLocation(x-widthOfTank/2, y-heightOfTank);
        g.fillRect(x-widthOfTank/2, y-heightOfTank, widthOfTank, heightOfTank);
        g.fillRect(x-widthOfCannon/2, y - heightOfTank-lenghtOfCannon, widthOfCannon, lenghtOfCannon);

        //   if(bulletFigure.intersects(tankFigure))
        //     System.out.println("bum");

    }

    /**
     * Metoda sterująca rodzajem broni, skaluje obrazek i rysuje go
     * @param g Kontekst graficzny
     * @param weapon Obrazek broni
     * @param x Współrzędna X, dla której należy narysować obrazek
     * @param y Współrzędna Y, dla której należy narysować obrazek
     * @param width Szerokość obrazka
     * @param height Wysokość obrazka
     */
    public void drawWeapon(Graphics g,Image weapon, int x, int y, int width, int height ){

        weapon = weapon.getScaledInstance(width,height,100);
        g.drawImage(weapon, x,y, null);

    }


    /**
     * Metoda odpowiadająca za ruch czołgu. Korzysta z wątku.
     *
     */
    public void move(int dir) throws InterruptedException {
        moveThread.sleep(10);
        if(readyToShot){
            xBullet=x;
            yBullet=y;
            readyToShot=false;
        }

        if (bulletReleased==false && endOfMove==false) {
            time=0;
            if(!collisionsDetected)
                x += dir;
            else {
                x = x;
                moveThread.sleep(1000);
            }
            xBullet=x;
            yBullet=y;
            if (x <= 1) {
                x = 1;
                y = yCoordinates[x];
            }
            if (x >= widthOfPanel - 20) {
                x = widthOfPanel - 20;
                y = yCoordinates[x];
            }
            y = yCoordinates[x];

            if(dir==1) {
                if (x - currentTankStartPosition >= 100)
                    endOfMove = true;

            }
            else {
                if (currentTankStartPosition - x >= 100)
                    endOfMove = true;
            }
        }
        if(bulletReleased==true){

            long startTime = System.currentTimeMillis();
            if(!collisionsDetected) {
                setBulletCoordinates();
            }
            else {
                xBullet=widthOfPanel*2;
                yBullet=-heightOfPanel;
                moveThread.sleep(500);

                collisionsDetected=false;
                bulletReleased = false;
                readyToShot = false;
                time = 0;
            }

            // System.out.println("szczal   " + xBullet);
            if(xBullet>=widthOfPanel*3 || xBullet<=-10 || yBullet<-100 || yBullet>=1000){
                bulletReleased = false;
                readyToShot = false;
                time = 0;
            }
        }
        //System.out.println(x+"   "+y);
    }

    /**
     * Metoda ustawiająca tor lotu pocisku i jego prędkość
     * @throws InterruptedException
     */
    public void setBulletCoordinates() throws InterruptedException {
        double speed;
        double cnst=(double)deltaX/speedX;

        if((speedX<0.001) && (speedX>-0.001))
            cnst=1;

        time+=Math.abs(cnst);
        moveThread.sleep((long)Math.abs(cnst));
        // System.out.println(time);
        speed=-speedY+time*(double)g/2;
        if((speedX<0.001) && (speedX>-0.001))
            xBullet+=0;
        else
            xBullet+=deltaX*Math.signum(speedX);

        yBullet=(int)((double)yBullet+speed/100);
    }

    /**
     * Metoda ustawiająca flagę pozwalająca na wystrzelenie pocisku.
     */
    public void releaseTheBullet(){
        bulletReleased=true;
    }

    /**
     * Metoda ustawiająca kierunek czołgu w poziomie.
     * @param xdir Kierunek
     */
    public void setXDirection(int xdir)
    {
        xDirection = xdir;
        System.out.println(xDirection + "    " + x);
    }

    /**
     * Pobranie współrzędnej X obiektu.
     * @return x
     */
    public int getX(){return x;}

    /**
     * Pobranie współrzędnej X pocisku.
     * @return współrzędna X pocisku
     */
    public int getXBullet(){return xBullet;}
    /**
     * Pobranie współrzędnej y pocisku.
     * @return współrzędna y pocisku
     */
    public int getyBullet(){return yBullet;}

    /**
     * Metoda sterująca zmienną, która mówi ile tur rozegra się na jednym poziomie
     * @param flag Parametr sterujący
     */
    public void setEndOfMove(boolean flag){endOfMove = flag;}

    /**
     * Metoda służąca do ustawienia startowej pozycji czołgu.
     * @param pos Współrzędna startowa
     */
    public void setCurrentTankStartPosition(int pos){currentTankStartPosition=pos;}

    /**
     * Metoda ustawiająca flagę ready, czołg wyraża gotowość do strzału
     * @param ready Flaga
     */
    public void setReadyToShot(boolean ready) {readyToShot=ready;}

    /**
     * Metoda sprawdzająca wystąpienie kolizji.
     * @param CD Flaga, true - wystąpienie kolizji, false - brak
     */
    public void setCollisionsDetected(boolean CD) {collisionsDetected=CD;}

    /**
     * Ustawienie obecnej broni.
     * @param chWeap Obecna broń.
     */
    public void setChosenWepon(int chWeap){choosenWeapon=chWeap;}

    /**
     * Ustawienie jednej z broni obrazka, który będzie towarzyszył pociskowi w locie.
     * @param WIS Obrazek
     */
    public void setWeaponImageStar(Image WIS){weaponImageStar=WIS;}

    /**
     * Metoda sprawdzająca czy jeszcze jesteśmy w fazie strzału, czy już nie
     * @return Flaga informująca o tym czy jeszcze strzelamy
     */
    public boolean isShooting(){return bulletReleased;}

    /**
     * Metoda pobierająca obiekt pocisku.
     * @return Pocisk
     */
    public Rectangle getBulletFigure(){return bulletFigure;}

    /**
     * Metoda pobierająca obiekt czołgu
     * @return Czołg
     */
    public Rectangle getTankFigure(){return tankFigure;}

    /**
     * Ustawienie siły strzału i jego prędkości zgodnie z zasadami fizycznymi rzutu ukośnego
     * @param strength Siła strzału
     */
    public void setStrengthOfShot(int strength){
        strengthOfShot=strength;
        speedX=(Math.cos((double)angleOfShot*Math.PI/180))*strength/10;
        speedY=(Math.sin((double)angleOfShot*Math.PI/180))*10*strength;
    }

    /**
     * Ustawienie kąta wystrzału pocisku
     * @param angle Kąt wystrzału
     */
    public void setAngleOfShot(int angle){
        angleOfShot=angle;
    }

    /**
     * Uaktualnienie położenia pocisku po zmianie poziomu.
     */
    public void weaponCoordinatesUpdate(){
        xBullet=x;
        yBullet=y;
    }


    /**
     * Metoda zdarzeniowa z interfejsu Runnable wykonująca wątek.
     */
    public void run(){}
}
