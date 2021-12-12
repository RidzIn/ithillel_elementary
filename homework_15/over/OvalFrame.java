package homework_15.over;

import javax.swing.*;

public class OvalFrame extends JComponent {
    public OvalFrame() {
        // Создаем объект типа OvalComponent
        OvalComponent oc = new OvalComponent();
        // Испольщзуем метод класса JFrame для добавления
        // компонента на главную панель.
        add(oc);

        // Устанавливаем координаты и размеры окна
        setBounds(200, 200, 300, 250);
    }
}
