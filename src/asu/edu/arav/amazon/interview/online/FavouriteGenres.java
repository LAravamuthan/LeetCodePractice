package asu.edu.arav.amazon.interview.online;

import java.util.*;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class FavouriteGenres {
    public Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
        Map<String, List<String>> ansUserToGenreMap = new HashMap<String, List<String>>();
        Map<String, Set<String>> songToGenreMap = new HashMap<String, Set<String>>();
        Map<String, Map<String, Integer>> userToGenreCount = new HashMap<String, Map<String, Integer>>();
        for (String genre : genreMap.keySet()) {
            for (String song : genreMap.get(genre)) {
                Set<String> songSet = songToGenreMap.getOrDefault(song, new HashSet<String>());
                songSet.add(genre);
                songToGenreMap.put(song, songSet);
            }
        }
        for (String user : userMap.keySet()) {
            for (String song : userMap.get(user)) {
                for(String genre : songToGenreMap.get(song)){
                    if (!userToGenreCount.containsKey(user)) {
                        Map<String, Integer> genreToCount = new HashMap<String, Integer>();
                        genreToCount.put(genre, genreToCount.getOrDefault(genre, 0) + 1);
                    }
                }
            }
        }
        for(String user : userMap.keySet()){
            int max = 0;
            List<String> favouriteGenres  = new ArrayList<String>();
            ansUserToGenreMap.put(user, favouriteGenres);
            for(String genre : userToGenreCount.get(user).keySet()){
                if(max == 0){
                    max = userToGenreCount.get(user).get(genre);
                    favouriteGenres.add(genre);
                }else if(userToGenreCount.get(user).get(genre) > max){
                    max = userToGenreCount.get(user).get(genre);
                    favouriteGenres.clear();
                    favouriteGenres.add(genre);
                }else if(userToGenreCount.get(user).get(genre) == max){
                    favouriteGenres.add(genre);
                }
            }
            ansUserToGenreMap.put(user, favouriteGenres);
        }
        return ansUserToGenreMap;
    }
}
