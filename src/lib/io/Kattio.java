package lib.io;

import java.io.*;
import java.util.StringTokenizer;

public class Kattio extends PrintWriter {
    private BufferedReader r;
    private String line;
    private StringTokenizer st;
    private String token;

    public Kattio(InputStream i) {
        super(new BufferedOutputStream(System.out));
        r = new BufferedReader(new InputStreamReader(i));
    }

    public Kattio(InputStream i, OutputStream o) {
        super(new BufferedOutputStream(o));
        r = new BufferedReader(new InputStreamReader(i));
    }

    public Kattio(String in) {
        super(new BufferedOutputStream(System.out));
        InputStream targetStream = convertStringToInputStream(in);
        r = new BufferedReader(new InputStreamReader(targetStream));
    }

    public Kattio(StringBuilder fileName) throws FileNotFoundException {
        super(new BufferedOutputStream(System.out));
        r = new BufferedReader(new FileReader(String.valueOf(fileName)));
    }

    public boolean hasMoreTokens() {
        return peekToken() != null;
    }

    public int getInt() {
        return Integer.parseInt(nextToken());
    }

    public double getDouble() {
        return Double.parseDouble(nextToken());
    }

    public long getLong() {
        return Long.parseLong(nextToken());
    }

    public String getWord() {
        return nextToken();
    }

    private String peekToken() {
        if (token == null)
            try {
                while (st == null || !st.hasMoreTokens()) {
                    line = r.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                token = st.nextToken();
            } catch (IOException e) { }
        return token;
    }

    private String nextToken() {
        String ans = peekToken();
        token = null;
        return ans;
    }

    public InputStream convertStringToInputStream(String str) {
        InputStream targetStream = new ByteArrayInputStream(str.getBytes());
        return targetStream;
    }
}
