package homework_15.over;

import javax.swing.JFrame;

public class OvalApplication {
    public static void main(String[] args) {
        OvalFrame of = new OvalFrame();
        // Задаем правидо, по которому приложение завершиться при
        // закрытии этой формы
     //   of.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Делаем окно видимым
        of.setVisible(true);
    }
}
