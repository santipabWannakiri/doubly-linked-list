package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.example.doubly.DoublyLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoDoublyLinkedListApplicationTests {

    private static final int LONG_LIST_LENGTH = 10;

    DoublyLinkedList<String> shortList;
    DoublyLinkedList<Integer> emptyList;
    DoublyLinkedList<Integer> longerList;
    DoublyLinkedList<Integer> list1;
    DoublyLinkedList<Integer> listAtIndex;

    @BeforeEach
    public void setup() {
        shortList = new DoublyLinkedList<String>();
        shortList.add("A");
        shortList.add("B");
        emptyList = new DoublyLinkedList<Integer>();
        longerList = new DoublyLinkedList<Integer>();
        for (int i = 0; i < LONG_LIST_LENGTH; i++) {
            longerList.add(i);
        }
        list1 = new DoublyLinkedList<Integer>();
        list1.add(65);
        list1.add(21);
        list1.add(42);
    }

    @Test
    public void testGet() {
        assertThrows(IndexOutOfBoundsException.class, () -> emptyList.get(0), "Check out of bound");
        assertEquals("A", shortList.get(0), "Check first");
        assertEquals("B", shortList.get(1), "Check second");
        assertThrows(IndexOutOfBoundsException.class, () -> shortList.get(-1), "Check out of bound");
        assertThrows(IndexOutOfBoundsException.class, () -> shortList.get(2), "Check out of bound");

        for (int i = 0; i < LONG_LIST_LENGTH; i++) {
            assertEquals(i, longerList.get(i), "Check " + i + "element");
        }
        assertThrows(IndexOutOfBoundsException.class, () -> longerList.get(-1), "Check out of bound");
        assertThrows(IndexOutOfBoundsException.class, () -> longerList.get(LONG_LIST_LENGTH), "Check out of bound");
    }

    @Test
    public void testRemove() {
        assertEquals(65, list1.remove(0), "Remove index 0 : ");
        assertEquals(21, list1.get(0), "Get index 0 : ");
        assertEquals(2, list1.size(), "Get size of list : ");
        assertThrows(IndexOutOfBoundsException.class, () -> list1.get(-1), "Check out of bounds too low index.");
        assertThrows(IndexOutOfBoundsException.class, () -> list1.get(10), "Check out of bounds too high index.");
    }

    @Test
    public void testAddEnd() {
        int i = 1;
        while (i < 100) {
            boolean result = list1.add(i * 10);
            assertEquals(true, result, "Add end of list success.");
            assertEquals(i * 10, list1.get(list1.size() - 1), "Add end of list check result.");
            i++;
        }
        assertThrows(NullPointerException.class, () -> list1.add(null), "Check null pointer exception.");
    }

    @Test
    public void testSize() {
        assertEquals(2, shortList.size());
        assertEquals(3, list1.size());
    }

    @Test
    public void testAtIndex() {
        listAtIndex = new DoublyLinkedList<Integer>();
        for (int i = 1; i < 6; i++) {
            listAtIndex.add(i);
        }
        listAtIndex.add(2,6);
        assertEquals(6,listAtIndex.get(2),"AddAtIndex verify.");
        assertEquals(5,listAtIndex.get(5),"AddAtIndex verify.");
        assertThrows(IndexOutOfBoundsException.class, () -> listAtIndex.add(-1,99),"Check out of bounds too low index.");
        assertThrows(IndexOutOfBoundsException.class, () -> listAtIndex.add(77,99),"Check out of bounds too high index.");
        assertThrows(NullPointerException.class,() -> listAtIndex.add(2,null),"Check null.");
    }

    @Test
    public void testSet(){
        assertEquals(21,list1.set(1,999),"Set at index verify old data.");
        assertEquals(999,list1.get(1),"Set at index verify index at set.");
        assertThrows(IndexOutOfBoundsException.class,() -> list1.set(-1,999),"Check out of bounds too low index.");
        assertThrows(IndexOutOfBoundsException.class,() -> list1.set(10,999),"Check out of bounds too high index.");
        assertThrows(NullPointerException.class,() -> list1.set(2,null),"Check null");
    }


}
