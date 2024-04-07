package leetcode;

import java.util.Stack;

public class DesignBrowserHistory {

    private String homepage;
    private final Stack<String> backward;
    private final Stack<String> forward;

    public DesignBrowserHistory(String homepage) {
        this.homepage = homepage;
        this.backward = new Stack<>();
        backward.push(homepage);
        this.forward = new Stack<>();
    }

    public void visit(String url) {
        backward.add(url);
        forward.clear();
        homepage = url;
    }

    public String back(int steps) {
        while (!backward.isEmpty() && steps > 0) {
            String prevPage = backward.pop();
            steps--;
            forward.add(prevPage);
        }

        return backward.isEmpty() ? homepage : backward.peek();
    }

    public String forward(int steps) {
        while (!forward.isEmpty() && steps > 0) {
            String prevPage = forward.pop();
            steps--;
            backward.add(prevPage);
        }

        return forward.isEmpty() ? homepage : forward.peek();
    }

    public static void main(String[] args) {
        DesignBrowserHistory browserHistory = new DesignBrowserHistory("leetcode.com");
        browserHistory.visit("google.com");
        browserHistory.visit("facebook.com");
        browserHistory.visit("youtube.com");
        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.forward(1));
        browserHistory.visit("linkedin.com");
        browserHistory.forward(2);
        System.out.println(browserHistory.back(2));
        System.out.println(browserHistory.back(7));
    }
}
