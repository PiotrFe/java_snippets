import java.util.concurrent.*;
import java.util.*;

public class ConcurForkJoinRecursiveAction {
    public static void main(String[] args) {
        // Create a task pool
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool(); // getting a reference to the default common pool (no
                                                               // need to construct new one in most use cases)

        System.out.println("Level of parallelism: " + ForkJoinPool.getCommonPoolParallelism());
        System.out.println("Available processors: " + Runtime.getRuntime().availableProcessors());

        double[] nums = new double[100000];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = (double) i;
        }

        System.out.println("A portion of the original sequence: ");

        for (int i = 0; i < 10; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("\n");

        SqrtTransform task = new SqrtTransform(nums, 0, nums.length);

        forkJoinPool.invoke(task);
        // an alternative: task.invoke(); will be automatically invoked in the common
        // pool; the common pool variable is not required

        System.out.println("A portion of the transformed sequence: ");

        for (int i = 0; i < 10; i++) {
            System.out.format("%.4f", nums[i]);
        }

        System.out.println("\n");
    }
}

class SqrtTransform extends RecursiveAction {
    final int seqThreshold = 1000; // arbitrary; the longer the task is, the lower the threshold should be; ideally
                                   // a task should perform somewhere between 100 and 10,000 computational steps

    double[] data;
    int start, end;

    SqrtTransform(double[] vals, int s, int e) {
        data = vals;
        start = s;
        end = e;
    }

    // this is the method on which parallel computation will occur
    protected void compute() {
        // if number of elements is below the sequential threshold, process sequentially
        if ((end - start) < seqThreshold) {
            for (int i = start; i < end; i++) {
                data[i] = Math.sqrt(data[i]);
            }
        } else {
            // otherwise, continue to break the data into smaller pieces

            // find the midpoint
            int middle = (start + end) / 2;

            // invoke new tasks, using the subdivided data
            invokeAll(new SqrtTransform(data, start, middle), new SqrtTransform(data, middle, end));
        }
    }
}
