package leetcode.weeklyContest;

/**
 * @author: slwhy
 * @date: 2020/5/17
 * @description: 5412. 在既定时间做作业的学生人数
 */
public class BusyStudent {

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i]<=queryTime&&endTime[i]>=queryTime){
                count++;
            }
        }
        return count;
    }
}
