package middleclass2.generic.test.ex1;

import java.util.Hashtable;
import java.util.Map;

public class Pair<T, S> {
    private T first;
    private S second;

    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(S second) {
            this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public S getSecond() {
        return second;
    }
}
