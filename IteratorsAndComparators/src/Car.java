import java.lang.reflect.Array;
import java.util.*;

public class Car implements Iterable<Car>{
    private String carName;
    private List<Integer> tiresList;

    Car(String carName, Integer... tires){
        this.carName = carName;
        this.tiresList = new ArrayList<>(Arrays.asList(tires));
    }

    private final class CarIterator implements Iterator{
        int index = tiresList.size()-1;
        @Override
        public boolean hasNext() {
            return index >= 0;
        }

        @Override
        public Object next() {
            return tiresList.get(index--);
        }
    }
    @Override
    public Iterator iterator() {
        return new CarIterator();
    }

}
