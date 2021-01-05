package bp.course.api.model.course;

import bp.course.api.model.section.SectionDto;
import bp.course.model.Course;
import bp.course.model.Section;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.time.OffsetDateTime;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * CourseDto class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-01-14
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

    @Nullable
    public Long getId() {
        return course.getId();
    }

    @NonNull
    public String getName() {
        return course.getName();
    }

    @Nullable
    public String getDescription() {
        return course.getDescription();
    }

    @NonNull
    public OffsetDateTime getCreatedAt() {
        return course.getCreatedAt();
    }

    @NonNull
    public Set<SectionDto> getSections() {
        return course.getSections()
            .stream()
            .map(SectionDto::new)
            .collect(Collectors.toSet());
    }
}
