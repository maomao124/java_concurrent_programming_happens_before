package mao.t3;

/**
 * Project name(项目名称)：java并发编程_happens_before
 * Package(包名): mao.t3
 * Class(类名): Test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/9/6
 * Time(创建时间)： 19:52
 * Version(版本): 1.0
 * Description(描述)： 线程 start 前对变量的写，对该线程开始后对该变量的读可见
 */

public class Test
{
    static int x;

    public static void main(String[] args)
    {
        x = 10;

        new Thread(() ->
        {
            System.out.println(x);
        }, "t2").start();

    }
}
