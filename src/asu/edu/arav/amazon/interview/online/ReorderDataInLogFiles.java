package asu.edu.arav.amazon.interview.online;

import asu.edu.aravl.utility.Util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReorderDataInLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        String[] logList = new String[logs.length];
        List<String> temoLetterLogs = new ArrayList<String>();
        List<String> letterLogs = new ArrayList<String>();
        List<String> digiLogs = new ArrayList<String>();
        for (String log : logs) {
            String[] splitResult = log.split(" ", 2);
            if (Util.isNumericWithSpaces(splitResult[1])) {
                digiLogs.add(log);
            } else {
                temoLetterLogs.add(splitResult[1] + "%" + splitResult[0]);
            }
        }
        Collections.sort(temoLetterLogs);
        for (String log : temoLetterLogs) {
            String[] splitResult = log.split("%");
            letterLogs.add(splitResult[1] + " " + splitResult[0]);
        }
        letterLogs.addAll(digiLogs);
        digiLogs.clear();
        for (int i = 0; i < letterLogs.size(); i++) {
            logList[i] = letterLogs.get(i);
        }
        return logList;
    }
}
