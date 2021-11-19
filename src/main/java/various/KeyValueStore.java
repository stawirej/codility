package various;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

final class KeyValueStore {

    private final Map<String, Object> store;

    private KeyValueStore() {
        store = new HashMap<>();
    }

    public static KeyValueStore newInstance() {

        return new KeyValueStore();
    }

    public void store(final String key, final Object value) {

        if (!store.containsKey(key)) {
            store.put(key, value);
        } else {
            store.replace(key, value);
        }
    }

    public Optional<Object> get(final String key) {

        if (store.containsKey(key)) {
            return Optional.of(store.get(key));
        }

        return Optional.empty();
    }
}
