package lib.io;

import java.io.*;
import java.util.StringTokenizer;

public class FastReader {
    private BufferedReader br;
    private StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public FastReader(String in) {
        InputStream targetStream = convertStringToInputStream(in);
        br = new BufferedReader(new InputStreamReader(targetStream));
    }

    public FastReader(StringBuilder fileName) throws FileNotFoundException {
        br = new BufferedReader(new FileReader(String.valueOf(fileName)));
    }

    public FastReader(InputStream in) {
        br = new BufferedReader(new InputStreamReader(in));
    }

    public String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public float nextFloat() {
        return Float.parseFloat(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public InputStream convertStringToInputStream(String str) {
        InputStream targetStream = new ByteArrayInputStream(str.getBytes());
        return targetStream;
    }
}
