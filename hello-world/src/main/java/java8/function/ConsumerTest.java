package java8.function;

import java.util.function.Consumer;

/**
 * @author luoan
 * @version 1.0
 * @date 2020/9/18 16:18
 **/
public class ConsumerTest {

    public static void main(String[] args) {
        ConsumerTest consumerTest = new ConsumerTest();
        // consumerTest.consumer();
        consumerTest.andThen();
    }

    /**
     * Consumer例子，泛型为参数
     */
    public void consumer(){
        Consumer<Integer> consumer = x -> {
            int a = x + 2;
            System.out.println(a);             // 12
        };
        consumer.accept(10);
    }

    /**
     * 先执行本身 accept，再执行andThen
     */
    public void andThen(){
        Consumer<Integer> consumer = x -> {
            int a = x + 2;
            System.out.println("consumer"+a);             // 12
        };
        Consumer<Integer> consumerThen = x -> {
            int a = x + 2;
            System.out.println("consumerThen"+a);             // 12
        };
        Consumer<Integer> resultConsumer = consumer.andThen(consumerThen);
        resultConsumer.accept(20);
    }


}
