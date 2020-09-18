package java8;

import java.util.Arrays;
import java.util.Optional;

/**
 * @author luoan
 * @version 1.0
 * @date 2020/9/18 17:58
 **/
public class OptionalTest {

    /**
     * 可以包装空类型
     * @param args
     */
    public static void main(String[] args) {
        Arrays.asList("a", "b", "c");
        Emp emp = new Emp("xiaoMing", "上海", "11");
        Optional<Emp> op = Optional.ofNullable(emp);
        System.out.println(op.get().getAddress());// 上海
        // 不会报错
        Optional<Emp> op1 = Optional.ofNullable(null);
        System.out.println(op1.orElse(emp).getAddress());// 上海
        /*
         * 这里指定了一个默认对象emp，为先创建的一个emp对象，emp对象里的成员变量还没有复制，所以输出为null
         * // 注意orElseGet
         */
        System.out.println(op1.orElseGet(Emp::new).getAddress());
        try {
            // 报错。
            System.out.println(op1.orElseThrow(RuntimeException::new));// java.lang.RuntimeException
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            // 没有获取，就会直接报错。
            System.out.println(op1.get().getAddress());// java.util.NoSuchElementException
        } catch (Exception e) {
            e.printStackTrace();
        }
        String address = op.filter(obj -> obj.getAddress().equals("上海")).map(str -> str.getAddress()).get();
        System.out.println(address);// 上海

    }

    static class Emp {
        private String name;

        private String address;

        private String age;

        public Emp() {
            super();
        }

        public Emp(String name, String address, String age) {
            super();
            this.name = name;
            this.address = address;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

    }
}
