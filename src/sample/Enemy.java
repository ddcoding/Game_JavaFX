package sample;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public class Enemy extends Ruch implements Collision {
    public Enemy() {

    }
    public double getSpeed() {
        return speed;
    }

    private double speed;

    public ImageView getImageView() {
        return imageView;
    }

    ImageView imageView;
    static public ArrayList<Enemy> enemies = new ArrayList<>();
    public Enemy(ImageView imageView, int numer, double szybkosc)
    {
        this.imageView = imageView;
        enemies.add(this);
        this.speed=szybkosc;
        //setStyle(numer);
        //this.szybkosc=szybkosc;
    }

    public void chase(ImageView jackView,ImageView enemy1,ImageView enemy2,double speed,double speed2) {
        double myX = jackView.getLayoutX() / 2;
        double myY = jackView.getLayoutY() / 2;
        double x2 = enemy1.getLayoutX() / 2;
        double y2 = enemy1.getLayoutY() / 2;
        double x3 = enemy2.getLayoutX() / 2;
        double y3 = enemy2.getLayoutY() / 2;
        double szybkosc_M ;
        if(speed>=speed2)
                szybkosc_M=speed;
        else
            szybkosc_M=speed2;
        if(isCollided(enemy1,enemy2))
        moveT(enemy1,enemy2,szybkosc_M);

            if (trueMove()) {
                if (myX > x2) {
                    prawo(enemy1, speed);
                }
                else
                    lewo(enemy1, speed);
                if (myY > y2)
                    dol(enemy1, speed);
                else
                    gora(enemy1, speed);

                if (myX > x3)
                    prawo(enemy2, speed2);
                else
                    lewo(enemy2, speed2);
                if (myY > y3)
                    dol(enemy2, speed2);
                else
                    gora(enemy2, speed2);
            }
    }
  /*  public void moveT(Enemy enemy1, Enemy enemy2) {
        final double WIDTH_FIRST_ENEMY=enemy1.getImageView().getBoundsInLocal().getWidth(),
                     HEIGHT_FIRST_ENEMY=enemy1.getImageView().getBoundsInLocal().getHeight(),
                     WIDTH_SECOND_ENEMY=enemy2.getImageView().getBoundsInLocal().getWidth(),
                     HEIGHT_SECOND_ENEMY=enemy2.getImageView().getBoundsInLocal().getHeight();
            if(enemy1.getImageView().getLayoutX()+WIDTH_FIRST_ENEMY >= enemy2.getImageView().getLayoutX()){
                lewo(enemy1.getImageView(),enemy1.getSpeed());
                prawo(enemy2.getImageView(),enemy2.getSpeed()); //1 z lewej
            }
            if(enemy1.getImageView().getLayoutX()<=enemy2.getImageView().getLayoutX() + WIDTH_SECOND_ENEMY){
                prawo(enemy1.getImageView(),enemy1.getSpeed());//1 z prawej
                lewo(enemy2.getImageView(),enemy2.getSpeed());
            }
             if(enemy1.getImageView().getLayoutY() + HEIGHT_FIRST_ENEMY>=enemy2.getImageView().getLayoutY()){//1 z gory
                 gora(enemy1.getImageView(),enemy1.getSpeed());
                 dol(enemy2.getImageView(),enemy2.getSpeed());
            }
             if(enemy1.getImageView().getLayoutY()<=enemy2.getImageView().getLayoutY()+HEIGHT_SECOND_ENEMY) {//1 z dolu
                 dol(enemy1.getImageView(),enemy1.getSpeed());
                 gora(enemy2.getImageView(),enemy2.getSpeed());
            }else{
                enemy1.resume();
                enemy2.resume();
            }
    }*/
  public void moveT(ImageView enemy1, ImageView enemy2,double szybkosc) {
      final double WIDTH_FIRST_ENEMY=enemy1.getBoundsInLocal().getWidth(),
              HEIGHT_FIRST_ENEMY=enemy1.getBoundsInLocal().getHeight(),
              WIDTH_SECOND_ENEMY=enemy2.getBoundsInLocal().getWidth(),
              HEIGHT_SECOND_ENEMY=enemy2.getBoundsInLocal().getHeight();
      if((enemy1.getLayoutX()+WIDTH_FIRST_ENEMY) > enemy2.getLayoutX()){
          pause();
          lewo(enemy1,szybkosc);//1 z lewej
      }else
      if(enemy1.getLayoutX()<(enemy2.getLayoutX() + WIDTH_SECOND_ENEMY)){
          pause();
          prawo(enemy1,szybkosc);//1 z prawej
      }
      if((enemy1.getLayoutY() + HEIGHT_FIRST_ENEMY)<enemy2.getLayoutY()){//1 z gory
          pause();
          gora(enemy1,szybkosc);
      }else
      if(enemy1.getLayoutY()<(enemy2.getLayoutY()+HEIGHT_SECOND_ENEMY)) {//1 z dolu
          pause();
          dol(enemy1,szybkosc);
      }
      resume();
   // if(!isCollided(enemy1,enemy2)) setIsMove(true);
  }


    @Override
    public boolean isCollided(ImageView e1, ImageView e2) {
        if(e1.getBoundsInParent().intersects(e2.getBoundsInParent()))
            return true;
        else
            return false;
    }
}
