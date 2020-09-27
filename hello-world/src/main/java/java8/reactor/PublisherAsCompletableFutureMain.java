package java8.reactor;

import static org.junit.Assert.assertEquals;
import static reactor.core.publisher.Flux.range;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author luoan
 * @version 1.0
 * @date 2020/9/27 13:25
 **/
public class PublisherAsCompletableFutureMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 其实Flux 就是发送0个或者多个事件通知
        // Supplier 就是存储结果
        CompletableFuture<ArrayList<Integer>> completableFuture = new PublisherAsCompletableFuture<>(
            range(0, 10),
            ArrayList::new,
            (i, list) -> {
                list.add(i);
                return list;
            }
        );

        ArrayList<Integer> integers = completableFuture.get();

        assertEquals(integers, Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        System.out.println("success");
    }
}
