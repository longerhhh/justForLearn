package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

public class TestJava7 {
    public static void main(String[] args) {
        // 钻石操作符 <> (类型推断)
        Map<String, String> stringStringMap = new HashMap<>();
        // try - with - resource
        // switch 支持字符串
        // 数字支持下划线 1000_000
        // 二进制数字的支持
        int a = 0b1;
        // NIO : Path, Paths, FileSystem, FileSystems
        // 文件更改通知 WatchService
//        watchServiceSample();
        // 多个异常处理
        try (InputStream inputStream = new FileInputStream("")) {
        } catch (IOException | IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
        // Fork/Join 框架 ： 他是分治算法的并行版本，典型用法伪代码如下
        /*
         * <code>
         *   Result solve(Problem problem){
         *      if (problem is small){
         *          directly solve problem
         *      } else {
         *          split problem into independent parts
         *          fork new subtasks to solve each part
         *          join all subtasks
         *          compose result from subresults
         *      }
         *   }
         * </code>
         */
    }

    private static void watchServiceSample() {
        // create an instance using java.nio.file.FileSystems class
        try (WatchService watchService = FileSystems.getDefault().newWatchService()) {
            // create the path to the directory we want monitor
            Path monitoredPath = Paths.get("");
            // register the path to watch service
            WatchKey watchKey = monitoredPath.register(
                    watchService,
                    StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_DELETE,
                    StandardWatchEventKinds.ENTRY_MODIFY,
                    StandardWatchEventKinds.OVERFLOW
            );
            // Watch service offers us no callback methods which are called whenever an event occurs.
            // We can only poll it in a number of ways to find this information.
            // WatchKey watchKey = watchService.poll();
            // This API call returns right away.
            // It returns the next queued watch key any of whose events have occurred or null if no registered events have occurred.
            // We can also use an overloaded version that takes a timeout argument:
            // WatchKey watchKey = watchService.poll(long timeout, TimeUnit units);
            // This API call is similar to the previous one in return value.
            // However, it blocks for timeout units of time to give more time within which an event may occur instead of returning null right away.
            // WatchKey watchKey = watchService.take();
            // We must note something very important here:
            // when the WatchKey instance is returned by either of the poll or take APIs,
            // it will not capture more events if it’s reset API is not invoked:
            // watchKey.reset();
            // WatchKey key;
            // This means that the watch key instance is removed from the watch service queue every time it is returned by a poll operation.
            // The reset API call puts it back in the queue to wait for more events.
            // The most practical application of the watcher service would require a loop within which we continuously check for changes in the watched directory and process accordingly.
            // We can use the following idiom to implement this:
            WatchKey key;
            while ((key = watchService.take()) != null) {
                for (WatchEvent<?> event : key.pollEvents()) {
                    //process
                    System.out.println(event.kind());
                }
                key.reset();
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static class MyTask extends RecursiveTask<Long> {
        public static final long THRESHOLD = 1000L;
        Long start;
        Long end;

        public MyTask(Long start, Long end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
//            System.out.println("MyTask.compute:" + Thread.currentThread().getName());
            // 如果条件成立，说明这个任务所需要计算的数值分为足够小了
            // 可以正式进行累加计算了
            if ((end - start) < THRESHOLD) {
                long sum = 0L;
                for (Long i = start; i <= end; i++) {
                    sum += i;
                }
                return sum;
                // 否则再进行任务拆分，拆分成两个任务
            } else {
                long middle = (start + end) / 2;
                ForkJoinTask<Long> left = new MyTask(start, middle).fork();
                ForkJoinTask<Long> right = new MyTask(middle + 1, end).fork();
                return left.join() + right.join();
            }
        }
    }

    public static class MyForkJoin {
        public static void main(String[] args) throws ExecutionException, InterruptedException {
            ForkJoinPool forkJoinPool = new ForkJoinPool();
            // 这是Fork/Join框架的线程池
            MyTask task = new MyTask(1L, 10_0000_0000L);
            long startTime = System.currentTimeMillis();
            Future<Long> result = forkJoinPool.submit(task);
            System.out.println(result.get());
            long endTime = System.currentTimeMillis();
            System.out.println("运行时间：" + (endTime - startTime) + "ms");
        }
    }
}
