package datastructures.queue;

import java.util.Scanner;

/**
 * @author Miluo
 * @description 数组队列
 * 队列是一个有序列表，只能从一端插入，从另一端取出；
 **/
public class ArrayQueue {

    public static void main(String[] args) {
//        ArrQue arrQue = new ArrQue(5);
        LoopArrayQue loopArrayQue = new LoopArrayQue(5);
        Boolean flag = true;
        while (flag) {
            System.out.println("输入选项");
            System.out.println("1.show");
            System.out.println("2.add");
            System.out.println("3.get");
            System.out.println("4.head");
            System.out.println("5.exit");

            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            switch (s) {
                case "1":
                    loopArrayQue.showQue();
                    break;
                case "2":
                    loopArrayQue.addData();
                    break;
                case "3":
                    loopArrayQue.getData();
                    break;
                case "4":
                    loopArrayQue.getFront();
                    break;
                case "5":
                    flag = false;
                    scanner.close();
                    break;
                default:
                    break;
            }

        }

    }
}

//原始版数组队列类
//head指向头数据的前一个位置，end指向最后一个数据的位置
//该数组只能使用一次，不能复用
class ArrQue {
    private int maxSize;
    private int[] arr;
    private int head;
    private int end;

    public ArrQue(int num) {
        maxSize = num;
        arr = new int[maxSize];
        head = -1;
        end = -1;
    }

    //显示队列
    public void showQue() {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    //取出数据
    public void getData() {
        if (head == end) {
            System.out.println("队列为空");
            return;
        }
        System.out.println("取出" + arr[++head]);
    }

    //添加数据
    public void add() {
        if (end == maxSize - 1) {
            System.out.println("队列已满");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("增加的数值为：");
        String s = scanner.nextLine();
        arr[++end] = Integer.parseInt(s);
    }

    //显示队头数据
    public void head() {
        if (head == end) {
            System.out.println("队列为空");
            return;
        }
        System.out.println("当到队列头数据为：" + arr[head + 1]);
    }
}

//便于复用，创建循环数组队列
//front指向第一个数据，rear指向最后一个数据的后一个位置
//判断队列的空满： 当front==rear为空，当（rear+1） % maxSize = front为满
class LoopArrayQue {
    private int maxSize;
    private int[] arr;
    private int front;
    private int rear;

    public LoopArrayQue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = 0;
        rear = 0;
    }

    //显示队列
    public void showQue() {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[(i + front) % maxSize]);
        }
    }

    //取出数据
    public void getData() {
        if (front == rear) {
            System.out.println("队列为空，无法取出数据");
            return;
        }
        System.out.println("取出的数据为：" + arr[front]);
        arr[front] = 0;
        front = (front + 1) % maxSize;
    }

    //添加数据
    public void addData() {
        if (((rear + 1) % maxSize) == front) {
            System.out.println("队列已满，无法加入数据");
            return;
        }
        System.out.println("请输入要添加的数据：");
        Scanner scanner = new Scanner(System.in);
        arr[rear] = Integer.parseInt(scanner.nextLine());
        rear = (rear + 1) % maxSize;
    }

    //显示队头数据
    public void getFront() {
        if (front == rear) {
            System.out.println("队列为空");
            return;
        }
        System.out.println("当前队列头数据为：" + arr[front]);
    }

}
