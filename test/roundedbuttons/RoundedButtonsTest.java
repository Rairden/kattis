package roundedbuttons;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RoundedButtonsTest {

    @Test
    void calcInOut() {
        // 1 8 14 13 3 5                8 6     15 8    12 11   14 21   2.5 20
        // 2 2 13 14 4 5                4 4     4 16    13 14   3 3     3 9
        // 85.7 114.7 3.2 6.0 1.2 3     86.3 114.8   88.1 118.2   85.9 120.7

        Pair click01 = new Pair(8, 6);
        Pair click02 = new Pair(15, 8);
        Pair click03 = new Pair(12, 11);
        Pair click04 = new Pair(14, 21);
        Pair click05 = new Pair(2.5, 20);
        List<Pair> click1 = new ArrayList<>();
        List<String> result1 = new ArrayList<>();
        click1.add(click01);
        click1.add(click02);
        click1.add(click03);
        click1.add(click04);
        click1.add(click05);
        result1.add("outside");
        result1.add("outside");
        result1.add("inside");
        result1.add("outside");
        result1.add("inside");
        assertIterableEquals(result1, RoundedButtons.calcInOut(1, 8, 14, 13, 3, click1));

        Pair click06 = new Pair(4, 4);
        Pair click07 = new Pair(4, 16);
        Pair click08 = new Pair(13, 14);
        Pair click09 = new Pair(3, 3);
        Pair click10 = new Pair(3, 9);
        // for clicks 11-14 I used desmos.  click11 is desmos.com "on the line"
        Pair click11 = new Pair(5.815, 2.0043);         // dist = 3.999980436202157 --> inside
        Pair click12 = new Pair(5.815, 2.00429);        // dist = 3.999990425501041 --> inside
        Pair click13 = new Pair(5.815, 2.0042804153);   // dist = 3.999999999944393 --> inside
        Pair click14 = new Pair(5.815, 2.0042804152);   // dist = 4.0000000000442855 --> outside
        List<Pair> click2 = new ArrayList<>();
        List<String> result2 = new ArrayList<>();
        click2.add(click06);
        click2.add(click07);
        click2.add(click08);
        click2.add(click09);
        click2.add(click10);
        click2.add(click11);
        click2.add(click12);
        click2.add(click13);
        click2.add(click14);
        result2.add("inside");
        result2.add("outside");
        result2.add("inside");
        result2.add("outside");
        result2.add("inside");
        result2.add("inside");
        result2.add("inside");
        result2.add("inside");
        result2.add("outside");
        assertIterableEquals(result2, RoundedButtons.calcInOut(2, 2, 13, 14, 4, click2));

        Pair click17 = new Pair(86.3, 114.8);
        Pair click18 = new Pair(88.1, 118.2);
        Pair click19 = new Pair(85.9, 120.7);
        List<Pair> click3 = new ArrayList<>();
        List<String> result3 = new ArrayList<>();
        click3.add(click17);
        click3.add(click18);
        click3.add(click19);
        result3.add("outside");
        result3.add("inside");
        result3.add("outside");
        assertIterableEquals(result3, RoundedButtons.calcInOut(85.7, 114.7, 3.2, 6.0, 1.2, click3));
    }
}
