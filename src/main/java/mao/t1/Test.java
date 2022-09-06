package mao.t1;

/**
 * Project name(项目名称)：java并发编程_happens_before
 * Package(包名): mao.t1
 * Class(类名): Test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/9/6
 * Time(创建时间)： 19:46
 * Version(版本): 1.0
 * Description(描述)： 线程解锁 m 之前对变量的写，对于接下来对 m 加锁的其它线程对该变量的读可见
 */

public class Test
{
    private static int x;
    private static final Object m = new Object();

    public static void main(String[] args)
    {
        new Thread(() ->
        {
            synchronized (m)
            {
                x = 10;
            }
        }, "t1").start();

        new Thread(() ->
        {
            synchronized (m)
            {
                System.out.println(x);
            }
        }, "t2").start();
    }
}
