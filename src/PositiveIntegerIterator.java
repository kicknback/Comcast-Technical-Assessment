import java.util.*;

/*
 * Goal: Given an Iterator of type Integer, provide an Iterator<Integer> implementation
 *       that only provides non-negative values. Only implement next() and hasNext()
 *
 * Input: Iterator of type Integer
 * Output: next() should only ever return positive integers, hasNext() should only return
 *         true if there is a positive integer ahead in the underlying Iterator
 *
 * Notes:
 *      remove() does not need to be implemented
 *      testIter() is a test case that should pass
 */
public class PositiveIntegerIterator implements Iterator<Integer> {

    private List<Integer> nums;
    private Integer currPosition;


    public PositiveIntegerIterator(Iterator<Integer> i) {
        nums = new ArrayList<>();
        currPosition = 0;
        while (i.hasNext()) {
            Integer nextItem = i.next();
            if (nextItem != null && nextItem > 0) {
                nums.add(nextItem);
            }
        }
    }

    @Override
    public boolean hasNext() {
        return currPosition < nums.size();
    }

    @Override
    public Integer next() {
        if (!hasNext()) {throw new NoSuchElementException();}
        Integer currValue = nums.get(currPosition);
        currPosition++;
        return currValue;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }


}


