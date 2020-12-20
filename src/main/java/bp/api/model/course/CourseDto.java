package bp.api.model.course;

import bp.entity.Course;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.time.OffsetDateTime;

/**
 * CourseDto class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2020-12-20
 */
public class CourseDto {
    /**
     * Course
     */
    @NonNull
    private final Course course;

    /**
     * CourseDto constructor
     *
     * @param course a course
     */
    public CourseDto(@NonNull Course course) {
        this.course = course;
    }

    /**
     * @return a course id
     */
    @Nullable
    public Long getId() {
        return course.getId();
    }

    /**
     * @return a course name
     */
    @NonNull
    public String getName() {
        return course.getName();
    }

    /**
     * @return a course description
     */
    @Nullable
    public String getDescription() {
        return course.getDescription();
    }

    /**
     * @return a course created_at
     */
    @NonNull
    public OffsetDateTime getCreatedAt() {
        return course.getCreatedAt();
    }

    /**
     * @return a course updated_at
     */
    @NonNull
    public OffsetDateTime getUpdatedAt() {
        return course.getUpdatedAt();
    }
}
