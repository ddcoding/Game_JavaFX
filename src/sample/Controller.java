package sample;

import b.c.J;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML protected ImageView Jack,Przyjaciel,Przyjaciel2;
    @FXML protected AnchorPane anchorPane;
    @FXML
    public void exitApplication() {
        Platform.exit();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        CollisionEnemies enemies = new CollisionEnemies();
        anchorPane.sceneProperty().addListener((observableScene, oldScene, newScene) -> {
            if (oldScene == null && newScene != null) {
                newScene.windowProperty().addListener((observableWindow, oldWindow, newWindow) -> {
                    if (oldWindow == null && newWindow != null) {
                        Hero hero = new Hero();
                        Enemy enemy = new Enemy(Przyjaciel,1,1);
                        Enemy enemy2 = new Enemy(Przyjaciel2,1,1.5);
                        Jack.getScene().setOnKeyPressed(new EventHandler<KeyEvent>() {
                            @Override
                            public void handle(KeyEvent event) {
                                hero.moveP(event.getCode());
                            }
                        });

                        Jack.getScene().setOnKeyReleased(new EventHandler<KeyEvent>() {
                            @Override
                            public void handle(KeyEvent event) {
                                hero.moveF(event.getCode());
                            }
                        });
                        AnimationTimer timer = new AnimationTimer() {
                            @Override
                            public void handle(long now) {
                                hero.moveT(Jack,anchorPane,Hero.DEFAULT_HERO_SPEED);
                                //enemies.keepAway();
                                enemies.chase(Jack,Przyjaciel,Przyjaciel2,1,1.5);
                             //   enemy.chase(Jack,Przyjaciel);
                              //  enemy2.chase(Jack,Przyjaciel2);
                              //  System.out.println("Pierwszy: " + Jack.getLayoutX() + " " +Jack.getLayoutY() + " " + enemy.getImageView().getBoundsInLocal().getHeight() +  " " + enemy.getImageView().getBoundsInLocal().getWidth());
                                for(int i = 0 ; i < Enemy.enemies.size() ; i++)
                               if(enemies.gameOver(Enemy.enemies.get(i).getImageView(), Jack))
                               {
                                //   hero.reset();
                                //   Jack.relocate(125,125);
                                 //  Przyjaciel.relocate(225,10);
                                 //  enemies.setEnded(false);
                                   exitApplication();
                               }
                            }
                        };
                        timer.start(); // Timer od ruchu.
                    }
                });
            }
        });
    }
}
