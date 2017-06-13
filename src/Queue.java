public interface Queue<Type> {

    boolean add(Type t);
    Type remove();
    Type first();
    boolean isEmpty();
    int size();
}
