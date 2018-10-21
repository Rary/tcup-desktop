package org.tcup.desktop;

public class Arguments {
    private static final int MAX_ROOT_URL_LENGTH = 2048;

    public static Arguments extract(String[] args) {
        if (args == null) {
            throw new NullPointerException();
        }
        switch (args.length) {
            case 1:
                return new Arguments(args[0].endsWith("/") ? args[0] : String.format("%s/", args[0]));
            default:
                return new Arguments(null);
        }
    }

    private final String rootUrl;

    public Arguments(String rootUrl) {
        this.rootUrl = lengthLimitedValue(rootUrl, MAX_ROOT_URL_LENGTH);
    }

    public String getRootUrl() {
        return rootUrl;
    }

    private String lengthLimitedValue(String value, int maxLength) {
        return (value != null && value.length() > maxLength) ? value.substring(0, maxLength) : value;
    }
}
