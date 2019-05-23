package veci.nextpermutation;

public class Main2 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String input = "27711";
        String[] num = input.split("");
        int[] arr = new int[num.length];
        int i = 0;
        for (String s : num) {
            arr[i] = Integer.valueOf(s);
            i++;
        }
        next_permutation(arr);

        System.out.println();
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println(timeElapsed + " ms");

        System.out.printf("loop1 count: %d\n" +
                "loop2 count: %d\n" +
                "loop3 count: %d\n", loop1, loop2, loop3);
    }

    private static int loop1 = 0;
    private static int loop2 = 0;
    private static int loop3 = 0;

    static boolean next_permutation(int[] p) {
        for (int a = p.length - 2; a >= 0; --a) {
            loop1++;
            if (p[a] < p[a + 1]) {
                for (int b = p.length - 1; ; --b) {
                    loop2++;
                    if (p[b] > p[a]) {
                        int t = p[a];
                        p[a] = p[b];
                        p[b] = t;
                        for (++a, b = p.length - 1; a < b; ++a, --b) {
                            loop3++;
                            t = p[a];
                            p[a] = p[b];
                            p[b] = t;
                        }
                        for (int i : p) {
                            System.out.print(i);
                        }
                        return true;
                    }
                }
            }
        }
        System.out.print(0);
        return false;
    }
}
