package com.java.interviewPrep.java8;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Primitive {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(7,1,2,8,7,6,23,4,0,8,4));

        // print the element using streams
        System.out.println("print numbers:= ");
        list.stream().forEach(i-> System.out.print(i+" "));

        // filter number that are divisiable by 4
        System.out.println("filter number:= ");
        List<Integer> ls = list.stream().filter(i->i%4==0).collect(Collectors.toList());
        ls.stream().forEach(i-> System.out.print(i+" "));

        // filter the number and print the sqare of them
        System.out.println("filter and map :=");
        list.stream().filter(i->i%4==0).map(i->i*i).forEach(i-> System.out.print(i+" "));

        // filter only prime number using test method
        System.out.println("Prime number :=");
        Predicate<Integer> p = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                if(integer<=1) return true;
                for(int i=2;i<Math.sqrt(integer);i++){
                    if(integer%i==0){
                        return false;
                    }

                }
                return true;
            }
        };
        list.stream().filter(p).forEach(i-> System.out.print(i+" "));

        // sum of even number
        System.out.println("Sum of even number :="+list.stream().filter(i->i%2!=0).mapToInt(i->i).sum());

        // using reduce
        System.out.println("Sum of even number using reduce :="+list.stream().filter(i->i%2==0).mapToInt(i->i)
                .reduce(0,(a,b)->a+b));

        // print max and min number
        // min and max returns optional values
        System.out.println("Print max :="+list.stream().mapToInt(i->i).max());
        System.out.println("Print min :="+ list.stream().mapToInt(i->i).min());
        System.out.println("Print avg :="+ list.stream().mapToDouble(i->i).average());

        // print distinct element
        System.out.println("Print distinct element :=");
        list.stream().distinct().forEach(i-> System.out.println(i));

        // sort the list assending and desciding order
        System.out.println("Print assending:=");
        list.stream().sorted().forEach(i->System.out.print(i));
        System.out.println("Print desc;=");
        list.stream().sorted((a,b)->b-a).forEach(i-> System.out.print(i));

        // print third last element
        System.out.println("Print third last element:="+list.stream().sorted((a,b)->b-a).distinct().skip(2).findFirst());


        // String related
        String st = "abcabcdebac";

        // print th count of each character in the string
        Map<Character,Long> mp = st.chars().mapToObj(i->(char)i)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        mp.entrySet().stream().forEach(i-> System.out.println(i.getKey() +" "+i.getValue()));

        // List of strig
        List<String> ar = new ArrayList<>(Arrays.asList("ram","nam", "man","asba","kaam","shyam"));

        // print string that start with r
        System.out.println("print String start with r:=");
        ar.stream().filter(i->i.startsWith("r")).forEach(i-> System.out.println(i+" "));

        // find first non repeating character
        System.out.println("First non repeating character:=");
        String str = "Java is good";
        Character ch = str.chars().mapToObj(i->(char)i).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(i->i.getValue()==1L)
                .map(i->i.getKey()).findFirst().get();
        System.out.println(ch);

        // flatmap
        System.out.println("convert into list of words:=");
        List<String> sentence = Arrays.asList(
                "Java is good",
                "stream is bad",
                "IT has money"
        );

        System.out.println(sentence.stream().flatMap(i->Arrays.stream(i.split(" "))).toList());

        // find all unique char form list of string
        System.out.println("find unique char from list of string:=");
        ar.stream().flatMap(i->i.chars().mapToObj(j->(char)j).distinct()).distinct().forEach(i-> System.out.print(i+" "));

        // peek
        // peek() is an intermediate operation that allows you
        // to perform side-effects (like logging, debugging, or inspection) without modifying the stream elements.
        // Takes a Consumer<T> (like System.out::println, or a lambda)
        //
        // Returns a new stream that performs the action lazily

        List<String> names = List.of("Alice", "Bob", "Charlie");

        List<String> result = names.stream()
                .filter(name -> name.startsWith("A"))
                .peek(name -> System.out.println("Filtered: " + name))
                .map(String::toUpperCase)
                .peek(name -> System.out.println("Mapped: " + name))
                .collect(Collectors.toList());

    }

    /*
         Map -> <R> Function<T t>
         Function takes input T and return R as output
         Function has apply() methhod

         Filter -> boolean Predicate<T t>
         Filter takes input T and return boolean after filtering the condition
         Filter has test() method

         forEach -> void consumer<T t>
         Consumer takes input T and return void
         Consumer has accept(T t) method

         Lazy loading and Random number generation -> <T> supplier<>
         Supplier take nothing as input but give T as an output
         Supplier has get() methhod

         BiFunctional<T t, U u>, BiConsumer, BiPredicate, BiSupplier take two input as perameter
     */
}
