package bp.config;

import bp.converter.StringToCourseConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * MvcConfiguration class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2020-12-20
 */
@Configuration
public class MvcConfiguration implements WebMvcConfigurer {
    /**
     * String to course converter
     */
    @NonNull
    private final StringToCourseConverter stringToCourseConverter;

    /**
     * MvcConfiguration constructor
     *
     * @param stringToCourseConverter a string to course converter
     */
    @Autowired
    public MvcConfiguration(@NonNull StringToCourseConverter stringToCourseConverter) {
        this.stringToCourseConverter = stringToCourseConverter;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(stringToCourseConverter);
    }
}