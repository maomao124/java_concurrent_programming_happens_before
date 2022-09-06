package mao.t6;

/**
 * Project name(项目名称)：java并发编程_happens_before
 * Package(包名): mao.t6
 * Class(类名): Test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/9/6
 * Time(创建时间)： 20:10
 * Version(版本): 1.0
 * Description(描述)： 具有传递性
 */

public class Test
{
    volatile static int x;
    static int y;

    public static void main(String[] args)
    {
        new Thread(() ->
        {
            y = 10;
            x = 20;
            //写屏障，写屏障保证在该屏障之前的，对共享变量的改动，都同步到主存当中
            //y在写屏障之前
        }, "t1").start();


        new Thread(() ->
        {
            // x=20 对 t2 可见, 同时 y=10 也对 t2 可见
            System.out.println(x);
        }, "t2").start();
    }

}
