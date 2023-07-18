import java.util.concurrent.*;

public class ConcurForkJoinRecursiveTask {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        double nums[] = new double[5000];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = (double) (((i % 2) == 0) ? i : -i);
        }

        SumTask task = new SumTask(nums, 0, nums.length);

        double summation = forkJoinPool.invoke(task); // invoke waits for result; execute runs asynchronously (starts
                                                      // task and continues running); takes ForkJoinTask or Runnable,
                                                      // the latter forms a bridge between traditional multithreading
                                                      // approach

        System.out.println("Summation: " + summation);
    }
}

class SumTask extends RecursiveTask<Double> {
    final int seqThreshold = 500;
    double[] data;
    int start, end;

    SumTask(double[] vals, int s, int e) {
        data = vals;
        start = s;
        end = e;
    }

    protected Double compute() {
        double sum = 0;

        if ((end - start) < seqThreshold) {
            for (int i = start; i < end; i++) {
                sum += data[i];
            }
        } else {
            int middle = (start + end) / 2;

            SumTask subTaskA = new SumTask(data, start, middle);
            SumTask subTaskB = new SumTask(data, middle, end);

            // start each subtask by forking
            subTaskA.fork();
            subTaskB.fork();

            // wait for the subtasks to return and aggregate the results
            sum = subTaskA.join() + subTaskB.join();
        }

        return sum;
    }
}
