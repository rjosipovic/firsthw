package home.playground.common;

public class StringConcatenator {

    private static final char DEFAULT_DELIMITER = ' ';
    private static final int DEFAULT_ARRAY_SIZE = 50;
    private static final int EXTENSION_COUNT = 50;

    private char delimiter;
    private String[] stringArray;
    private int currentIndex;

    public StringConcatenator() {
        this(DEFAULT_DELIMITER);
    }

    public StringConcatenator(char delimiter) {
        this.delimiter = delimiter;
        this.currentIndex = 0;
        stringArray = new String[DEFAULT_ARRAY_SIZE];
    }

    private boolean hasSpace() {
        return currentIndex < stringArray.length;
    }

    private void extendArray() {
        String[] extended = new String[this.stringArray.length + EXTENSION_COUNT];
        copyArray(this.stringArray, extended);
        this.stringArray = extended;
    }

    private void copyArray(String[] src, String[] dst) {
        for(int i = 0; i < src.length; i++) {
            dst[i] = src[i];
        }
    }

    public void add(String str) {
        if(hasSpace()) {
            stringArray[currentIndex++] = str;
        } else {
            extendArray();
            add(str);
        }
    }

    @Override
    public String toString() {
        String str = "";
        for(int i = 0; i < currentIndex; i++) {
            str += stringArray[i];
            if(i < currentIndex - 1) {
                str += delimiter;
            }
        }
        return str;
    }
}
