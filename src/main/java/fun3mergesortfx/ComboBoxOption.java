package fun3mergesortfx;

public class ComboBoxOption {
    private String text;
    private String compareMethodName;
    private String getMethodName;

    public ComboBoxOption(String text, String compareMethodName, String getMethodName) {
        this.text = text;
        this.compareMethodName = compareMethodName;
        this.getMethodName = getMethodName;
    }

    public String getText() {
        return text;
    }

    public String getCompareMethodName() {
        return compareMethodName;
    }

    public String getGetMethodName() {
        return getMethodName;
    }
}
