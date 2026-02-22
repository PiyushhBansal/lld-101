import java.util.Optional;

public class CgrRule implements EligibilityRule {
    @Override
    public Optional<String> check(StudentProfile profile) {
        if (profile.cgr < 8.0) {
            return Optional.of("CGR below 8.0");
        }
        return Optional.empty();
    }
}
