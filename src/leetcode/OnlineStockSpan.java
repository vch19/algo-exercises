package leetcode;

import java.util.ArrayList;
import java.util.List;

public class OnlineStockSpan {

    private final List<Integer> spans;

    public OnlineStockSpan() {
        this.spans = new ArrayList<>();
    }

    public int next(int price) {
        spans.add(price);

        int span = 0;

        for (int i = spans.size() - 1; i >= 0; i--) {
            if (spans.get(i) <= price) {
                span++;
            } else {
                break;
            }
        }

        return span;
    }

    public static void main(String[] args) {
        OnlineStockSpan stockSpan = new OnlineStockSpan();
        System.out.println(stockSpan.next(100));
        System.out.println(stockSpan.next(80));
        System.out.println(stockSpan.next(60));
        System.out.println(stockSpan.next(70));
        System.out.println(stockSpan.next(60));
        System.out.println(stockSpan.next(75));
        System.out.println(stockSpan.next(85));
    }
}
