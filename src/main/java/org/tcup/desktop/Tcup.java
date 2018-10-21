package org.tcup.desktop;

public class Tcup {
    private final ClientLauncher clientLauncher;

    public static void main(String[] args) {
        Arguments arguments = Arguments.extract(args);
        new Tcup(new TcupClientLauncher()).launch(arguments.getRootUrl());
    }

    public Tcup(ClientLauncher clientLauncher) {
        this.clientLauncher = clientLauncher;
    }

    public void launch(String rootUrl) {
        if (rootUrl == null || rootUrl.isEmpty()) {
            clientLauncher.launchError("No URL provided", "The application cannot connect to the remote server because\nno server URL was provided."); // TODO i18n
        }
    }
}
