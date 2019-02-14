package Leetcode.Google.Onsite.Logger_Start_Finish;

public interface Logger {

    void start(int requestId, int startTime);
    void finish(int requestId, int endTime);
}
