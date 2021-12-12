package homework_15.polymorphism;

import java.awt.GridLayout;
import javax.swing.JFrame;

public class ShapeFrame extends JFrame {
    public ShapeFrame() {

        setLayout(new GridLayout(2, 3));

        add(new OvalComponent());
        add(new RectangleComponent());
        add(new TriangleComponent());
        add(new TriangleComponent());
        add(new RectangleComponent());
        add(new OvalComponent());

        // Устанавливаем координаты и размеры окна
        setBounds(200, 200, 450, 350);
    }
}
