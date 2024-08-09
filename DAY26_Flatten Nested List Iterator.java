// You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements may also be integers or other lists. Implement an iterator to flatten it.
public class NestedIterator implements Iterator<Integer> {
    ArrayDeque<Integer> q = new ArrayDeque<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        pushAll(nestedList);
    }

    @Override
    public Integer next() {
        return q.removeFirst();
    }

    @Override
    public boolean hasNext() {
        return !q.isEmpty();
    }

    private void pushAll(List<NestedInteger> list) {
        for (NestedInteger ni : list) {
            if (ni.isInteger()) {
                q.addLast(ni.getInteger());
            } else {
                pushAll(ni.getList());
            }
        }
    }
}
