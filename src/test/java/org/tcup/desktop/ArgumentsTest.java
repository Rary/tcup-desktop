package org.tcup.desktop;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class ArgumentsTest {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void extract_whenNoArgsProvided_throwsNullPointerException() {
        exception.expect(NullPointerException.class);
        Arguments.extract(null);
    }

    @Test
    public void extract_whenEmptyArgsProvided_returnsArgumentsInstanceWithEmptyRootUrl() {
        Arguments result = Arguments.extract(new String[] {});

        assertThat(result).isNotNull().extracting(Arguments::getRootUrl).isEqualTo(null);
    }

    @Test
    public void extract_whenArgsWithOneValidUrlEntryProvided_returnsArgumentsInstanceWithRootUrlPopulated() {
        Arguments result = Arguments.extract(new String[] {"https://www.example.com/"});

        assertThat(result).isNotNull().extracting(Arguments::getRootUrl).isEqualTo("https://www.example.com/");
    }

    @Test
    public void extract_whenArgsWithOneValidUrlEntryWithoutTrailingSlashProvided_returnsArgumentsInstanceWithRootUrlPopulatedAndTrailingSlashAdded() {
        Arguments result = Arguments.extract(new String[] {"https://www.example.com"});

        assertThat(result).isNotNull().extracting(Arguments::getRootUrl).isEqualTo("https://www.example.com/");
    }

    @Test
    public void getRootUrl_whenNoRootUrlProvided_returnsNull() {
        Arguments arguments = new Arguments(null);

        String result = arguments.getRootUrl();

        assertThat(result).isNull();
    }

    @Test
    public void getRootUrl_whenEmptyRootUrlProvided_returnsEmptyString() {
        Arguments arguments = new Arguments("");

        String result = arguments.getRootUrl();

        assertThat(result).isNotNull().isEmpty();
    }

    @Test
    public void getRootUrl_whenRootUrlProvided_returnsRootUrl() {
        Arguments arguments = new Arguments("https://www.example.com/");

        String result = arguments.getRootUrl();

        assertThat(result).isNotNull().isEqualTo("https://www.example.com/");
    }

    @Test
    public void getRootUrl_whenRootUrlIsTooLong_returnsTruncatedRootUrl() {
        // 2049 characters
        Arguments arguments = new Arguments("https://www.example.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");

        String result = arguments.getRootUrl();

        // truncate to 2048 characters
        assertThat(result).isNotNull().isEqualTo("https://www.example.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");
    }
}
