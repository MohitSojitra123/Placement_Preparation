// // implements Runnable
// //        ↓
// // class MyTask implements Runnable

// // class MyTask implements Runnable {

// //     @Override
// //     public void run() {

// //         // Thread task
// //     }
// // }

// // public class Test {

// //     public static void main(String[] args) {

// //         MyTask task = new MyTask();

// //         Thread t1 = new Thread(task);

// //         t1.start();
// //     }
// // }


// // MyTask task = new MyTask();

// // Thread t1 = new Thread(task);

// // t1.start();



// // =======================================================
// // Creating Thread using Runnable Interface
// // =======================================================


// // -------------------------------------------------------
// // Step 1: Create a class that implements Runnable
// // -------------------------------------------------------

// class MyTask implements Runnable {


//     // ---------------------------------------------------
//     // Step 2: Override run() method
//     //
//     // run() contains the task that the thread will
//     // execute.
//     // ---------------------------------------------------

//     @Override
//     public void run() {

//         // Get the currently executing thread
//         Thread currentThread = Thread.currentThread();


//         // Print thread name
//         System.out.println(
//             "Thread Name : " +
//             currentThread.getName()
//         );


//         // ------------------------------------------------
//         // Thread Task
//         // ------------------------------------------------

//         for (int i = 1; i <= 5; i++) {

//             System.out.println(
//                 currentThread.getName() +
//                 " : " + i
//             );


//             try {

//                 // Pause current thread for 1 second
//                 Thread.sleep(1000);

//             }
//             catch (InterruptedException e) {

//                 System.out.println(
//                     "Thread Interrupted"
//                 );

//                 // Restore interrupted status
//                 currentThread.interrupt();

//                 break;
//             }
//         }
//     }
// }


// // =======================================================
// // Main Class
// // =======================================================

// public class RunnableExample {

//     public static void main(String[] args) {


//         // ------------------------------------------------
//         // main() itself runs inside the Main Thread
//         // ------------------------------------------------

//         System.out.println(
//             "Main Thread : " +
//             Thread.currentThread().getName()
//         );


//         // ------------------------------------------------
//         // Step 3: Create object of MyTask
//         // ------------------------------------------------

//         MyTask task = new MyTask();


//         // ------------------------------------------------
//         // Step 4: Create Thread object
//         //
//         // Pass Runnable object to Thread constructor.
//         // ------------------------------------------------

//         Thread t1 = new Thread(task);


//         // ------------------------------------------------
//         // Step 5: Give thread a name
//         // ------------------------------------------------

//         t1.setName("My Runnable Thread");


//         // ------------------------------------------------
//         // Step 6: Start the thread
//         //
//         // start() creates a new thread and then causes
//         // run() to execute on that new thread.
//         // ------------------------------------------------

//         t1.start();


//         // ------------------------------------------------
//         // Main Thread continues its own work
//         // ------------------------------------------------

//         for (int i = 1; i <= 5; i++) {

//             System.out.println(
//                 "Main Thread : " + i
//             );


//             try {

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


//         //          MyTask
//         //            |
//         //            | implements
//         //            ↓
//         //         Runnable
//         //            |
//         //            | run()
//         //            ↓
//         //     ----------------
//         //     |              |
//         //  Task/Work       Thread
//         //                    |
//         //                    | start()
//         //                    ↓
//         //                New Thread
//         //                    |
//         //                    ↓
//         //                  run()