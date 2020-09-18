package java8;

import java.util.function.UnaryOperator;

/**
 * @author luoan
 * @version 1.0
 * @date 2020/9/18 16:56
 **/
public class UnaryOperatorTest {

    public static void main(String[] args) {
        myIdentity();
    }

    /**
     * Unary 一元的
     * identity 方法，就是返回输入的参数
     * 传入泛型T类型的参数，调用apply后，返回也T类型的参数；这个接口定义了一个静态方法，返回泛型对象的本身；
     * identity 并不是一个抽象方法
     */
    private static void myIdentity() {
        // 子类接收。x->x+1 作为参数给父类
        UnaryOperator<Integer> dda = x -> x + 1;
        System.out.println(dda.apply(10));
        UnaryOperator<String> ddb = x -> x + 1;
        System.out.println(ddb.apply("aa"));
    }


}
