using System;
using System.Collections.Generic;

class Program
{
    static Queue<string> tasks = new Queue<string>();

    static void Main(string[] args)
    {
        tasks.Enqueue("Task 1");
        tasks.Enqueue("Task 2");
        tasks.Enqueue("Task 3");
        tasks.Enqueue("Task 4");
        tasks.Enqueue("Task 5");

        Console.ReadLine();
    }
}