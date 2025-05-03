package asu.edu.marisol;

import java.util.List;
import java.util.Stack;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class ExclusiveTimeofFunctions {

    /**
     * Simple stack approach there is scope for improvement, lets see.
     *
     * @time-complexity - O (N).
     * @space-complexity - O (N).
     */
    public int[] exclusiveTime(int n, List<String> logs) {
        int maxFunctionId = Integer.MIN_VALUE;

        // functionId, start and end time thereafter
        Stack<int[]> st = new Stack<>();

        for (String log : logs) {
            String[] logParts = log.split(":");

            int functionId = Integer.parseInt(logParts[0]);
            String action = logParts[1];
            int timeStamp = Integer.parseInt(logParts[2]);

            maxFunctionId = Math.max(maxFunctionId, functionId);

            if ("start".equals(action)) {
                if (!st.isEmpty() && st.peek()[2] == -1)
                    st.peek()[2] = timeStamp - 1;
                st.push(new int[] { functionId, timeStamp, -1});
            } else if ("end".equals(action)) {
                if (!st.isEmpty() && st.peek()[2] == -1)
                    st.peek()[2] = timeStamp;
                else
                    st.push(new int[] {functionId, timeStamp, timeStamp});
            }
        }

        int [] ans = new int[maxFunctionId + 1];

        while (!st.empty()) {
            int[] functionCallStack = st.pop();
            ans[functionCallStack[0]] += functionCallStack[2] - functionCallStack[1] + 1;
        }

        return ans;
    }


    /**
     * Simple stack approach first one did not work, not fixing the first approach, rather let us fix the problem in this
     * approach.
     *
     * @time-complexity - O (N).
     * @space-complexity - O (N).
     */
    public int[] exclusiveTime2(int n, List<String> logs) {

        // we store the functionId only in the stack
        Stack<Integer> st = new Stack<>();
        int [] ans = new int[n];

        String[] firstLogParts = logs.get(0).split(":");
        st.push(Integer.parseInt(firstLogParts[0]));

        // very important variable, what is stores is timeStamp from which cur operation will hog the CPU
        int prev = Integer.parseInt(firstLogParts[2]);

        for (int i = 1; i < logs.size(); i++) {
            String[] logParts = logs.get(i).split(":");

            int functionId = Integer.parseInt(logParts[0]);
            String action = logParts[1];
            int timeStamp = Integer.parseInt(logParts[2]);

            if ("start".equals(action)) {
                if (!st.empty()) {
                    // pushing a process to a stack
                    ans[st.peek()] += timeStamp - prev;
                }
                // Push current process into the CPU.
                st.push(functionId);

                // current TimeStamp is from which current process will start using the CPU.
                prev = timeStamp;
            } else {

                // +1 since the current Time Stamp was used by the process on the CPU, since it is endTime.
                ans[st.peek()] += timeStamp - prev + 1;

                // process done
                st.pop();

                // Future time for existing process in the Stack.
                prev = timeStamp + 1;
            }
        }

        return ans;
    }

}
