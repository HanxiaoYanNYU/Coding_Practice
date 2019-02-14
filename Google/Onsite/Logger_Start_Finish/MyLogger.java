package Leetcode.Google.Onsite.Logger_Start_Finish;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyLogger implements Logger{

    private Map<Integer, Request> map = new HashMap<>();
    private List<Request> requestList = new ArrayList<>();

    public static void main(String[] args) {
        MyLogger log = new MyLogger();
        log.start(1, 100);
        log.start(2, 101);
        log.finish(2, 102);
        log.start(3, 103);
        log.finish(1, 104);
        log.finish(3, 105);

        log.print();
    }

    @Override
    public void start(int requestId, int startTime) {
        Request request = new Request(requestId, startTime);
        map.put(requestId, request);
        requestList.add(request);
    }

    @Override
    public void finish(int requestId, int endTime) {
        if (!map.containsKey(requestId)) {
            System.out.println("Invalid requestId: input requestId not exist");
            return;
        }

        Request request = map.get(requestId);
        if (request.startTime > endTime) {
            System.out.println("Invalid endTime");
            return;
        }
        request.endTime = endTime;
        map.remove(requestId);
    }

    public void print() {
        for (Request request : requestList) {
            if (request.endTime != -1) {
                System.out.printf("%d starts at %d and ends at %d\n",
                        request.requestId, request.startTime, request.endTime);
            }
        }
    }

    private class Request {
        public int requestId;
        public int startTime;
        public int endTime = -1;

        public Request(int requestId, int startTime) {
            this.requestId = requestId;
            this.startTime = startTime;
        }
    }

}
