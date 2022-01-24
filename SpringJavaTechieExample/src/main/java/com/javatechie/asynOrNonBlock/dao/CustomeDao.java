package com.javatechie.asynOrNonBlock.dao;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

import com.javatechie.asynOrNonBlock.dto.Customer;

import reactor.core.publisher.Flux;

@Component
public class CustomeDao {

	public static void sleepExecution(int i) {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {

		}
	}

	public List<Customer> getCustomerList() {

		List<Customer> list = IntStream.rangeClosed(0, 50).peek(CustomeDao::sleepExecution)
				.peek(i -> System.out.println("Process Count:" + i))

				.mapToObj(i -> new Customer(i, "Customer" + i)).collect(Collectors.toList());
		return list;

	}

	public Flux<Customer> getCustomerListByStream() {
		Flux<Customer> list = Flux.range(0, 50).delayElements(Duration.ofSeconds(1))
				.doOnNext(i -> System.out.println("Process Count:" + i)).map(i -> new Customer(i, "Customer" + i));

		return list;
	}
}
