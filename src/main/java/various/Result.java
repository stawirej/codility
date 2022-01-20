package various;

import java.util.Objects;

final class Result {

    String personId;
    String personName;
    String companyName;

    public Result(String personId, String personName, String companyName){
        this.personId = personId;
        this.personName = personName;
        this.companyName = companyName;
    }

    public String toString(){
        return personId + "," + personName + "," + companyName;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Result result = (Result)o;
        return Objects.equals(personId, result.personId) && Objects.equals(personName, result.personName)
               && Objects.equals(companyName, result.companyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, personName, companyName);
    }
}
