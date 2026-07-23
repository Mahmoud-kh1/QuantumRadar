import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuantumRadar {
    private List<Rule> rules = new ArrayList<>();
    private List<Fine> allFines = new ArrayList<>();


    public Map<String, Integer> getFines() {
        Map<String, Integer> cur = new HashMap<>();
        for (Fine fine : allFines) {
            String plate = fine.getPlateNumber();
            int amount = fine.getTotalAmount();
            if (cur.containsKey(plate)) {
                int total = cur.get(plate);
                cur.put(plate, total + amount);
            } else {
                cur.put(plate, amount);
            }
        }
        return cur;
    }

    public Map<String, Integer> getViolations() {
        Map<String, Integer> counts = new HashMap<>();
        for (Fine fine : allFines) {
            List<Violation> violations = fine.getViolations();
            for (Violation v : violations) {
                String ruleName = v.getRuleName();
                if (counts.containsKey(ruleName)) {
                    int count = counts.get(ruleName);
                    counts.put(ruleName, count + 1);
                } else {
                    counts.put(ruleName, 1);
                }
            }
        }
        return counts;
    }

    public void addRule(Rule rule) {
        rules.add(rule);
    }
    public void processObservation(Observation obs) {
        List<Violation> violations = new ArrayList<>();
        for (Rule rule : rules) {
            Violation violation = rule.evaluate(obs);
            if (violation != null) {
                violations.add(violation);
            }
        }
        if (!violations.isEmpty()) {
            Fine fine = new Fine(obs.getPlateNumber(), violations);
            allFines.add(fine);
            fine.printFine();
        }
    }

}