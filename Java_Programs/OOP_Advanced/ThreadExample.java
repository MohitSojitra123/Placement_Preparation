
// // 2. How to Create Thread by Extending Thread
// // The basic steps are:

// // 1. Create a class
// //        ↓
// // 2. extends Thread
// //        ↓
// // 3. Override run()
// //        ↓
// // 4. Create object
// //        ↓
// // 5. Call start()




// // class MyThread extends Thread {

// //     @Override
// //     public void run() {
// //         // Task performed by thread
// //     }
// // }

// // public class Main {

// //     public static void main(String[] args) {

// //         MyThread t = new MyThread();

// //         t.start();
// //     }
// // }






// // =======================================================
// // Creating Thread by Extending Thread Class
// // =======================================================

// class MyThread extends Thread {

//     // ---------------------------------------------------
//     // run() method contains the task that the thread
//     // will execute.
//     //
//     // The JVM automatically calls run() when we call
//     // start().
//     // ---------------------------------------------------
//     @Override
//     public void run() {

//         for (int i = 1; i <= 5; i++) {

//             System.out.println(
//                 "Child Thread : " + i
//             );

//             try {

//                 // sleep() pauses the current thread
//                 // for 1000 milliseconds = 1 second
//                 Thread.sleep(1000);

//             }
//             catch (InterruptedException e) {

//                 System.out.println(
//                     "Thread Interrupted"
//                 );
//             }
//         }
//     }
// }


// // =======================================================
// // Main Class
// // =======================================================

// public class ThreadExample {

//     public static void main(String[] args) {

//         // ------------------------------------------------
//         // Creating object of MyThread
//         // ------------------------------------------------
//         MyThread t1 = new MyThread();


//         // ------------------------------------------------
//         // start() starts the new thread.
//         //
//         // JVM internally calls:
//         //
//         // t1.run()
//         //
//         // But start() creates a NEW thread.
//         // ------------------------------------------------
//         t1.start();


//         // ------------------------------------------------
//         // Main thread also continues executing.
//         // ------------------------------------------------

//         for (int i = 1; i <= 5; i++) {

//             System.out.println(
//                 "Main Thread : " + i
//             );

//             try {

//                 // Main thread sleeps for 1 second
//                 Thread.sleep(1000);

//             }
//             catch (InterruptedException e) {

//                 System.out.println(
//                     "Main Thread Interrupted"
//                 );
//             }
//         }
//     }
// }







// // Thread
// //   │
// //   ├── extends Thread
// //   │       │
// //   │       └── override run()
// //   │
// //   ├── start()
// //   │       └── starts a new thread
// //   │
// //   ├── run()
// //   │       └── contains thread task
// //   │
// //   ├── sleep()
// //   │       └── temporary pause
// //   │
// //   ├── join()
// //   │       └── wait for thread completion
// //   │
// //   ├── getName()
// //   │       └── get thread name
// //   │
// //   ├── setName()
// //   │       └── set thread name
// //   │
// //   ├── isAlive()
// //   │       └── check thread status
// //   │
// //   ├── getPriority()
// //   │       └── get priority
// //   │
// //   ├── setPriority()
// //   │       └── set priority
// //   │
// //   ├── interrupt()
// //   │       └── request interruption
// //   │
// //   └── yield()
// //           └── scheduling hint



// // | Method            | Purpose                                                              |
// // | ----------------- | -------------------------------------------------------------------- |
// // | `start()`         | Starts a new thread                                                  |
// // | `run()`           | Contains thread's task                                               |
// // | `sleep()`         | Pauses the current thread temporarily                                |
// // | `join()`          | Waits for another thread to finish                                   |
// // | `getName()`       | Gets thread name                                                     |
// // | `setName()`       | Sets thread name                                                     |
// // | `currentThread()` | Gets currently executing thread                                      |
// // | `isAlive()`       | Checks whether thread is still alive                                 |
// // | `getPriority()`   | Gets thread priority                                                 |
// // | `setPriority()`   | Sets thread priority                                                 |
// // | `interrupt()`     | Interrupts a sleeping/waiting thread                                 |
// // | `yield()`         | Suggests that current thread temporarily give other threads a chance |
