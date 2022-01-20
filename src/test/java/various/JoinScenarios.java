package various;

import static org.assertj.core.api.BDDAssertions.then;
import static various.Database.getAllCompanies;
import static various.Database.getAllPersons;

import org.junit.jupiter.api.Test;
import java.util.List;

final class JoinScenarios {

    @Test
    void join() {
        // Given
        var people = getAllPersons();
        var companies = getAllCompanies();
        var expectedResult =
            List.of(
                new Result("p3", "Dariusz", "Company 2")
                   );

        // When
        List<Result> results = Database.executeQuery();

        // Then
        then(results).containsAll(expectedResult);
    }

}
