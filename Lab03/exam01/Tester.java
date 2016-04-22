package exam01;

public class Tester {
    public static void print(Object exp, Object rec) {
        System.out.println(exp + " =? " + rec);
    }

    public static void testSet() {
        IntersectionSet s = new IntersectionSet(new int[]{1, 2, 3});
        print(true, s.contains(1));
        print(true, s.contains(2));
        print(true, s.contains(3));
        print(false, s.contains(4));
        IntersectionSet s2 = new IntersectionSet(new int[]{4, 5, 6, 7});
        print(false, s.contains(4));
        print(4, s2.size());

        s.intersect(s2);
        print(0, s.size());
        print(false, s.contains(1));
        print(false, s.contains(2));
        print(false, s.contains(3));
        print(false, s.contains(4));
        print(true, s2.contains(4));
        print(true, s2.contains(5));
        print(true, s2.contains(5));
        print(true, s2.contains(7));
        print(false, s2.contains(2));

        IntersectionSet s3 = new IntersectionSet(new int[]{4, 1, 6, 7, 8, 9});
        s3.intersect(s2);
        print(true, s2.contains(4));
        print(true, s2.contains(5));
        print(true, s2.contains(5));
        print(true, s2.contains(7));
        print(3, s3.size());
        print(true, s3.contains(4));
        print(false, s3.contains(1));
        print(true, s3.contains(6));
        print(true, s3.contains(7));
        print(false, s3.contains(8));
        print(false, s3.contains(9));

        IntersectionSet s4 = new IntersectionSet(new int[]{7, 6, 4});
        print(false, s3.wouldModify(s4));
        print(false, s3.wouldModify(s2));
    }

    public static void testUtils() {
        int[] a = {1, 2, 3, 3, 2, 5, 4, 5, 5, 4};
        print(3, ArrayUtils.countMax(a));
        int[] b = {1, 2, 4, 2, 3, 5, 1, 7};
        int[] bexp = {7, 1, 5, 3, 2, 4, 2, 1};
        int[] bp = ArrayUtils.reverse(b);
        print(true, bp.length == bexp.length);
        for (int i = 0; i < b.length; ++i) {
            print(bexp[i], bp[i]);
        }
        int[] c = {1, 4, 3, 2, 5};
        int[] cp = ArrayUtils.intersperse(c, 99);
        for (int i = 0; i < cp.length; ++i) {
            if (i % 2 == 0) {
                print(c[i/2], cp[i]);
            } else {
                print(99, cp[i]);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Testing IntersectionSet...");
        testSet();
        System.out.println("--------------------");
        System.out.println("Testing ArrayUtils...");
        testUtils();
    }
}
