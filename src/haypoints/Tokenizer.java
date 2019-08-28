package haypoints;

public class Tokenizer {
    static Tokenizer tokenizer = null;
    StringBuilder stringBuilder;

    private Tokenizer() {
        stringBuilder = new StringBuilder();
    }

    static Tokenizer getInstance() {
        if (tokenizer == null) {
            tokenizer = new Tokenizer();
        }
        return tokenizer;
    }
}
