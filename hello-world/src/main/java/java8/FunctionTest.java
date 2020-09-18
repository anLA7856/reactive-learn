package java8;

import java.util.function.Function;

/**
 * @author luoan
 * @version 1.0
 * @date 2020/9/18 17:00
 **/
public class FunctionTest {

    /**
     * 主要就是看Function里面的apply方法。所谓apply，就是传入一个id
     * @param args
     */
    public static void main(String[] args) {
        Function<Integer, Integer> function1 = x -> x * 2;
        System.out.println(function1.apply(4));

        Function<Integer, String> function2 = x -> x * 2 + "dd";
        System.out.println(function2.apply(4));

        Function<String, String> strFunction1 = (str) -> new String(str);
        System.out.println(strFunction1.apply("aa"));

        Function<String, String> strFunction2 = String::new;
        System.out.println(strFunction2.apply("bb"));

        Function<String, Emp> objFunction1 = (str) -> new Emp(str);
        System.out.println(objFunction1.apply("cc").getName());

        Function<String, Emp> objFunction2 = Emp::new;
        System.out.println(objFunction2.apply("dd").getName());
    }


    static class Emp {
        private String name = "supplier";

        public Emp() {

        }

        public Emp(String name) {
            super();
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Emp{" +
                "name='" + name + '\'' +
                '}';
        }
    }
}
