package java8;

import java.util.HashMap;
import java.util.Map;

/**
 * @author luoan
 * @version 1.0
 * @date 2020/9/18 17:45
 **/
public class BiConsumerTest {

    public static void main(String[] args) {
        bitConsumer();
    }

    /**
     * 其实就是二维的consumer
     */
    private static void bitConsumer() {
        Map<String, String> map = new HashMap<>();
        map.put("a", "a");
        map.put("b", "b");
        map.put("c", "c");
        map.put("d", "d");
        map.forEach((k, v) -> {
            System.out.println(k);
            System.out.println(v);
        });
    }
}
