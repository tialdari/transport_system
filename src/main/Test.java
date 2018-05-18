package main;

import java.util.*;

public class Test {
  public static void main(String[] args) {
    Map<ArrayList<String>, Integer > unsortedMap = new HashMap<>();
    unsortedMap.put(new ArrayList<String>(Arrays.asList("a", "b", "c")), 12);
    unsortedMap.put(new ArrayList<String>(Arrays.asList("c", "d")), 5);
    unsortedMap.put(new ArrayList<String>(Arrays.asList("g", "b", "c", "k")), 3);

    List<Map.Entry<ArrayList<String>, Integer>>list = 
        new ArrayList<>(unsortedMap.entrySet());
    Collections.sort(list, new EntryComparator());

    for (Map.Entry<ArrayList<String>, Integer> entry : list) {
      System.out.println(entry.getKey());
    }
  }

  private static class EntryComparator
      implements Comparator<Map.Entry<ArrayList<String>, Integer>>
  {
    public int compare(Map.Entry<ArrayList<String>, Integer> left,
        Map.Entry<ArrayList<String>, Integer> right) {     
      // Right then left to get a descending order
      return Integer.compare(right.getKey().size(), left.getKey().size());
    }
  }
}
