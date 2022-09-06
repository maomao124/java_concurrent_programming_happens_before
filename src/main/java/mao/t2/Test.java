package mao.t2;

/**
 * Project name(项目名称)：java并发编程_happens_before
 * Package(包名): mao.t2
 * Class(类名): Test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/9/6
 * Time(创建时间)： 19:49
 * Version(版本): 1.0
 * Description(描述)： 线程对 volatile 变量的写，对接下来其它线程对该变量的读可见
 */

public class Test
{
    private volatile static int x;

    public static void main(String[] args)
    {

        new Thread(() ->
        {
            x = 10;
        }, "t1").start();


        new Thread(() ->
        {
            System.out.println(x);
        }, "t2").start();
    }
}
