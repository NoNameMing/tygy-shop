package com.neuedu.shop.common;

public class OrderUtil {

    // 平台标识码
    private static final String SHOP_NAME = "GSPT";

    // 生成订单方式
    public static String generateOrder() {
        /*
        * https://blog.csdn.net/simplemurrina/article/details/60574815
        * 讲解：
            * 参数System.currentTimeMillis():这是java里面的获取1970年到目前的毫秒数,是一个13位数的数字，与Date.getTime()函数的结果一样，
            * 比如1378049585093。经过研究，在2013年，前三位是137，在2023年是168，到2033年才199.所以，我决定第一位数字1可以去掉，不要占位置了。
            * 可以肯定绝大多数系统用不了10年20年。这样，参数2就变成了12位数的数字，加上参数1machineId才13位数。
            * 参数System.nanoTime()：这是java里面的取纳秒数，经过深入研究，在同一毫秒内，位置7,8,9这三个数字是会变化的。
            * 所以决定截取这三个数字出来拼接成一个16位数的订单号。
         * 总结：
            * 理论上此方案在同一秒内，可以应对1000*1000个订单号，但是经过测试，在每秒并发2000的时候，还是会出现2-10个重复。
        * */
        String orderId =
                SHOP_NAME +
                        (System.currentTimeMillis() + "").substring(1) +
                        (System.nanoTime() + "").substring(7, 10);
        return orderId;
    }

    // 测试输出订单
    public static void main(String[] args) {
        System.out.println(OrderUtil.generateOrder());
    }
}
