import com.google.gson.Gson;

import java.util.List;

public class DayJournal {
    private List<String> events;
    private boolean squirrel;

    @Override
    public String toString() {
        return "DayJournal{" +
                "events=" + events +
                ", squirrel=" + squirrel +
                '}';
    }
}
