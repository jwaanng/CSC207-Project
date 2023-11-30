package recommendation;

import java.util.List;

public interface RecBuilder<T> {
    Recommendable<T> build(List<T> collection);
}

