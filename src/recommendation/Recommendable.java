package recommendation;


/**
 * The {@code Recommendable} interface defines the contract for classes that provide recommendations
 * for items of type {@code T}.
 *
 * @param <T> The type of items for which recommendations are provided.
 */
public interface Recommendable<T> {

    /**
     * Checks if there are more recommendations available.
     *
     * @return {@code true} if there are more recommendations, {@code false} otherwise.
     */
    boolean hasNext();

    /**
     * Retrieves the next recommendation and updates the recommendation status.
     *
     * @return The next recommended item of type {@code T} or {@code null} if no more recommendations are available.
     */
    T retrieveNextAndUpdate();
}