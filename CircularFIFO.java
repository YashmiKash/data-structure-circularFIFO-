package circular;
	public class CircularFIFO<T> {
		    private T[] queue;
		    private int capacity;
		    private int size;
		    private int front;
		    private int rear;

		    public CircularFIFO(int capacity) {
		        this.capacity = capacity;
		        queue = (T[]) new Object[capacity];
		        size = 0;
		        front = 0;
		        rear = -1;
		    }

		    public void enqueue(T element) {
		        if (isFull()) {
		            System.out.println("Queue is full. Cannot enqueue.");
		            return;
		        }
		        rear = (rear + 1) % capacity;
		        queue[rear] = element;
		        size++;
		    }

		    public T dequeue() {
		        if (isEmpty()) {
		            System.out.println("Queue is empty. Cannot dequeue.");
		            return null;
		        }
		        T removedElement = queue[front];
		        front = (front + 1) % capacity;
		        size--;
		        return removedElement;
		    }

		    public T peek() {
		        if (isEmpty()) {
		            System.out.println("Queue is empty. Cannot peek.");
		            return null;
		        }
		        return queue[front];
		    }

		    public boolean isEmpty() {
		        return size == 0;
		    }

		    public boolean isFull() {
		        return size == capacity;
		    }

		    public int size() {
		        return size;
		    }

		    public static void main(String[] args) {
		    	CircularFIFO<Integer> circularQueue = new CircularFIFO<>(5);
		        circularQueue.enqueue(1);
		        circularQueue.enqueue(2);
		        circularQueue.enqueue(3);
		        circularQueue.enqueue(4);
		        circularQueue.enqueue(5);
		        circularQueue.enqueue(6); // This will exceed the capacity

		        System.out.println("Dequeuing elements:");
		        while (!circularQueue.isEmpty()) {
		            System.out.println(circularQueue.dequeue());
		        }
		    }
		}
		    