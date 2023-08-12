import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Favorites {
    private Map<Class<?>, Object> favorites = new HashMap<>();

    public <T> void putFavorite(Class<T> type, T instance) {
        favorites.put(Objects.requireNonNull(type), instance);
    }

    public <T> T getFavorite(Class<T> type) {
        return type.cast(favorites.get(type));
    }
}

public class CollectionsHeterogeneousContainer {
    public static void main(String[] args) {
        Favorites favorites = new Favorites();

        favorites.putFavorite(String.class, "my String");
        favorites.putFavorite(Integer.class, 4);
        favorites.putFavorite(Class.class, Favorites.class);

        String favString = favorites.getFavorite(String.class);
        int favInt = favorites.getFavorite(Integer.class);
        Class<?> favClass = favorites.getFavorite(Class.class);

        System.out.printf("%s %x %s%n", favString, favInt, favClass);
    }

}
