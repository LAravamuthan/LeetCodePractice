package asu.edu.arav.amazon.interview.design;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/encode-and-decode-tinyurl/
 */
public class EncodeandDecodeTinyURL2 {

    /**
     * @algo - Encode and Decode
     * @time-complexity - O(1)
     * @space-complexity - O(1)
     */

    public static final String constantURL = "http://tinyurl.com/";
    Map<Integer, String> hashToURLMap = new HashMap<Integer, String>();
    Random r = new Random();
    int key = r.nextInt(Integer.MAX_VALUE);

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        while (hashToURLMap.containsKey(key)) {
            key = r.nextInt(Integer.MAX_VALUE);
        }
        hashToURLMap.put(key, longUrl);
        return constantURL + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        if (shortUrl == null || shortUrl.length() == 0) {
            return "";
        }
        return hashToURLMap.getOrDefault(
                Integer.parseInt(shortUrl.replaceAll(constantURL, "")), "");
    }
}
