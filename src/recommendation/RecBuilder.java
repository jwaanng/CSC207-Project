package recommendation;

import java.util.List;

/**
 * The {@code RecBuilder} interface defines the contract for classes that build recommendations
 * based on a collection of items of type {@code T}.
 *
 * @param <T> The type of items for which recommendations are built.
 */
public interface RecBuilder<T> {

    /**
     * Builds recommendations based on the provided collection of items.
     *
     * @param collection The collection of items to generate recommendations from.
     * @return A {@code Recommendable} object containing recommendations for the specified type.
     */
    Recommendable<T> build(List<T> collection);
}
