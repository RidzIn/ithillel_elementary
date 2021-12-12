package homework_21;

public class VipTicket extends Ticket {
    private Meal meal;
    private Baggage baggage;

    public VipTicket(int sitNumber, FlightInfo flightInfo, Passenger passenger, Meal meal, Baggage baggage) {
        super(sitNumber, flightInfo, passenger);
        this.meal = meal;
        this.baggage = baggage;
    }


    public int getCost() {
        return this.meal.getPrice() + this.baggage.getCustomsFee() + super.getCost();
    }

    @Override
    public String toString() {
        return "VipTicket{" +
                "meal=" + meal +
                ", baggage=" + baggage +
                ", ticket price=" + getCost() + '$' +
                '}';
    }
}
