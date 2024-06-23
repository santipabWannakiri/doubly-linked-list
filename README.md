# doubly-linked-list
## Introduction
I believe that anyone who codes in Java will eventually encounter a linked list. It's simple to use; Java already provides interfaces for us. However, despite my frequent use of it, I still lack a thorough understanding of its internal workings. Therefore, in this blog, I will delve deeply into the implementation of Linked List, its pros and cons, and other related topics. I hope this blog could be beneficial to someone who is looking to learn about LinkedIn as well.


## LinkedList vs String[]
When managing collections of data in Java, choosing the right data structure is crucial for efficient performance and flexibility. Here, we compare LinkedList<String> with String[] to illustrate when and why you might prefer using a linked list over an array of strings:

| Feature / Consideration     | `String[]` (Array of Strings)                 | `LinkedList<String>` (Linked List of Strings)                           |
|-----------------------------|-----------------------------------------------|-------------------------------------------------------------------------|
| **Fixed Size**              | Yes                                           | No                                                                      |
| **Random Access**           | Yes (by index)                                | No (sequential access required for traversal)                           |
| **Memory Efficiency**       | More memory-efficient (contiguous storage)    | Less memory-efficient (uses more memory due to node overhead)           |
| **Insertions and Deletions**| Slower for large arrays (shift elements)      | Faster (adjusts references, no need to shift elements)                  |
| **Dynamic Size**            | No                                            | Yes                                                                     |
| **Performance Considerations** | Efficient for random access operations     | Efficient for frequent insertions/deletions and iteration operations     |

### Key Points of Comparison:

- **Fixed vs. Dynamic Size:**
  - `String[]`: Suitable when the number of elements is constant.
  - `LinkedList<String>`: Ideal for collections with varying sizes.

- **Access Patterns:**
  - `String[]`: Efficient for random access using indices.
  - `LinkedList<String>`: Efficient for sequential access and frequent insertions/deletions.

- **Memory Usage:**
  - `String[]`: More memory-efficient due to contiguous storage.
  - `LinkedList<String>`: Uses more memory due to node overhead.

### Conclusion

Choose `String[]` for fixed-size collections requiring efficient random access. Opt for `LinkedList<String>` when flexibility in size and efficient insertions/deletions are needed. Understanding these differences helps optimize performance and scalability in Java applications.

## Singly vs. Doubly Linked Lists
When managing collections of data in Java, linked lists offer dynamic size and efficient insertions and deletions. Here, we compare the two main types of linked lists: singly linked lists and doubly linked lists.

### Comparison of Singly and Doubly Linked Lists

| Feature / Consideration     | Singly Linked List                               | Doubly Linked List                               |
|-----------------------------|--------------------------------------------------|--------------------------------------------------|
| **Node Structure**          | Each node has data and a reference to the next node | Each node has data, a reference to the next node, and a reference to the previous node |
| **Memory Efficiency**       | More memory-efficient (less overhead)            | Less memory-efficient (more overhead due to extra reference) |
| **Traversal**               | One direction (forward)                          | Two directions (forward and backward)            |
| **Insertion/Deletion Complexity** | Efficient (O(1)) at the head, O(n) elsewhere | Efficient (O(1)) at both head and tail, O(n) elsewhere |
| **Use Cases**               | Simple list operations, stacks   

Because doubly linked lists offer more comprehensive functionality compared to singly linked lists, this blog will focus on implementing doubly linked lists.\
However, the concepts and methods discussed can also be applied to singly linked lists. Understanding these differences will help you optimize performance and memory usage in Java applications.

## Doubly Linked Lists

<p align="center">
  <img src="images/overall-concept.png" alt="image description" width="850" height="300">
</p>

- **Head and Tail**
  - `Head`: The first node in the doubly linked list. It points to the second node via its "next" reference. The "previous" reference of the head node is null or None.
  - `Tail`: The last node in the doubly linked list. It points to null or None via its "next" reference. The "previous" reference of the tail node points to the node before it.

- **Left and Right**
  - `Left`: In the context of a doubly linked list, moving left means moving towards the head of the list (following the "previous" references).
  - `Right`: Moving right means moving towards the tail of the list (following the "next" references).


head = left , tail = right ?
Big O, Best case, Worst, Average
