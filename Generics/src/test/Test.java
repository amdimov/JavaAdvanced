package test;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;

public class Test <T> implements Iterable{
    private ArrayDeque<T> stack;

    public Test(){
        this.stack = new ArrayDeque<>();
    }
    public void addObject(T type){
        this.stack.push(type);
    }
    public T remove(){
        return this.stack.pop();
    }
    public static <T> void print(T element){
        System.out.println(element);
    }
    @SuppressWarnings("unchecked")
    public static <T> T[] createNewArray(Class<T> clazz,int length, T element){
        T[] arr = (T[]) Array.newInstance(element.getClass(), length);
        Arrays.fill(arr, element);
        return arr;
    }

    @Override
    public String toString() {
        return "test.Test{" +
                "stack=" + stack +
                '}';
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            int index;
            @Override
            public boolean hasNext() {
                return index < stack.size();
            }

            @Override
            public Object next() {
                return index++;
            }
        };
    }
}
