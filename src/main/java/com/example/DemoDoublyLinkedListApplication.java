package com.example;

import com.example.doubly.DoublyLinkedList;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoDoublyLinkedListApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoDoublyLinkedListApplication.class, args);
    }

    @Bean
    CommandLineRunner testDoublyLinkedList(String[] args) {
		return runner -> {myDoublyLinkedList();};
    }

	private void myDoublyLinkedList() {
		DoublyLinkedList<String> str = new DoublyLinkedList<>();
		str.add("A");
		str.add("B");
		str.add("C");
		str.add("D");
		str.add("E");
		System.out.println("Size : " + str.size());

		//Get by index
		System.out.println("Get string at last index : " + str.get(str.size()-1));

		System.out.print("Print Forward : ");
		str.printForward();
		System.out.println();

		System.out.print("Print Backward : ");
		str.printBackward();
		System.out.println();

		//Add and Remove in the beginning
		str.add(0,"Z");
		System.out.print("Add in the beginning : ");
		str.printForward();
		str.remove(0);
		System.out.println();
		System.out.print("Remove the beginning : ");
		str.printForward();
		System.out.println();

		//Add and Remove at the last of index
		str.add(str.size()-1,"Z");
		System.out.print("Add at the last of index : ");
		str.printForward();
		str.remove(str.size()-1);
		System.out.println();
		System.out.print("Remove at the last of index : ");
		str.printForward();
		System.out.println();

		//Add and Remove at the middle of list
		str.add(2,"Z");
		System.out.print("Add at the middle of list : ");
		str.printForward();
		str.remove(2);
		System.out.println();
		System.out.print("Remove at the middle of list : ");
		str.printForward();
		System.out.println();

		//Set new value by index
		str.set(0,"Z");
		System.out.print("Set new value by index = 0 : ");
		str.printForward();
		System.out.println();
	}

}
