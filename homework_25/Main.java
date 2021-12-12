package homework_25;

import java.util.HashMap;


public class Main {
    public static void main(String[] args) {
         HashMap<String, String> map = new HashMap<>();
         MyTranslator myTranslator = new MyTranslator(map);
         myTranslator.addWords("Hello", "Привет");
         myTranslator.addWords("My", "Мое");
         myTranslator.addWords("Name", "Имя");
         myTranslator.addWords("Is", "");
         myTranslator.addWords("Danylo", "Данил");

         myTranslator.translate("Hello My Name Is Danylo");
         myTranslator.translate("Hello Danylo");
         myTranslator.translate("Is Is Is Is Name");
    }
}
