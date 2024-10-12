Here is a simple console application in C# that simulates a task scheduler with cooldown intervals. This application uses a Queue to manage tasks and a Timer to manage cooldown intervals.

```C#
using System;
using System.Collections.Generic;
using System.Timers;

class Program
{
    static Queue<string> tasks = new Queue<string>();
    static Timer timer;
    static int cooldown = 2000;

    static void Main(string[] args)
    {
        tasks.Enqueue("Task 1");
        tasks.Enqueue("Task 2");
        tasks.Enqueue("Task 3");
        tasks.Enqueue("Task 4");
        tasks.Enqueue("Task 5");

        timer = new Timer(cooldown);
        timer.Elapsed += ExecuteTask;
        timer.Start();

        Console.ReadLine();
    }

    static void ExecuteTask(object sender, ElapsedEventArgs e)
    {
        if (tasks.Count > 0)
        {
            string task = tasks.Dequeue();
            Console.WriteLine($"{DateTime.Now}: {task} executed");
        }
        else
        {
            timer.Stop();
            Console.WriteLine("All tasks executed");
        }
    }
}
```

In this application, we first enqueue some tasks into a Queue. We then start a Timer with a cooldown interval. When the Timer elapses, we execute the next task in the Queue. If there are no more tasks in the Queue, we stop the Timer.