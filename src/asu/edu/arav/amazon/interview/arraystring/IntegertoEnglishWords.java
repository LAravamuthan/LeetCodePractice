package asu.edu.arav.amazon.interview.arraystring;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/integer-to-english-words/
 */
public class IntegertoEnglishWords {

    public static final int BILLION = 1000000000;
    public static final int MILLION = 1000000;
    public static final int THOUSAND = 1000;
    public static final int HUNDREDS = 100;


    public String handleOnes(int i) {
        switch (i) {
            case 1:
                return "One";
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4:
                return "Four";
            case 5:
                return "Five";
            case 6:
                return "Six";
            case 7:
                return "Seven";
            case 8:
                return "Eight";
            case 9:
                return "Nine";
        }
        return "";
    }

    public String handleTwos(int i) {
        switch (i) {
            case 2:
                return "Twenty";
            case 3:
                return "Thirty";
            case 4:
                return "Forty";
            case 5:
                return "Fifty";
            case 6:
                return "Sixty";
            case 7:
                return "Seventy";
            case 8:
                return "Eighty";
            case 9:
                return "Ninety";
        }
        return "";
    }

    public String lessThanTwos(int i) {
        switch (i) {
            case 10:
                return "Ten";
            case 11:
                return "Eleven";
            case 12:
                return "Twelve";
            case 13:
                return "Thirteen";
            case 14:
                return "Fourteen";
            case 15:
                return "Fifteen";
            case 16:
                return "Sixteen";
            case 17:
                return "Seventeen";
            case 18:
                return "Eighteen";
            case 19:
                return "Nineteen";
        }
        return "";
    }


    public String two(int rest) {
        StringBuilder res = new StringBuilder();
        if (rest > 0) {
            if (rest < 10) {
                res.append(handleOnes(rest));
            } else if (rest < 20) {
                res.append(lessThanTwos(rest));
            } else {
                int tenner = rest / 10;
                res.append(handleTwos(tenner));
                res.append(" ");
                rest = rest - tenner * 10;
                if (rest > 0) {
                    res.append(handleOnes(rest));
                }
            }
        }
        return res.toString();
    }

    public String three(int i) {
        StringBuilder res = new StringBuilder();
        int hundreds = i / 100;
        if (hundreds > 0) {
            res.append(handleOnes(hundreds));
            res.append(" ");
            res.append("Hundred ");
        }
        int rest = i - hundreds * HUNDREDS;
        res.append(two(rest));
        return res.toString();
    }

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuilder sb = new StringBuilder();
        int billions = num / BILLION;
        int millions = (num - billions * BILLION) / MILLION;
        int thousands = (num - billions * BILLION - millions * MILLION) / THOUSAND;
        int rest = num - billions * BILLION - millions * MILLION - thousands * THOUSAND;
        if (billions > 0) {
            sb.append(three(billions));
            sb.append(" Billion ");
        }
        if (millions > 0) {
            sb.append(three(millions));
            sb.append(" Million ");
        }
        if (thousands > 0) {
            sb.append(three(thousands));
            sb.append(" Thousand ");
        }
        sb.append(three(rest));
        return sb.toString();
    }

    public static void main(String[] args) {
        IntegertoEnglishWords i = new IntegertoEnglishWords();
        i.numberToWords(123);
    }

}
