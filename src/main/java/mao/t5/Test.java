package mao.t5;

/**
 * Project name(项目名称)：java并发编程_happens_before
 * Package(包名): mao.t5
 * Class(类名): Test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/9/6
 * Time(创建时间)： 20:05
 * Version(版本): 1.0
 * Description(描述)： 线程 t1 打断 t2（interrupt）前对变量的写，对于其他线程得知 t2 被打断后对变量的读可见
 * （通过t2.interrupted 或 t2.isInterrupted）
 */

public class Test
{
    private static int x;

    public static void main(String[] args)
    {
        Thread t2 = new Thread(() ->
        {
            while (true)
            {
                if (Thread.currentThread().isInterrupted())
                {
                    System.out.println(x);
                    break;
                }
            }
        }, "t2");


        t2.start();

        new Thread(() ->
        {
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            x = 10;
            t2.interrupt();
        }, "t1").start();


        while (!t2.isInterrupted())
        {
            Thread.yield();
        }
        System.out.println(x);
    }

}
