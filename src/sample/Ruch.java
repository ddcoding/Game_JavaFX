package sample;

import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;

public class Ruch extends Controller implements Ruchable{
    boolean isLeft = false,
            isRight = false,
            isUp = false,
            isDown = false ;

    @Override
    public void moveF(KeyCode keyCode)
    {
        switch (keyCode) {
            case LEFT:
                isLeft = false;
                break;
            case RIGHT:
                isRight = false;
                break;
            case UP:
                isUp = false;
                break;
            case DOWN:
                isDown = false;
                break;
        }
    }
    @Override
    public void moveP(KeyCode keyCode)
    {
            switch (keyCode) {
                case LEFT:
                    isLeft = true;
                    break;
                case RIGHT:
                    isRight = true;
                    break;
                case UP:
                    isUp = true;
                    break;
                case DOWN:
                    isDown = true;
                    break;
            }
        }
        public void reset(){
            isLeft = false;
            isRight = false;
            isUp = false;
            isDown = false ;
        }
        public void go(){
            isLeft = true;
            isRight = true;
            isUp = true;
            isDown = true ;
        }
    @Override
    public void prawo(ImageView imageView, double szybkosc)
        {
            imageView.relocate(imageView.getLayoutX()+szybkosc,imageView.getLayoutY());
        }

    @Override
    public void lewo(ImageView imageView, double szybkosc)
    {
        imageView.relocate(imageView.getLayoutX()-szybkosc,imageView.getLayoutY());
    }

    @Override
    public void dol(ImageView imageView, double szybkosc)
    {
        imageView.relocate(imageView.getLayoutX(),imageView.getLayoutY()+szybkosc);
    }

    @Override
    public void gora(ImageView imageView, double szybkosc)
    {
        imageView.relocate(imageView.getLayoutX(),imageView.getLayoutY()-szybkosc);
    }
// -------------------------------------------------------------------
    boolean isMove=true;
    public boolean isMove() {
        return isMove;
    }
    boolean isEnemyRight=true,
            isEnemyLeft=true,
            isEnemyUp=true,
            isEnemyDown=true;
    void pause(){
        isMove=false;
        isEnemyRight=false;
             isEnemyLeft=false;
           isEnemyUp=false;
           isEnemyDown=false;
    }

    void resume(){
        isMove=true;
        isEnemyRight=true;
        isEnemyLeft=true;
        isEnemyUp=true;
        isEnemyDown=true;
    }
    boolean trueMove(){
        if(isEnemyRight==true
           && isEnemyLeft==true
           && isEnemyUp==true
           && isEnemyDown==true)
            return true;
        else
            return false;
    }
}
