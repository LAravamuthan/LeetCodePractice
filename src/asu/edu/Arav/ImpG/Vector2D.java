package asu.edu.Arav.ImpG;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
class Vector2D {

    public int crRow = 0;
    public int crCol = 0;
    public int[][] sample;

    public Vector2D(int[][] v) {
        sample = v;
    }

    public int next() {
        int ans = Integer.MIN_VALUE;
        if (sample == null || sample.length == 0) {
            crRow++;
            return ans;
        }


        if (crRow < sample.length) {
            if (crCol < sample[crRow].length) {
                ans = sample[crRow][crCol];
            } else {
                while (!(crCol < sample[crRow].length)) {
                    if (crRow + 1 < sample.length) {
                        crRow++;
                        crCol = 0;
                    } else {
                        crRow++;
                        break;
                    }
                }
            }
        }
        if (crCol + 1 < sample[crRow].length) {
            crCol++;
        } else {
            crRow++;
            crCol = 0;
        }
        return ans;
    }

    public boolean hasNext() {
        return crRow < sample.length;
    }
}
