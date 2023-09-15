package frequency;

import java.util.HashMap;
import java.util.Map;

/**
 * Type Analytics.
 */
public class Analytics {
  private static int count;

  /**
   * Word frequency map.
   *
   * @param message the message
   * @return the map
   */
  public static Map<String, Double> wordFrequency(String message) {
    if (message == null || message.equals("")) {
      return null;
    }
    message = message.replaceAll("\\p{Punct}", "");
    String[] words = message.toUpperCase().split("\\p{Blank}");

    Map<String, Double> map = new HashMap<>();
    count = words.length;
    for (String word : words) {
      if (map.containsKey(word)) {
        Double val = map.get(word) + 1;
        map.put(word,val);
      }
      else {
        map.put(word, 1.0);
      }
    }
    map.forEach((k,v) -> map.put(k, v / count));
    return map;
  }
}
