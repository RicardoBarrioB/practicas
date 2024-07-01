package practicas.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main
{
    public static void main (String args[])
    {
        Integer[] array = {1,2,3,4,5,6};
        System.out.println("Hola que tal");
        Arrays.stream(array).forEach(System.out::println);
        List<Integer> lista = new ArrayList<>(Arrays.asList(array));
        lista.stream().map(x -> x + 1).forEach(System.out::println);
    }
}
