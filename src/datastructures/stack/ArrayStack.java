package datastructures.stack;

/**
 * @className: SequenceStack
 * @description: 底层由数组实现的栈
 * @author: Miluo
 * @date: 2023/2/16
 **/
public class ArrayStack {
    private int capacity;
    private int count = 0;
    private String[] arr;

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        arr = new String[capacity];
    }

    public boolean push(String str) {
        if (count == capacity) {
            return false;
        }
        arr[count++] = str;
        return true;
    }

    public String pop() {
        if (count == 0) {
            return null;
        }
        String str = arr[count - 1];
        count--;
        return str;
    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);
        arrayStack.push("1");
        arrayStack.push("2");
        arrayStack.push("3");
        arrayStack.push("4");
        arrayStack.push("5");
        for (int i = 0; i < 3; i++) {
            System.out.println(arrayStack.pop());
        }
        arrayStack.push("6");
        System.out.println("0000");
    }

}
