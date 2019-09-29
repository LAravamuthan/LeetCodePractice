package asu.edu.aravl.utility;

import java.util.Objects;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class TwoPoint {
    public int r1;
    public int r2;
    public int c1;
    public int c2;
    public TwoPoint(int r1, int r2, int c1, int c2) {
        this.r1 = r1;
        this.r2 = r2;
        this.c1 = c1;
        this.c2 = c2;
    }
    public TwoPoint(int[][] point) {
        this.r1 = point[0][0];
        this.r2 = point[1][0];
        this.c1 = point[0][1];
        this.c2 = point[1][1];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TwoPoint twoPoint = (TwoPoint) o;
        return r1 == twoPoint.r1 &&
                r2 == twoPoint.r2 &&
                c1 == twoPoint.c1 &&
                c2 == twoPoint.c2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(r1, r2, c1, c2);
    }
}
