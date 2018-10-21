package org.tcup.desktop;

public class TcupClientLauncher implements ClientLauncher {
    @Override
    public void launchError(String errorTitle, String errorMessage) {
        FailedClient.prepare(errorTitle, errorMessage);
        FailedClient.main(new String[] {});
    }
}
