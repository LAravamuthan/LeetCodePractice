package asu.edu.arav.amazon.interview.design;

import java.util.ArrayList;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/encode-and-decode-tinyurl/
 */
public class EncodeandDecodeTinyURL3 {
    /**
     * @algo - Encode and Decode
     * @time-complexity - O(1)
     * @space-complexity - O(1)
     */
    public static final String constantURL = "http://tinyurl.com/";
    ArrayList<String> store = new ArrayList<String>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        store.add(longUrl);
        return constantURL + (store.size() - 1);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        if (shortUrl == null || shortUrl.length() == 0) {
            return "";
        }
        return store.get(Integer.parseInt(shortUrl.replaceAll(constantURL, "")));
    }
}
