package sample;

import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;

public interface Ruchable {
    public void prawo(ImageView imageView, double distance); // relocate obrazka imageView

    public void lewo(ImageView imageView, double distance);

    public void dol(ImageView imageView, double distance);

    public void gora(ImageView imageView, double distance);

    public void moveP(KeyCode keyCode); //zmiana kontrolek ruchu na prawde(po wcisnieciu)

    public void moveF(KeyCode keyCode); // zmiana kontrolek ruchu na falsz(po odcisnieciu)

    public void reset();

    public void go();
}
