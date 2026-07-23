public class Observation {
    private String plateNumber;
    private CarType carType;
    private int speed;
    private boolean seatbeltFastened;

    public Observation(String plateNumber, CarType carType, int speed, boolean seatbeltFastened) {
        this.plateNumber = plateNumber;
        this.carType = carType;
        this.speed = speed;
        this.seatbeltFastened = seatbeltFastened;
    }

    public String getPlateNumber() { return plateNumber; }
    public CarType getCarType() { return carType; }
    public int getSpeed() { return speed; }
    public boolean isSeatbeltFastened() { return seatbeltFastened; }
}