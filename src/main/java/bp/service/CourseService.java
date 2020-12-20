package bp.service;

import bp.entity.Course;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

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
     * @return optional of course
     */
    Optional<Course> getCourse(@NonNull Long id);

    /**
     * Creates a new {@link Course}
     *
     * @param name        a course name
     * @param description a course description
     *
     * @return a new created course
     */
    Course createCourse(@NonNull String name, @Nullable String description);

    /**
     * Saves a {@link Course}
     *
     * @param course a course to save
     */
    void saveCourse(@NonNull Course course);

    /**
     * Deletes a {@link Course}
     *
     * @param course a course to delete
     */
    void deleteCourse(@NonNull Course course);
}
