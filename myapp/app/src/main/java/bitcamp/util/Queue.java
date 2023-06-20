package bitcamp.util;

public class Queue extends LinkedList {

  public static void main(String[] args) {
    Queue q = new Queue();
    q.offer("홍1");
    q.offer("홍2");
    q.offer("홍3");
    q.offer("홍4");



    System.out.println(q.poll());
    System.out.println(q.poll());
    System.out.println(q.poll());
    System.out.println(q.poll());

    System.out.println(q.poll());

  }

  public void offer(Object value) {
    this.add(value);
  }

  public Object poll() {
    if (this.size() == 0) {
      return null;
    }
    return this.remove(0);
  }
}
