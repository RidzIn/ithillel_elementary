package homework_15.over;

import java.awt.Graphics;
import javax.swing.JComponent;

public class OvalComponent extends JComponent{
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Используем Graphics для рисования овала
        // с отступами
        g.drawOval(5, 5, getWidth() - 10, getHeight() - 10);
    }
}
