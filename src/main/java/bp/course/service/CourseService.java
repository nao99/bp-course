package bp.course.service;

import bp.course.api.model.course.CourseCreateDto;
import bp.course.model.Course;
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
}
