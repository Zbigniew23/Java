package org.testjava.selenium;

import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreams {

    public static void main(String[] args) {
//        regular();
//        streamFilter();
//        mapFilter();
        streamCollect();
    }

    public static void regular()
    {
        // count the number of names starting with alphabet A in list
        ArrayList<String> names = new ArrayList<String>();
        names.add("Juan");
        names.add("Raul");
        names.add("Fernando");
        names.add("Rafael");
        names.add("Rahul");
        int count = 0;

        for (int i =0; i< names.size(); i++)
        {
            String actual = names.get(i);
            if (actual.startsWith("J"))
            {
                count++;
            }
        }
        System.out.println(count);
    }

    public static void streamFilter()
    {
        ArrayList<String> names = new ArrayList<String>();
        names.add("Juan");
        names.add("Raul");
        names.add("Fernando");
        names.add("Rafael");
        names.add("Rahul");

        // there is no life for intermediate op if there is no terminal op
        // terminal operation will execute only if intermediate op (filter) returns true
        // We can create stream
        // how to use filter in Stream API

        Long c = names.stream().filter(s -> s.startsWith("R")).count();
        System.out.println(c);

        long d = Stream.of("Juan","Raul","Fernando","Rafael", "Rahul").filter(s ->
        {
            s.startsWith("R");
            return true;
        }).count();
        System.out.println(d);
        // print all the names of ArrayList
//        names.stream().filter(s->s.length()>4).forEach(s-> System.out.println(s));
         names.stream().filter(s->s.length()>4).limit(2).forEach(s-> System.out.println(s));
    }

    public static void mapFilter()
    {
        ArrayList<String> names = new ArrayList<String>();
        names.add("William");
        names.add("Jack");
        names.add("James");
        names.add("Michael");
        names.add("David");


        // print names which have last letter as "l" 4 with Uppercase
        Stream.of("Juan","Raul","Fernando","Rafael", "Roberto").filter(s -> s.endsWith("l")).map(s -> s.toUpperCase())
                .forEach(s -> System.out.println(s));

        // print names which have first letter as "R" 4 with Uppercase and sorted
        List<String> nombres = Arrays.asList("Juan","Raul","Fernando","Rafael", "Roberto");
        nombres.stream().filter(s -> s.startsWith("R")).sorted().map(s -> s.toUpperCase())
                .forEach(s -> System.out.println(s));

        // Merging 2 different lists
        Stream<String> newStream = Stream.concat(names.stream(), nombres.stream());
//        newStream.sorted().forEach(s -> System.out.println(s));
        boolean flag = newStream.anyMatch(s -> s.equalsIgnoreCase("Juan"));
        System.out.println(flag);
        Assert.assertTrue(flag);
    }

    public static void streamCollect()
    {
       List<String> ls = Stream.of("Juan","Raul","Fernando","Rafael", "Roberto").filter(s -> s.startsWith("R")).map(s -> s.toUpperCase())
               .collect(Collectors.toList());
        System.out.println(ls);
        System.out.println(ls.get(0));

        List<Integer> values = Arrays.asList(3,2,2,7,5,1,9,7);
        // print unique number from this array
        // sort the array - 3 rd index -1,2,3,5,7,9
//        values.stream().distinct().forEach(s -> System.out.println(s));

        List<Integer> li = values.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(li.get(2));
    }
}
