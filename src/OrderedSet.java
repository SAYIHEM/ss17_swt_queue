import java.util.*;

public interface OrderedSet<Type> extends Set<Type>, List<Type> {

    boolean add(Type t);
    void add(int i, Type t);
    Type set(int i, Type t);
    boolean addAll(Collection<? extends Type> collection);
    boolean addAll(int i, Collection<? extends Type> collection);
    Spliterator<Type> spliterator();

}
