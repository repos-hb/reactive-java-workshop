package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.util.Optional;

public class Exercise4 {

    public static void main(String[] args) throws IOException, InterruptedException {

        // Use ReactiveSources.intNumberMono()

        // Print the value from intNumberMono when it emits
        // TODO: Write code here
    	ReactiveSources.intNumberMono().subscribe(System.out::println);

        // Get the value from the Mono into an integer variable
        // TODO: Write code here
    	Integer value = ReactiveSources.intNumberMono().block();
    	System.out.println(value);
    	
    	Optional<Integer> optInt = ReactiveSources.intNumberMono().blockOptional();
    	if(optInt.isPresent())
    		System.out.println(optInt.get());
    	
        System.out.println("Press a key to end");
        System.in.read();
    }

}
