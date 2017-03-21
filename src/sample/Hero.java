package sample;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Hero extends Ruch {
    public final static int DEFAULT_HERO_SPEED = 3 ;

    public void moveT(ImageView imageView, AnchorPane anchorPane, int szybkosc) {

        final double BORDER_SIZE_RIGHT = anchorPane.getBorder().getStrokes().get(0).getWidths().getRight(),
                BORDER_SIZE_LEFT = anchorPane.getBorder().getStrokes().get(0).getWidths().getLeft(),
                BORDER_SIZE_UP = anchorPane.getBorder().getStrokes().get(0).getWidths().getTop(),
                BORDER_SIZE_DOWN = anchorPane.getBorder().getStrokes().get(0).getWidths().getBottom();
        double  heroX = imageView.getBoundsInLocal().getWidth(),
                heroY = imageView.getBoundsInLocal().getHeight();

        if(imageView.getLayoutX()>BORDER_SIZE_LEFT && isLeft)
            lewo(imageView,szybkosc);
        if(imageView.getLayoutX()<anchorPane.getPrefWidth()-heroX+BORDER_SIZE_RIGHT && isRight)
            prawo(imageView,szybkosc);
        if(imageView.getLayoutY()>BORDER_SIZE_UP && isUp)
            gora(imageView,szybkosc);
        if(imageView.getLayoutY()<anchorPane.getPrefWidth()-heroY+BORDER_SIZE_DOWN && isDown)
            dol(imageView,szybkosc);
    }
}
