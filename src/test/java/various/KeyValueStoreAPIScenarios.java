package various;

import org.junit.jupiter.api.Test;
import java.util.Optional;

final class KeyValueStoreAPIScenarios {


    @Test
    void insert_single_key_value(){
        // Given
        KeyValueStore keyValueStore = KeyValueStore.newInstance();
        String key = "simpleKey";
        Object value = 1;
        // When
        // CQS
        //void
        keyValueStore
            .store(key, value);

        // Either<Success, Failure>
        Optional<Object> result = keyValueStore.get(key);

//        if (value.ifPresent();)
//        try {
//
//        } catch (Exception e) {
//
//        }

        // Then
    }
}
