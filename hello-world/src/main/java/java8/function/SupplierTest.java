package java8.function;

import java.util.function.Supplier;

/**
 * @author luoan
 * @version 1.0
 * @date 2020/9/18 16:48
 **/
public class SupplierTest {

    public static void main(String[] args) {
        supplier();
    }

    /**
     * get 获取一个结果
     */
    private static void supplier() {
        Supplier<String> supplier = String::new;
        System.out.println(supplier.get());
        Supplier<Emp> supplierEmp = Emp::new;
        Emp emp = supplierEmp.get();
        // 设置了name
        emp.setName("dd");
        System.out.println(emp.getName());
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

