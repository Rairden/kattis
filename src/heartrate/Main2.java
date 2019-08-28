package heartrate;

import kattio.Kattio;

public class Main2 {

    public static void main(String[] args) {
        bpm();
    }

    private static void bpm() {
        Kattio io = new Kattio(System.in, System.out);
        int n = io.getInt();

        for (int i = 0; i < n; i++) {
            int beats       = io.getInt();
            double seconds  = io.getDouble();
            double BPM      = 60 * beats / seconds;
            double diff     = 60 / seconds;

            System.out.printf("%.4f %.4f %.4f \n", (BPM - diff), BPM, (BPM + diff));
        }
        io.close();
    }
}
