package org.tcup.desktop;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FailedClientTest {
    @Test
    public void prepare_whenNoTitleProvided_usesDefaultTitle() {
        FailedClient.prepare(null, "MESSAGE");

        assertThat(FailedClient.getTitle()).isEqualTo("Error");
    }

    @Test
    public void prepare_whenTitleProvided_usesProvidedTitle() {
        FailedClient.prepare("TITLE", "MESSAGE");

        assertThat(FailedClient.getTitle()).isEqualTo("TITLE");
    }

    @Test
    public void prepare_whenNoMessageProvided_usesDefaultMessage() {
        FailedClient.prepare("TITLE", null);

        assertThat(FailedClient.getMessage()).isEqualTo("An unknown error has occurred. The application cannot be run at this time.");
    }

    @Test
    public void prepare_whenMessageProvided_usesProvidedMessage() {
        FailedClient.prepare("TITLE", "MESSAGE");

        assertThat(FailedClient.getMessage()).isEqualTo("MESSAGE");
    }
}
