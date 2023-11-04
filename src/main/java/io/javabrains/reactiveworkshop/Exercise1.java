package io.javabrains.reactiveworkshop;

import java.util.Optional;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        // TODO: Write code here
    	StreamSources.intNumbersStream().forEach(System.out::println);
    	System.out.println("-------------------");
    	
    	

        // Print numbers from intNumbersStream that are less than 5
        // TODO: Write code here
    	StreamSources.intNumbersStream().filter(n->n<5).forEach(System.out::println);
    	System.out.println("-------------------");
    	
    	

        // Print the second and third numbers in intNumbersStream that's greater than 5
        // TODO: Write code here
    	StreamSources.intNumbersStream().filter(n->n>5)
    		.limit(3)
    		.skip(1)
    		.forEach(System.out::println);
    	System.out.println("-------------------");
    	
    	

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        // TODO: Write code here
    	System.out.println("approach 1");
    	Optional<Integer> isFoundOpt = 
    			StreamSources.intNumbersStream()
	    			.filter(n->n>5)
	    			.limit(1)
	    			.findAny();
    	if(isFoundOpt.isPresent())
    		System.out.println(isFoundOpt.get());
    	else
    		System.out.println("-1");
    	System.out.println("-------------------");
    	
    	
    	System.out.println("approach 2");
    	Integer value = StreamSources.intNumbersStream()
    			.filter(n->n>5)
    			.findFirst()
    			.orElse(-1);
    	System.out.println(value);
    	System.out.println("-------------------");
    	

    	
        // Print first names of all users in userStream
        // TODO: Write code here
    	System.out.println("approach 1");
    	StreamSources.userStream()
    		.forEach(user-> System.out.println(user.getFirstName()));
    	System.out.println("-------------------");
    	

    	System.out.println("approach 2");
    	StreamSources.userStream()
    		.map(user->user.getFirstName())		// replaces user stream with stream of firstnames
    		.forEach(System.out::println);
    	System.out.println("-------------------");
    	
    	

        // Print first names in userStream for users that have IDs from number stream
        // TODO: Write code here
    	System.out.println("approach 1");
    	StreamSources.userStream()
    		.filter(user -> StreamSources.intNumbersStream().anyMatch(n-> n==user.getId()))
    		.forEach(user->System.out.println(user.getFirstName()));
    	System.out.println("-------------------");


    	System.out.println("map() returns Streams");
    	StreamSources.intNumbersStream()
    		.map(id-> StreamSources.userStream().filter(user -> user.getId() == id))
    		.forEach(value1 -> System.out.println(value1));

    	System.out.println("flatMap() returns Users");
    	StreamSources.intNumbersStream()
    		.flatMap(id-> StreamSources.userStream().filter(user -> user.getId() == id))
    		.forEach(value1 -> System.out.println(value1));
    }

}
