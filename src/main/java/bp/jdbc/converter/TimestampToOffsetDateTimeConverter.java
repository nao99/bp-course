package bp.jdbc.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

/**
 * TimestampToOffsetDateTimeConverter class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2020-12-18
 */
@ReadingConverter
public final class TimestampToOffsetDateTimeConverter implements Converter<Timestamp, OffsetDateTime> {
    /**
     * Instance of this converter
     */
    public final static TimestampToOffsetDateTimeConverter INSTANCE = new TimestampToOffsetDateTimeConverter();

    /**
     * TimestampToOffsetDateTimeConverter constructor
     */
    private TimestampToOffsetDateTimeConverter() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OffsetDateTime convert(Timestamp timestamp) {
        LocalDateTime localTimestamp = timestamp.toLocalDateTime();

        ZoneId systemZoneId = ZoneId.systemDefault();
        ZoneOffset systemZoneOffset = systemZoneId.getRules().getOffset(localTimestamp);

        return OffsetDateTime.of(localTimestamp, systemZoneOffset);
    }
}
