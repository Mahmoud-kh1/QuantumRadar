import java.util.List;

public class Fine {
    private String plateNumber;
    private List<Violation> violations;
    private int totalAmount;

    public Fine(String plateNumber, List<Violation> violations) {
        this.plateNumber = plateNumber;
        this.violations = violations;
        int sum = 0;
        for (Violation v : violations) {
            sum += v.getFee();
        }
        this.totalAmount = sum;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public List<Violation> getViolations() {
        return violations;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void printFine() {
        System.out.println("Traffic fine for car " + plateNumber);
        System.out.println("Total amount: " + totalAmount + " EGP");
        System.out.println("Violations:");
        for (Violation v : violations) {
            System.out.println("- " + v.getDescription() + " : " + v.getFee() + " EGP");
        }
    }
}