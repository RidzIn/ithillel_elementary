package homework_21;

public class Ticket {
    private final int sitNumber;
    private final FlightInfo flightInfo;
    private final Passenger passenger;

    public Ticket(int sitNumber, FlightInfo flightInfo, Passenger passenger) {
        this.sitNumber = sitNumber;
        this.flightInfo = flightInfo;
        this.passenger = passenger;
    }

    public int getCost() {
        return flightInfo.getCost();
    }

    public int getSitNumber() {
        return sitNumber;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "sitNumber=" + sitNumber +
                ", flightInfo=" + flightInfo +
                ", passenger=" + passenger +
                ", ticket price=" + getCost() + '$' +
                '}';
    }
}
