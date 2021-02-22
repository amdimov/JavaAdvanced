package Collection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ListyIterator implements Iterable<String>{
    private List<String> stringList;
    private int index;

    ListyIterator(String... words) {
        this.stringList = new ArrayList<>(Arrays.asList(words));
        this.index = 0;

    }
    public boolean move(){
        if (iterator().hasNext()){
            ++this.index;
            return true;
        }
        return false;
    }

    public void print(){
        try {
            System.out.println(stringList.get(this.index));
        }catch (IndexOutOfBoundsException e){
            System.out.println("Invalid Operation!");
        }
    }
    public void printAll(){
        try {
            this.stringList.forEach(new Consumer<String>() {
                @Override
                public void accept(String s) {
                    System.out.print(s + " ");
                }
            });
            System.out.println();
        }catch (IndexOutOfBoundsException e){
            System.out.println("Invalid Operation!");
        }
    }
    @Override
    public Iterator iterator() {
        return new Iterator() {
            @Override
            public boolean hasNext() {
                return index+1 < stringList.size();
            }

            @Override
            public String next() {
                String element = stringList.get(index);
                index++;
                return element;
            }
        };
    }

}
