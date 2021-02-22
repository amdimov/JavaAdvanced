package ListyIterator;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListyIterator {
    private List<String> stringList;
    private int index;

    ListyIterator(String... words) {
        this.stringList = new ArrayList<>(Arrays.asList(words));
        this.index = 0;
    }
    public boolean move(){
        if (hasNext()){
            ++this.index;
            return true;
        }
        return false;
    }
    public boolean hasNext(){
        return index+1 < this.stringList.size();
    }
    public void print(){
        try {
            System.out.println(stringList.get(this.index));
        }catch (IndexOutOfBoundsException e){
            System.out.println("Invalid Operation!");
        }

    }

}
