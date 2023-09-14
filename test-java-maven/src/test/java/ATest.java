import org.example.stream.Caller;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * 测试并行流是否可以加快map收集
 * 测试结果：看上去不能加快，消耗的时间几乎一样
 *
 * parallel stream cost time: 8ms, data size is 100
 * parallel stream cost time: 4ms, data size is 200
 * parallel stream cost time: 5ms, data size is 300
 * parallel stream cost time: 7ms, data size is 500
 * parallel stream cost time: 11ms, data size is 800
 * parallel stream cost time: 13ms, data size is 1000
 * parallel stream cost time: 23ms, data size is 2000
 * parallel stream cost time: 58ms, data size is 5000
 * parallel stream cost time: 114ms, data size is 10000
 * parallel stream cost time: 288ms, data size is 20000
 * parallel stream cost time: 611ms, data size is 50000
 * parallel stream cost time: 1204ms, data size is 100000
 *
 * stream cost time: 4ms, data size is 100
 * stream cost time: 2ms, data size is 200
 * stream cost time: 4ms, data size is 300
 * stream cost time: 6ms, data size is 500
 * stream cost time: 8ms, data size is 800
 * stream cost time: 23ms, data size is 1000
 * stream cost time: 23ms, data size is 2000
 * stream cost time: 59ms, data size is 5000
 * stream cost time: 137ms, data size is 10000
 * stream cost time: 215ms, data size is 20000
 * stream cost time: 612ms, data size is 50000
 * stream cost time: 1217ms, data size is 100000
 *
 * 进程已结束，退出代码为 0
 */
public class ATest {
    @ParameterizedTest
    @CsvSource({"100", "200", "300", "500", "800", "1000", "2000", "5000", "10000", "20000", "50000", "100000"})
    public void testStream(int size) {
        long start = System.currentTimeMillis();
        Caller.callStream(size);
        long end = System.currentTimeMillis();
        System.out.println("stream cost time: " + (end-start)+"ms, data size is "+size);
    }
    @ParameterizedTest
    @CsvSource({"100", "200", "300", "500", "800", "1000", "2000", "5000", "10000", "20000", "50000", "100000"})
    public void testPStream(int size) {
        long start = System.currentTimeMillis();
        Caller.callStream(size);
        long end = System.currentTimeMillis();
        System.out.println("parallel stream cost time: " + (end-start)+"ms, data size is "+size);
    }
}

