package org.tcup.desktop;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TcupTest {
    @Test
    public void launch_withNoUrlProvided_showsLaunchFailureWindowWithAppropriateErrorMessageAndLog() {
        ClientLauncher clientLauncher = mock(ClientLauncher.class);
        Tcup tcup = new Tcup(clientLauncher);

        tcup.launch(null);

        verify(clientLauncher).launchError("No URL provided", "The application cannot connect to the remote server because\nno server URL was provided.");
    }
}
