interface DoubleNumericArrayFn {
    double run(double[] n) throws EmptyArrayException;
}

class EmptyArrayException extends Exception {
    EmptyArrayException() {
        super("Array is empty");
    }
}


public class LamdaExceptionDemo {
    public static void main(String[] args) throws EmptyArrayException {
        double[] values = {1.0, 2.0, 3.0, 4.0};

        DoubleNumericArrayFn average = (double[] arr) -> {
            if (arr.length == 0) {
                throw new EmptyArrayException();
            }

            double sum = 0;

            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
            }

            return sum / arr.length;
        };

        System.out.println("The average for non-empty array is: " + average.run(values));
        System.out.println("The average for an empty array is: " + average.run(new double[0]));

    }
}
