package sg.edu.nus.iss;

@FunctionalInterface
public interface MyRunnableInterface<T>{
    
    // void printMessage(T a);
    T process(T a, T b); // function signature; no implementation

}
