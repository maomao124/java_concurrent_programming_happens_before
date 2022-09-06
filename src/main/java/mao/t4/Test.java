package mao.t4;

/**
 * Project name(项目名称)：java并发编程_happens_before
 * Package(包名): mao.t4
 * Class(类名): Test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/9/6
 * Time(创建时间)： 19:59
 * Version(版本): 1.0
 * Description(描述)： 线程结束前对变量的写，对其它线程得知它结束后的读可见（比如其它线程调用 t1.isAlive() 或 t1.join()等待它结束）
 */

public class Test
{
    private static int x;

    public static void main(String[] args) throws InterruptedException
    {
        Thread t1 = new Thread(() ->
        {
            x = 10;

        }, "t1");
        t1.start();

        t1.join();
        System.out.println(x);

    }

}
