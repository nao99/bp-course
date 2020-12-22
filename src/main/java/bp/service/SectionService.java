package bp.service;

import bp.entity.Course;
import bp.entity.Section;
import bp.exception.section.SectionConstraintException;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.Optional;

/**
 * SectionService interface
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2020-12-19
 */
public interface SectionService {
    /**
     * Gets a {@link Section} by id
     *
     * @param id a section id
     * @return optional of section
     */
    Optional<Section> getSection(@NonNull Long id);

    /**
     * Gets a list of {@link Section}s by a {@link Course#id}
     *
     * @param courseId a course id
     * @return list of a sections
     */
    List<Section> getSectionsByCourseId(@NonNull Long courseId);

    /**
     * Creates a new {@link Section}
     *
     * @param courseId    a course id
     * @param name        a section name
     * @param description a section description
     *
     * @return a new created section
     * @throws SectionConstraintException if some constraint was violated
     */
    Section createSection(
        @NonNull Long courseId,
        @NonNull String name,
        @Nullable String description
    ) throws SectionConstraintException;

    /**
     * Saves a {@link Section}
     *
     * @param section a section to save
     */
    void saveSection(@NonNull Section section);

    /**
     * Deletes a {@link Section}
     *
     * @param section a section to delete
     */
    void deleteSection(@NonNull Section section);
}
