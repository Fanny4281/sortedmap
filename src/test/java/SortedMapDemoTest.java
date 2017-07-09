import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by joconner on 7/8/17.
 */
public class SortedMapDemoTest {

    SortedMapDemo demo = new SortedMapDemo();

    @Test
    public void testSortByValuesWhenSameValuesDiffKeys() throws Exception {
        Map<Integer, String> unsorted = createMap(new Integer[]{
                        100,
                        200,
                        300,
                        400,
                        50,
                        40},
                new String[] {
                        "John",
                        "Pete",
                        "John",
                        "Fred",
                        "Robyn",
                        "Adam"});

        Map<Integer, String> sorted = demo.sortByValues(unsorted);
        Integer[] expectedKeyOrder = new Integer[]{40, 400, 100, 300, 200, 50};
        assertArrayEquals(expectedKeyOrder, sorted.keySet().toArray());
    }


    @Test
    public void testSortByValuesWhenDiffValues() throws Exception {
        Map<Integer, String> unsorted = createMap(new Integer[]{
                        100,
                        200,
                        300,
                        400,
                        50,
                        40},
                new String[] {
                        "John",
                        "Pete",
                        "Kate",
                        "Fred",
                        "Robyn",
                        "Adam"});

        Map<Integer, String> sorted = demo.sortByValues(unsorted);
        Integer[] expectedKeyOrder = new Integer[]{40, 400, 100, 300, 200, 50};
        assertArrayEquals(expectedKeyOrder, sorted.keySet().toArray());
    }


    private HashMap<Integer, String> createMap(Integer[] keys, String[] values) {
        HashMap<Integer, String> map = new HashMap<>();
        for(int i = 0; i< keys.length; i++) {
            map.put(keys[i], values[i]);
        }
        return map;
    }

}