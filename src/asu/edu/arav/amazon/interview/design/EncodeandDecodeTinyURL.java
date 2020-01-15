package asu.edu.arav.amazon.interview.design;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/encode-and-decode-tinyurl/
 */
public class EncodeandDecodeTinyURL {
    /**
     * @algo - Encode and Decode
     * @time-complexity - O(1)
     * @space-complexity - O(1)
     */

    public static final String constantURL = "http://tinyurl.com/";
    Map<Integer, String> hashToURLMap = new HashMap<Integer, String>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int hash = longUrl.hashCode();
        hashToURLMap.put(hash, longUrl);
        String res = constantURL + hash;
        return res;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        if (shortUrl == null || shortUrl.length() == 0) {
            return "";
        }
        return hashToURLMap.getOrDefault(
                Integer.parseInt(shortUrl.replaceAll(constantURL, "")), "");
    }

    public static void main(String[] args) {
        EncodeandDecodeTinyURL eadtu = new EncodeandDecodeTinyURL();
        eadtu.encode("https://leetcode.com/problems/design-tinyurl");
    }
}
