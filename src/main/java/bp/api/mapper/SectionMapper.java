package bp.api.mapper;

import bp.api.model.section.SectionUpdateDto;
import bp.entity.Section;
import org.springframework.lang.NonNull;

/**
 * SectionMapper class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2020-12-22
 */
public class SectionMapper {
    /**
     * Maps all non nullable {@link SectionUpdateDto} fields to a {@link Section}
     *
     * @param updateDto a section updated dto
     * @param section   a section
     */
    public static void dtoToSection(@NonNull SectionUpdateDto updateDto, @NonNull Section section) {
        if (null != updateDto.getName()) {
            section.setName(updateDto.getName());
        }

        if (null != updateDto.getDescription()) {
            section.setDescription(updateDto.getDescription());
        }
    }
}
