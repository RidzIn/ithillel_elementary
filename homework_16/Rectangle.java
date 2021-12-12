package homework_16;

public class Rectangle {
    private double width;
    private double length;

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
        this.width = checkIfNegative(width);
        this.length = checkIfNegative(length);
    }

    public double checkIfNegative(double number) {
        if (number < 0) {
            number = 0;
        }
        return number;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public double getArea() {
        return getLength() * getWidth();
    }
}
