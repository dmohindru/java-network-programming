package Ch3Threads.executors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorUserInterface {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int num = 1_000_000_000;
        // create an Integer array
        int []intArray = new int[num];
        // Initialize array
        for (int i = 0; i < num; i++)
            intArray[i] = i;

        FindMaxTask task1 = new FindMaxTask(intArray, 0, intArray.length);

        // Compute result in a single thread
        ExecutorService service = Executors.newFixedThreadPool(1);
        long millsStart = System.currentTimeMillis();
        Future<Integer> future1 = service.submit(task1);
        int largestNum = future1.get();
        long millsEnd = System.currentTimeMillis();


        System.out.println("Computing result in single thread");
        System.out.printf("Largest number %d found in %d milliseconds", largestNum, millsEnd - millsStart);

        // Compute result in two threads
        millsStart = System.currentTimeMillis();
        largestNum = MultithreadedMaxFinder.max(intArray);
        millsEnd = System.currentTimeMillis();

        System.out.println("Computing result in two thread");
        System.out.printf("Largest number %d found in %d milliseconds", largestNum, millsEnd - millsStart);

    }
}
