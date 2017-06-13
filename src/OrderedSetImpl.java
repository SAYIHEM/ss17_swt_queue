import java.util.*;


public class OrderedSetImpl<Type> extends ArrayList<Type> implements OrderedSet<Type> {

    public OrderedSetImpl() {


    }

    public OrderedSetImpl(int initialCapacity) {

        this.ensureCapacity(initialCapacity);
    }

    public boolean add(Type t) {

        if (t == null) throw new NullPointerException("Item to add cant be NULL!");

        if (!this.contains(t)) {

            return super.add(t);

        } else {

            return false;
        }
    }

    public void add(int i, Type t) {

        if (t == null) throw new NullPointerException("Item to add cant be NULL!");
        if (i < 0) throw new IllegalArgumentException("Index to add cant be lower than 0!");

        if (!this.contains(t)) {

            super.add(i, t);
        }
    }

    public Type set(int i, Type t){

        if (t == null) throw new NullPointerException("Item to add cant be NULL!");
        if (i < 0) throw new IllegalArgumentException("Index to add cant be lower than 0!");

        if (!this.contains(t)) {

            return super.set(i, t);

        } else {

            return null;
        }
    }

    public boolean addAll(Collection<? extends Type> collection) throws UnsupportedOperationException {

        throw new UnsupportedOperationException();
    }

    public boolean addAll(int i, Collection<? extends Type> collection) throws UnsupportedOperationException {

        throw new UnsupportedOperationException();
    }
}
