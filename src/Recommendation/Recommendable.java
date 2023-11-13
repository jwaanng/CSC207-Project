package Recommendation;

public interface Recommendable<T> {
    boolean hasNext();
    T retrieveNextAndUpdate();
}
