package comparator;


import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class NaturalOrderComparatorTest {

    private final Comparator<String> comparator = NaturalOrderComparator.naturalOrder();

    @Test
    public void testOne() {
        List<String> sortable = Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");
        sortable.sort(comparator);
        List<String> expected = Arrays.asList("eight", "five", "four", "nine", "one", "seven", "six", "ten", "three", "two");
        Assert.assertEquals(expected, sortable);
    }

    @Test
    public void testTwo() {
        List<String> sortable = Arrays.asList("a1", "a10", "a2", "a01", "1", "a0");
        sortable.sort(comparator);
        List<String> expected = Arrays.asList("1", "a0", "a01", "a1", "a2", "a10");
        Assert.assertEquals(expected, sortable);
    }

    @Test
    public void testThree() {
        List<String> sortable = Arrays.asList("0.2", "0.10", "1.3", "4.5", "0.222", "0.873");
        sortable.sort(comparator);
        List<String> expected = Arrays.asList("0.10", "0.2", "0.222", "0.873", "1.3", "4.5");
        Assert.assertEquals(expected, sortable);
    }

    @Test
    public void testFour() {
        List<String> sortable = Arrays.asList("0.2.1", "0.20.0", "1.3.4", "3.5.5", "0.1.1", "0.1.4", "0.13.4");
        sortable.sort(comparator);
        List<String> expected = Arrays.asList("0.1.1", "0.1.4", "0.2.1", "0.13.4", "0.20.0", "1.3.4", "3.5.5");
        Assert.assertEquals(expected, sortable);
    }

    @Test
    public void testFive() {
        List<String> sortable = Arrays.asList("100", "1,000,000", "4,000,000", "4,000", "5,345,456", "1,000", "2,000.00");
        sortable.sort(comparator);
        List<String> expected = Arrays.asList("100", "1,000","2,000.00", "4,000", "1,000,000", "4,000,000", "5,345,456");
        Assert.assertEquals(expected, sortable);
    }

    @Test
    public void testSix() {
        List<String> sortable = Arrays.asList("00b","0000", "000a", "003", "002", "001", "000A", "000");
        sortable.sort(comparator);
        List<String> expected = Arrays.asList("000", "0000", "000a", "000A", "00b", "001", "002", "003");
        Assert.assertEquals(expected, sortable);
    }

    @Test
    public void testSeven() {
        List<String> sortable = Arrays.asList("apple", "Apple","Orange","orange", "Pear","pear");
        sortable.sort(comparator);
        List<String> expected = Arrays.asList("apple", "Apple", "orange", "Orange", "pear", "Pear");
        Assert.assertEquals(expected, sortable);
    }

    @Test
    public void testEight() {
        List<String> sortable = Arrays.asList("£apple","Orange","orange", "0Pear","01pear", "$apple001", "$apple002", "$apple010");
        sortable.sort(comparator);
        List<String> expected = Arrays.asList("0Pear", "01pear", "$apple001", "$apple002", "$apple010", "£apple", "orange", "Orange");
        Assert.assertEquals(expected, sortable);
    }
}