package buoi11.bt1;

public class CustomThread extends Thread{

    private Integer start;
    private Integer end;
    private String name;

    public CustomThread(Integer start, Integer end, String name) {
        this.start = start;
        this.end = end;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(String.format("Custom thread %s started at", name));
        for (int i = start; i <= end; i++) {
            System.out.println(String.format("Thread %s print value: %d", name, i));
        }
        System.out.println(String.format("Custom thread %s end", name));
    }
}
