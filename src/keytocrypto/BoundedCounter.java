package keytocrypto;

public class BoundedCounter {
    private int value;
    private int upperLimit;

    public BoundedCounter(int upperLimit) {
        this.upperLimit = upperLimit;
    }

    public void prev() {
        if (value == 0) {
            value = upperLimit;
            return;
        }
        if (value > 0) {
            value--;
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int x) {
        if (x >= 0 && x <= upperLimit) {
            this.value = x;
        }
    }

    public String toString() {
        return "" + value;
    }
}
