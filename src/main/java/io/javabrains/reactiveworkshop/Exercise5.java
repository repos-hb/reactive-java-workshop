package io.javabrains.reactiveworkshop;

import java.io.IOException;

import org.reactivestreams.Subscription;

import reactor.core.publisher.BaseSubscriber;

public class Exercise5 {

    public static void main(String[] args) throws IOException, InterruptedException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Subscribe to a mono using the error and completion hooks
        // TODO: Write code here
    	//ReactiveSources.intNumberMono().subscribe(i->System.out.println(i), t -> t.printStackTrace());

        // Subscribe to a mono using an implementation of BaseSubscriber
        // TODO: Write code here
    	ReactiveSources.intNumbersFlux().subscribe(new MySubscriber<>());

        System.out.println("Press a key to end");
        System.in.read();
    }

}

class MySubscriber<T> extends BaseSubscriber<T>{
	@Override
	protected void hookOnSubscribe(Subscription subscription) {
		// TODO Auto-generated method stub
		System.out.println("Subscription happened");
		super.hookOnSubscribe(subscription);
	}
	
	@Override
	protected void hookOnNext(T value) {
		// TODO Auto-generated method stub
		System.out.println(value.toString()+" received");
		super.hookOnNext(value);
	}
}