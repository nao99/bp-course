package bp.course.config;

import bp.course.converter.TimestampToOffsetDateTimeConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.core.convert.JdbcCustomConversions;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;

import java.util.Collections;

/**
 * DataJdbcConfiguration class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2020-12-19
 */
@Configuration
public class DataJdbcConfiguration extends AbstractJdbcConfiguration {
    /**
     * {@inheritDoc}
     */
    @Override
    public JdbcCustomConversions jdbcCustomConversions() {
        return new JdbcCustomConversions(Collections.singletonList(TimestampToOffsetDateTimeConverter.INSTANCE));
    }
}
