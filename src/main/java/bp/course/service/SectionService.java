package bp.course.service;

import bp.course.api.model.lesson.LessonCreateDto;
import bp.course.api.model.section.SectionUpdateDto;
import bp.course.exception.section.SectionNotFoundException;
import bp.course.model.Lesson;
import bp.course.model.Section;
import org.springframework.lang.NonNull;

import java.util.Optional;

/**
 * SectionService interface
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-01-23
 */
public interface SectionService {
    /**
     * Gets a {@link Section} by id
     *
     * @param id a section id
     * @return optional of a section
     */
    @NonNull
    Optional<Section> getSection(@NonNull Long id);

    /**
     * Updates a {@link Section}
     *
     * @param sectionId        a section id
     * @param sectionUpdateDto a section update DTO
     *
     * @throws SectionNotFoundException if section was not found
     */
    void updateSection(@NonNull Long sectionId, @NonNull SectionUpdateDto sectionUpdateDto) throws SectionNotFoundException;

    /**
     * Adds a new {@link Lesson} to a {@link Section}
     *
     * @param sectionId       a section id
     * @param lessonCreateDto a lesson create DTO
     *
     * @return an added lesson
     * @throws SectionNotFoundException if section was not found
     */
    @NonNull
    Lesson addLessonToSection(
        @NonNull Long sectionId,
        @NonNull LessonCreateDto lessonCreateDto
    ) throws SectionNotFoundException;
}
