import static org.junit.Assert.*;

public class LC347Test {

    @org.junit.Test
    public void topKFrequent() {

        int[] actual = LC347.topKFrequent(new int[] {1,1,1,2,2,3}, 2);
        int[] actual2 = LC347.topKFrequent(new int[] {1}, 1);

        assertArrayEquals(new int[] {1,2}, actual);
        assertArrayEquals(new int[] {1}, actual2);
    }
}