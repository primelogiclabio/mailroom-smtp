package io.primelogiclab.mailroom.smtp;

import static org.assertj.core.api.Assertions.assertThat;

import jakarta.mail.Session;
import jakarta.mail.Transport;
import java.util.Properties;
import org.eclipse.angus.mail.smtp.SMTPSSLTransport;
import org.eclipse.angus.mail.smtp.SMTPTransport;
import org.junit.jupiter.api.Test;

/**
 * Both sets find Angus Mail's SMTP providers through the Jakarta Mail API on their own JDKs (8; 21 and 25). Nothing
 * connects: getTransport only looks the provider up and creates it.
 */
class AngusMailTest {

    private final Session session = Session.getInstance(new Properties());

    @Test
    void smtpIsAngusMail() throws Exception {
        Transport transport = session.getTransport("smtp");
        assertThat(transport).isExactlyInstanceOf(SMTPTransport.class);
        assertThat(transport.isConnected()).isFalse();
    }

    @Test
    void smtpsIsAngusMail() throws Exception {
        Transport transport = session.getTransport("smtps");
        assertThat(transport).isExactlyInstanceOf(SMTPSSLTransport.class);
        assertThat(transport.isConnected()).isFalse();
    }
}
