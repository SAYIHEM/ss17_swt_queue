import java.util.LinkedList;
import java.util.List;

public class QueueImpl<Type> implements Queue<Type> {

    private List<Type> elements;

    public QueueImpl(boolean withDuplicates) {

        if (withDuplicates) {

            this.elements = new LinkedList<>();

        } else {

            this.elements = new OrderedSetImpl<>();
        }
    }

    @Override
    public boolean add(Type t) {

        if (t == null) throw new NullPointerException("Item to add cant be NULL!");

        return this.elements.add(t);
    }

    @Override
    public Type remove() {

        Type item = (!isEmpty()) ? elements.get(0) : null;

        if (item != null) {

            elements.remove(item);
            return item;

        } else {

            return null;
        }
    }

    @Override
    public Type first() {

        return (!isEmpty()) ? elements.get(0) : null;
    }

    @Override
    public boolean isEmpty() {

        return elements.isEmpty();
    }

    @Override
    public int size() {

        return elements.size();
    }
}
