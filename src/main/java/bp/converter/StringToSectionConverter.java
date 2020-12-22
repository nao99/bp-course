package bp.converter;

import bp.entity.Section;
import bp.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

/**
 * StringToSectionConverter class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2020-12-22
 */
@Component
@ReadingConverter
public class StringToSectionConverter implements Converter<String, Section> {
    /**
     * Section service
     */
    @NonNull
    private final SectionService service;

    /**
     * StringToSectionConverter constructor
     *
     * @param service a section service
     */
    @Autowired
    public StringToSectionConverter(@NonNull SectionService service) {
        this.service = service;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Section convert(@NonNull String id) {
        Long sectionId = Long.parseLong(id);
        Optional<Section> sectionOptional = service.getSection(sectionId);

        if (sectionOptional.isEmpty()) {
            String message = String.format("Section with \"%s\" id not found", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, message);
        }

        return sectionOptional.get();
    }
}
