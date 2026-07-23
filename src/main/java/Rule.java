public interface Rule {
    Violation evaluate(Observation obs);
}

class SeatbeltRule implements Rule {
    private int fee;
    public SeatbeltRule(int fee) {
        this.fee = fee;
    }
    @Override
    public Violation evaluate(Observation obs) {
        if (!obs.isSeatbeltFastened()) {
            return new Violation("SeatbeltRule", "Seatbelt not put", fee);
        }
        return null;
    }
}

class SpeedRule implements Rule {
    private CarType tar;
    private int maxSpeed;
    private int fee;

    public SpeedRule(CarType tar, int maxSpeed, int fee) {
        this.tar = tar;
        this.maxSpeed = maxSpeed;
        this.fee = fee;
    }

    @Override
    public Violation evaluate(Observation obs) {
        if (obs.getCarType() == tar && obs.getSpeed() > maxSpeed) {
            String desc = "speed of " + obs.getSpeed() + " exceeded max allowed " + maxSpeed;
            return new Violation("SpeedRule " + tar.name(), desc, fee);
        }
        return null;
    }
}