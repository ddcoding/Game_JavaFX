package sample;

import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class CollisionEnemies extends Enemy implements Collision {
    public CollisionEnemies() {

    }

    public void setEnded(boolean ended) {
        isEnded = ended;
    }

    boolean isEnded = false;

    public void keepAway(){
        for(int j=0;j<Enemy.enemies.size();j++){
            for(int i=0;i<Enemy.enemies.size();i++){
                if(isCollided(Enemy.enemies.get(i).getImageView(),Enemy.enemies.get(j).getImageView())){
                    if(i==j) continue;
                    moveT(Enemy.enemies.get(i).getImageView(),Enemy.enemies.get(j).getImageView(),5);
                }
            }
        }
    }


    public boolean gameOver(ImageView e1, ImageView e2){
       // for(Enemy i: enemies) {
        if(isCollided(e1, e2)&&!isEnded)
        {
            isEnded=true;
            Alert gameOver = new Alert(Alert.AlertType.ERROR);
            gameOver.setContentText("UMARLES !");
            gameOver.show();
            return true;
        }
return false;
    }

@Override
public boolean isCollided(ImageView e1, ImageView e2) {
    if(e1.getBoundsInParent().intersects(e2.getBoundsInParent()))
        return true;
    else
        return false;
}
}
