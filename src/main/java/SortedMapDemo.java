import java.text.Collator;
import java.util.*;

/**
 * Demonstrates how to sort a Map by values and then by keys.
 *
 * @author joconner
 *
 */
public class SortedMapDemo {


    /**
     * Given an unsorted map, return a map that will return entries in a sorted order when
     * iterated over the keyset; order is sorted first by values, then keys when values are equal.
     *
     * @param unsortedMap
     * @param collator    that understands correct language-based sort rules for a target
     *                    locale.
     * @return sorted map by values first, then keys
     */
    public Map<Integer, String> sortByValues(Map<Integer, String> unsortedMap, Collator collator) {

        TreeMap<Integer, String> sortedMap = new TreeMap<>((key1, key2) -> {
            String value1 = unsortedMap.get(key1);
            String value2 = unsortedMap.get(key2);

            int compared = collator.compare(value1, value2);
            if (compared == 0) {
                compared = key1.compareTo(key2);
            }
            return compared;
        });

        unsortedMap.forEach((key, value) -> {
            sortedMap.put(key, value);
        });

        return sortedMap;

    }


    /**
     * Given an unsorted map, return a map that will return entries in a sorted order when
     * iterated over the keyset; order is sorted first by values, then keys when values are equal.
     *
     * The default linguistic collator is US English.
     *
     * @param unsortedMap
     * @return sorted map by values first, then keys
     */
    public Map<Integer, String> sortByValues(Map<Integer, String> unsortedMap) {
        Collator defaultCollator = Collator.getInstance(Locale.US);
        return sortByValues(unsortedMap, defaultCollator);

    }
}
