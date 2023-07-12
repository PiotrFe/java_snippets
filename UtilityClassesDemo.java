import java.util.*;

public class UtilityClassesDemo {
    public static void main(String[] args) {

        // *********************
        // OPTIONAL
        // *********************

        Optional<String> noVal = Optional.empty();
        Optional<String> hasVal = Optional.of("yes");

        if (noVal.isPresent()) {
            System.out.println("noVal has value");
        } else {
            System.out.println("No vaue in noVal");
        }

        if (hasVal.isPresent()) {
            System.out.println("hasVal has value");
        } else {
            System.out.println("No vaue in hasVal");
        }


        // *********************
        // DATE
        // *********************

        Date date = new Date();
        System.out.println(date);

        long msec = date.getTime();
        System.out.println(msec);

        // *********************
        // CALENDAR
        // *********************

        Calendar cal = Calendar.getInstance();
        System.out.println("Date: ");
        System.out.println("Year: " + cal.get(Calendar.YEAR));
        System.out.println("Month: " + cal.get(Calendar.MONTH));
        System.out.println("Day: " + cal.get(Calendar.DAY_OF_MONTH));
        System.out.println("Week Day: " + cal.get(Calendar.DAY_OF_WEEK));
        System.out.println("Hour: " + cal.get(Calendar.HOUR));
        System.out.println("Minute: " + cal.get(Calendar.MINUTE));
        System.out.println("Second: " + cal.get(Calendar.SECOND));

        cal.set(Calendar.YEAR, 2024);
        cal.set(Calendar.MONTH, 0);
        cal.set(Calendar.DAY_OF_MONTH, 2);

        System.out.println("Year after change: " + cal.get(Calendar.YEAR));
        System.out.println("Month after change: " + cal.get(Calendar.MONTH));
        System.out.println("Day after change: " + cal.get(Calendar.DAY_OF_MONTH));

        // *********************
        // Random
        // *********************
        Random random = new Random();
        double rDouble = random.nextDouble();
        int rInt = random.nextInt();

        System.out.println(rDouble + " - " + rInt);

        // *********************
        // Timer & TimerTask
        // *********************
        class MyTimerTask extends TimerTask {
            public void run() {
                System.out.println("Timer has executed");
            }
        }
        MyTimerTask myTask = new MyTimerTask();
        Timer myTimer = new Timer();

        myTimer.schedule(myTask, 1500, 500);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {}
        
        myTimer.cancel();


        // *********************
        // CURRENCY
        // *********************
        Currency dollar = Currency.getInstance(Locale.US);
        System.out.println(dollar);

        // *********************
        // FORMATTER
        // *********************
        // easier to use with System.out.printf (uses it automatically)
        try (Formatter fm = new Formatter()) {
            fm.format("Formatting %s is %d easy with java %f of the time", "input", 100, 99.87);
            System.out.println(fm);
        }

        // *********************
        // SCANNER
        // *********************
        String strToScan = "10 99.88 scanning is easy";
        Scanner stringScanner = new Scanner(strToScan);

        if (stringScanner.hasNextInt()) {
            int scannerInt = stringScanner.nextInt();
            System.out.println(scannerInt);
        }

        if (stringScanner.hasNextDouble()) {
            double scannerDouble = stringScanner.nextDouble();
            System.out.println(scannerDouble);
        }

        if (stringScanner.hasNext("\s.*nni.*\s")) {
            String scannedStr = stringScanner.next("\s.*nni.*\s");
            System.out.println(scannedStr);
        }

    }
    
}
