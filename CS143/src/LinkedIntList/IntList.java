
public interface IntList {

    public void add(int value);

    public String toString();

    public int size();

    public int get(int index);

    public int indexOf(int value);

    public void add(int index, int value);

    public void remove(int index);

    public boolean equals(Object object);

    public void insertList(int index, LinkedIntList list);
}
