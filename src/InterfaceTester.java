import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class InterfaceTester {

    public static void main(String[] args) {
        Iterator<Integer> intIter = Arrays.asList(new Integer[] {null, -1, 2, null, 15, -4, 50, null}).iterator();
        Iterator<Integer> iter = new PositiveIntegerIterator(intIter);

        try {
            //multiple hasNext() calls succeed
            for (int i = 0; i < 100; i++) {
                System.out.println(iter.hasNext());
            }
            //values are correct
            System.out.println(iter.hasNext());
            System.out.println(iter.next() == 2);
            //no hasNext() call...
            System.out.println(iter.next() == 15);
            System.out.println(iter.hasNext());
            System.out.println(iter.next() == 50);
            System.out.println(iter.hasNext() == false);
        }catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }catch (Exception e) {
            System.out.println("Caught general exception:");
            System.out.println(e.getMessage());
        }

    }

}
