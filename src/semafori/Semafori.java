package semafori;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// https://open.kattis.com/problems/semafori

public class Semafori {

    public static void main(String[] args) {
        String in1 = """
                2 10
                3 5 5
                5 2 2
                """;
        String in2 = """
                4 30
                7 13 5
                14 4 4
                15 3 10
                25 1 1
                """;

        Scanner scan = new Scanner(in2);
        int numLights = scan.nextInt();
        int roadLength = scan.nextInt();
        int time = 0;
        List<Light> lights = new ArrayList<>();

        while (scan.hasNext()) {
            int position = scan.nextInt();
            int redLight = scan.nextInt();
            int greenLight = scan.nextInt();
            lights.add(new Light(position, redLight, greenLight));
        }

        Light lite1 = lights.get(0);
        time = lite1.pos;

        int i = 0;
        for (Light lt : lights) {
            if (i == lights.size() - 1) {
                if (!lt.isGreen(lt.iterate(time) - 1)) {
                    int diff = lt.sequence[lt.iterate(time)] - time;
                    time += diff + roadLength - lt.pos;
                    break;
                } else {
                    time += roadLength - lt.pos;
                    break;
                }
            }

            int index = lt.iterate(time);   // Check for red or green light
            if (!lt.isGreen(index)) {
                Light lite = lights.get(i + 1);
                time = time + lite.getPos() - lt.pos;
                i++;
                continue;
            }

            int diff = lt.sequence[index] - time;
            time += diff;

            Light lite = lights.get(i + 1);
            time += lite.getPos() - lt.pos;
            i++;
        }
        System.out.println(time);
    }
}

class Light {
    int pos;
    int red;
    int green;
    int[] sequence;

    public Light(int pos, int red, int green) {
        this.pos = pos;
        this.red = red;
        this.green = green;
        this.sequence = new int[6000];
        populateSequence();
    }

    void populateSequence() {
        int total = 0;
        for (int i = 1; i < 5999; i++) {
            if (i % 2 == 1) {
                sequence[i] = total += red;
            } else {
                sequence[i] = total += green;
            }
        }
    }

    boolean isGreen(int i) {
        return i % 2 == 1;
    }

    /**
     * @param time the current elapsed time
     * @return k the first index greater than curr time
     */
    int iterate(int time) {
        int k = 1;
        while (time >= sequence[k]) {
            k++;
        }
        return k;
    }

    public int getPos() {
        return pos;
    }
}
