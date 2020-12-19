package bp.jdbc.converter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TimestampToOffsetDateTimeConverterTest class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2020-12-19
 */
public class TimestampToOffsetDateTimeConverterTest {
    /**
     * Timestamp to OffsetDateTime converter
     */
    private TimestampToOffsetDateTimeConverter converter;

    /**
     * Sets up
     */
    @BeforeEach
    public void setUp() throws Exception {
        this.converter = TimestampToOffsetDateTimeConverter.INSTANCE;
    }

    /**
     * Test for {@link TimestampToOffsetDateTimeConverter#convert(Timestamp)}
     */
    @Test
    public void convert() throws Exception {
        // given
        Instant now = Instant.now();
        Timestamp timestamp = Timestamp.from(now);
        LocalDateTime localDateTime = timestamp.toLocalDateTime();

        ZoneId systemZoneId = ZoneId.systemDefault();
        ZoneOffset systemZoneOffset = systemZoneId.getRules().getOffset(now);

        // when
        OffsetDateTime result = this.converter.convert(timestamp);

        // then
        assertEquals(localDateTime, result.toLocalDateTime());
        assertSame(result.getOffset(), systemZoneOffset);
    }
}
