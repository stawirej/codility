package various;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

final class Database {

    public static List<Result> executeQuery() {

        var people = getAllPersons();
        var companies = getAllCompanies();
        var result = new ArrayList<Result>();

        List<String> personCompanyIds =
            people
                .stream()
                .filter(person -> person.name.equals("Dariusz"))
                .map(person -> person.companyId)
                .collect(toList());

        List<String> companyIds =
            companies
                .stream()
                .map(company -> company.id)
                .collect(toList());

        List<String> commonIds = commonIds(personCompanyIds, companyIds);

        var joinedPeople =
            people
                .stream()
                .filter(person -> commonIds.contains(person.companyId))
                .collect(Collectors.toList());

        Map<String, Company> idToCompany = new HashMap<String, Company>();

        var joinedCompanies =
            companies
                .stream()
                .filter(company -> commonIds.contains(company.id))
                .toList();

        for (int i = 0; i < joinedCompanies.size(); i++) {
            idToCompany.put(joinedCompanies.get(i).id, joinedCompanies.get(i));
        }

     return joinedPeople
         .stream()
         .map(person -> new Result(person.id, person.name, idToCompany.get(person.companyId).name))
         .collect(toList());

    }

    private static List<String> commonIds(final List<String> personCompanyIds, final List<String> companyIds) {

        return personCompanyIds
            .stream()
            .filter(companyIds::contains)
            .collect(toList());
    }

    public static List<Person> getAllPersons() {
        Person p1 = new Person("p1", "Mariusz", "c1");
        Person p2 = new Person("p2", "Dariusz", null);
        Person p3 = new Person("p3", "Dariusz", "c2");

        return Arrays.asList(p1, p2, p3);
    }

    public static List<Company> getAllCompanies() {
        Company c1 = new Company("c1", "Company 1");
        Company c2 = new Company("c2", "Company 2");
        Company c3 = new Company("c3", "Company 3");

        return Arrays.asList(c1, c2, c3);
    }
}
