package recommendation;

public interface Recommendable<T> {
    boolean hasNext();
    T retrieveNextAndUpdate();
}
