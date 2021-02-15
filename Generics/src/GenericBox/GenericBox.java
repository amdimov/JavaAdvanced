package GenericBox;

import java.util.IllegalFormatException;

public class GenericBox<T> {
    T value;

    public GenericBox(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.value.getClass().getName(), this.value);
    }
}
