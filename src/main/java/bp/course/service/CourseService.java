package bp.course.service;

import bp.course.api.model.course.CourseCreateDto;
import bp.course.api.model.course.CourseUpdateDto;
import bp.course.api.model.section.SectionCreateDto;
import bp.course.exception.course.CourseNotFoundException;
import bp.course.model.Course;
import bp.course.model.Section;
import org.springframework.lang.NonNull;

import java.util.Optional;

/**
 * CourseService interface
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2020-12-16
 */
public interface CourseService {
    /**
     * Gets a {@link Course} by id
     *
     * @param id a course id
     * @return optional of a course
     */
    @NonNull
    Optional<Course> getCourse(@NonNull Long id);

    /**
     * Creates a new {@link Course}
     *
     * @param courseCreateDto a course create DTO
     * @return a new created course
     */
    @NonNull
    Course createCourse(@NonNull CourseCreateDto courseCreateDto);

    /**
     * Updates a {@link Course}
     *
     * @param courseId        a course id
     * @param courseUpdateDto a course update DTO
     *
     * @throws CourseNotFoundException if course was not found
     */
    void updateCourse(@NonNull Long courseId, @NonNull CourseUpdateDto courseUpdateDto) throws CourseNotFoundException;

    /**
     * Adds a new {@link Section} to a {@link Course}
     *
     * @param courseId         a course id
     * @param sectionCreateDto a section create DTO
     *
     * @return an added section
     * @throws CourseNotFoundException if course was not found
     */
    @NonNull
    Section addSectionToCourse(
        @NonNull Long courseId,
        @NonNull SectionCreateDto sectionCreateDto
    ) throws CourseNotFoundException;
}
