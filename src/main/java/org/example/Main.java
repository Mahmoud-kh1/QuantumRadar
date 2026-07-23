public class Main {
    public static void main(String[] args) {
        QuantumRadar radar = new QuantumRadar();
        radar.addRule(new SeatbeltRule(100));
        radar.addRule(new SpeedRule(CarType.PRIVATE, 80, 300));
        radar.addRule(new SpeedRule(CarType.TRUCK, 90, 500));
        radar.addRule(new SpeedRule(CarType.BUS, 100, 500));
        Observation obs1 = new Observation(
                "مصر123",
                CarType.BUS,
                101,
                false
        );
        Observation obs2 = new Observation(
                "مصر124",
                CarType.PRIVATE,
                81,
                true
        );
        Observation obs3 = new Observation(
                "مصر125",
                CarType.TRUCK,
                91,
                false
        );
        radar.processObservation(obs1);
        radar.processObservation(obs2);
        radar.processObservation(obs3);
        System.out.println("-------");
        System.out.println("All Possible Fines: " + radar.getFines());
        System.out.println("All Violated Rules: " + radar.getViolations());
    }
}