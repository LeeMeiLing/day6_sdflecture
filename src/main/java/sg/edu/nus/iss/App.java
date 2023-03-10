package sg.edu.nus.iss;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;


public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        
        // 1) starting thread anonymous class that implement runnable interface
        // Thread thread1 = new Thread(new Runnable(){
            
        //     @Override
        //     public void run(){
        //         for (int i = 0; i< 20; i++){
        //             System.out.println(Thread.currentThread().getName() + "\t Runnable..." + i);
        //         }
        //     }
        // });

        // thread1.start();

        // 2) starting thread using a class that implement runnable interface
        // MyRunnableImplementation mRI = new MyRunnableImplementation("task1");
        // MyRunnableImplementation mRI2 = new MyRunnableImplementation("task2");
        // MyRunnableImplementation mRI3 = new MyRunnableImplementation("task3");
        // MyRunnableImplementation mRI4 = new MyRunnableImplementation("task4");
        // MyRunnableImplementation mRI5 = new MyRunnableImplementation("task5");


        // Thread thread2 = new Thread(mRI);
        // thread2.start();

        // Thread thread3 = new Thread(mRI);
        // thread3.start();

        // 3) using single thread executor service (thread pool) to start a new thread
        // ExecutorService executorService = Executors.newSingleThreadExecutor();
        // executorService.execute(mRI); 
        // executorService.execute(mRI2); // two task running on a single thread, one task complete before another
        // executorService.shutdown(); // release resource after finishing task

        // 4) using fixed thread pool to start multiple new thread
        // ExecutorService executorService = Executors.newFixedThreadPool(3);
        // executorService.execute(mRI); 
        // executorService.execute(mRI2); 
        // executorService.execute(mRI3); 
        // executorService.execute(mRI4); // task 4 can only start after one task completed because there are only 3 threads in the thread pool
        // executorService.execute(mRI5); // task 5 can only start after another task completed because there are only 3 threads in the thread pool

        // executorService.shutdown();

        // 5) using cached thread pool, max thread depend on machine #core
        // ExecutorService executorService = Executors.newCachedThreadPool();
        // executorService.execute(mRI); 
        // executorService.execute(mRI2); 
        // executorService.execute(mRI3); 
        // executorService.execute(mRI4); 
        // executorService.execute(mRI5); 

        // executorService.shutdown(); 

        // // 6)using lambda expression to implement functional interface (only one method signature)
        // MyRunnableInterface<Integer> addOperation = (a,b) -> { return a + b; };
        // MyRunnableInterface<Integer> multiplyOperation = (a,b) -> { return a * b; };
        // MyRunnableInterface<Integer> minusOperation = (a,b) -> { return a - b; };

        // System.out.println("addOperation: " + addOperation.process(1,1));
        // System.out.println("multiplyOperation: " + multiplyOperation.process(2,5));
        // System.out.println("minusOperation: " + minusOperation.process(10,2));

        // MyRunnableInterface<String> concatString = (a,b) -> { return a + b; };
        // System.out.println("concatString: " + concatString.process("hello"," world"));
        

        // MyMessageInterface printString = (a) -> System.out.println(a);
        // printString.printMessage("Lets take a break");


        // 7) using lambda expression for .forEach() & .filter()
        // List of employees
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Adam", "Cheng", 50000));
        employees.add(new Employee(2, "Bertram", "Chong", 7000));
        employees.add(new Employee(3, "Kelvin", "Khoo", 8000));
        employees.add(new Employee(4, "Bernard", "Tan", 30000));
        employees.add(new Employee(5, "Donnie", "Yen", 50000));
        employees.add(new Employee(6, "Adam", "Cheng", 50000));

       // employees.forEach(emp -> System.out.println(emp));

        // List<Employee> filteredEmployees= employees.stream().filter(emp -> emp.getLastName().contains("Ch")).collect(Collectors.toList());
        // filteredEmployees.forEach(emp -> System.out.println(emp));

        // using lambda expression as predicates in comparator.comparing() to sort
        // employees.sort(Comparator.comparing(e -> e.getFirstName()));
        // employees.forEach(emp -> System.out.println(emp));

        // alternative way using ::
        // employees.sort(Comparator.comparing(Employee::getFirstName));
        // employees.forEach(emp -> System.out.println(emp));

        // reverse sort
        // employees.sort(Comparator.comparing(Employee::getFirstName).reversed());
        // employees.forEach(emp -> System.out.println(emp));

        // Comparator.comparing(predicate)
        Comparator<Employee> compare = Comparator.comparing(e -> e.getFirstName());
        employees.sort(compare.reversed());
        employees.forEach(emp -> System.out.println(emp));

        Comparator<Employee> groupByComparator = Comparator.comparing(Employee::getFirstName).thenComparing(Employee::getLastName);
        employees.sort(groupByComparator);
        employees.forEach(emp -> System.out.println(emp));
    
    }
}
