package temperatureconfusion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureConfusionTest {

    @Test
    void reduceFraction() {
        int[] reducedFraction = new int[2];
        reducedFraction[0] = -335;
        reducedFraction[1] = 18;
        assertArrayEquals(reducedFraction, TemperatureConfusion.reduceFraction(-670, 36));
        reducedFraction[0] = -40;
        reducedFraction[1] = 1;
        assertArrayEquals(reducedFraction, TemperatureConfusion.reduceFraction(-360, 9));
        reducedFraction[0] = -620;
        reducedFraction[1] = 27;
        assertArrayEquals(reducedFraction, TemperatureConfusion.reduceFraction(-1860, 81));
        reducedFraction[0] = 0;
        reducedFraction[1] = 1;
        assertArrayEquals(reducedFraction, TemperatureConfusion.reduceFraction(0, 81));
    }
}
