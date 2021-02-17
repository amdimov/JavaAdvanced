import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cooking {
    public static class Food{
        private String name;
        private int valueNeeded;
        private int amountOfFood;
        private boolean isItBaked;

        public Food(String name, int valueNeeded) {
            this.name = name;
            this.valueNeeded = valueNeeded;
            this.amountOfFood = 0;
            this.isItBaked = false;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getValueNeeded() {
            return valueNeeded;
        }

        public void setValueNeeded(int valueNeeded) {
            this.valueNeeded = valueNeeded;
        }

        public int getAmountOfFood() {
            return amountOfFood;
        }

        public void setAmountOfFood(int amountOfFood) {
            this.amountOfFood = amountOfFood;
        }
        public void increaseAmount(){
            this.amountOfFood++;
        }
        public void bake(){
            this.isItBaked = true;
        }

        public boolean isItBaked() {
            return isItBaked;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] valuesLiquid = scanner.nextLine().split("\\s+");
        String[] valuesIngredients = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> liquidQueue = fillQueueOrStack(valuesLiquid, false);
        ArrayDeque<Integer> ingredientsStack = fillQueueOrStack(valuesIngredients, true);

        Food bread = new Food("Bread", 25);
        Food cake = new Food("Cake", 50);
        Food fruitPie = new Food("Fruit Pie", 100);
        Food pastry = new Food("Pastry", 75);
        ArrayList<Food> foods = new ArrayList<>(List.of(bread, cake, fruitPie,pastry));

        while (!liquidQueue.isEmpty() && !ingredientsStack.isEmpty()){
            boolean foodFound = false;
            int currentSum = liquidQueue.peek() + ingredientsStack.peek();
            for (Food currentFood : foods) {
                if (currentFood.getValueNeeded() == currentSum) {
                    currentFood.increaseAmount();
                    currentFood.bake();
                    liquidQueue.poll();
                    ingredientsStack.pop();
                    foodFound = true;
                    break;
                }
            }
            if (!foodFound){
                liquidQueue.poll();
                Integer increaseIngredient = ingredientsStack.poll();
                increaseIngredient += 3;
                ingredientsStack.push(increaseIngredient);
            }
        }

        boolean isItAllBaked = true;

        for (Food food : foods) {
            if (!food.isItBaked){
                isItAllBaked = false;
                break;
            }
        }
        if (isItAllBaked){
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        }else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to to cook everything.");
        }
        System.out.print("Liquids left: ");
        if (liquidQueue.isEmpty()){
            System.out.print("none");
        }else {
            System.out.print(convertValuesToString(liquidQueue));
        }
        System.out.println();
        System.out.print("Ingredients left: ");
        if (ingredientsStack.isEmpty()){
            System.out.print("none");
        }else {
            System.out.print(convertValuesToString(ingredientsStack));
        }
        System.out.println();

        foods.forEach(e -> System.out.printf("%s: %d%n", e.getName(), e.getAmountOfFood()));

    }
    public static ArrayDeque<Integer> fillQueueOrStack(String[] values, boolean isItStack){
        ArrayDeque<Integer> filledQueue = new ArrayDeque<>();
        for (String value : values) {
            if (isItStack){
                filledQueue.push(Integer.parseInt(value));
            }else {
                filledQueue.offer(Integer.parseInt(value));
            }
        }
        return filledQueue;
    }
    public static String convertValuesToString(ArrayDeque<Integer> arrayDeque){
        StringBuilder string = new StringBuilder();
        while (!arrayDeque.isEmpty()){
            if (arrayDeque.size() == 1){
                    string.append(arrayDeque.poll().toString());
                break;
            }
                string.append(String.format("%s, ", arrayDeque.poll().toString()));

        }
        return string.toString();
    }

}

















