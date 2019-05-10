import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test2 {
	
	public static String calculateScore2(String text, String prefixString, String suffixString) {
	    int m_p_c = 0, p_c = 0;
	    int m_s_c = 0, s_c = 0;
	    int r_f = 0, r_e = 0;
		int i=0; int j=0;
	    
		while(i < text.length()) {
			
			int k =i, s = -1, end = -1;
			j =0; p_c = 0;
			while(k< text.length() && j < prefixString.length() && (text.charAt(k)!= prefixString.charAt(j))) {
				j++;
			}
			while(k< text.length() && j < prefixString.length() && (text.charAt(k) == prefixString.charAt(j))) {
				if(s==-1) {
					s = k;
				}
				p_c++;
				k++;j++;
			}
			if(p_c > m_p_c) {
				m_p_c = p_c;
				r_f = s;
			}
			
			k =i; j =0; s_c = 0;
			
			while(k< text.length() && j < suffixString.length() && (text.charAt(k)!= suffixString.charAt(j))) {
				j++;
			}
			while(k< text.length() && j < suffixString.length() && (text.charAt(k) == suffixString.charAt(j))) {
				s_c++;
				k++;j++;
			}
			if(p_c > m_p_c) {
				m_p_c = p_c;
				r_f = s;
			}
				
			
		}
		
	    return null;
	   }
	
	
	static String calculateScore(String text, String prefix, String suffix) {

        int n = text.length();
        int sl = suffix.length();
        int pl = prefix.length();


        Map<String, Integer> map = new HashMap<>();

        for(int i =0; i<n; i++) {
            for(int j = i+1; j<=n; j++) {

                String sub = text.substring(i,j);

                int ps = 0, ss = 0, subL = sub.length();

                for(int k =0; k < subL; k++) {
                    if(subL - k <= sl) {
                        if(sub.substring(k).equals(suffix.substring(0,subL-k))) {
                            ps = Math.max(subL-k, ps);
                        }
                    }
                }

                for(int k =0; k < subL; k++) {
                    if(k < pl) {
                        if(sub.substring(0,k+1).equals(prefix.substring(pl-k-1, pl))) {
                            ss = Math.max(k+1,ss);
                        }
                    }
                }

                if(map.get(sub)==null) {
                    map.put(sub, ps+ss);
                } else {
                    map.put(sub, Math.max(map.get(sub), ps+ss));
                }
            }
        }
        int m = -1;
        Set<String> keys = map.keySet();

        String[] arr = keys.toArray(new String[keys.size()]);

        Arrays.sort(arr);
        String ans = null;
        for(int i = 0; i<arr.length; i++) {
            if(m < map.get(arr[i])) {
                ans = arr[i];
                m = map.get(arr[i]);
            }
        }

        return ans;
    }

}
