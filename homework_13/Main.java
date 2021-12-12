import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;


public class Main {
    public static <Staff> void main(String[] args) throws IOException {
        Gson gson = new Gson();
        try(Reader reader = new FileReader("src/main/resources/journal_ru.json")){

            DayJournal[] dayJournals = gson.fromJson(reader, DayJournal[].class);
            for(DayJournal dj : dayJournals){
                System.out.println(dj);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
