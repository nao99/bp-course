package bp.converter;

import bp.entity.Course;
import bp.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

/**
 * StringToCourseConverter class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2020-12-20
 */
@Component
@ReadingConverter
public class StringToCourseConverter implements Converter<String, Course> {
    /**
     * Course service
     */
    @NonNull
    private final CourseService service;

    /**
     * StringToCourseConverter constructor
     *
     * @param service a course service
     */
    @Autowired
    public StringToCourseConverter(@NonNull CourseService service) {
        this.service = service;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Course convert(@NonNull String id) {
        Long courseId = Long.parseLong(id);
        Optional<Course> courseOptional = service.getCourse(courseId);

        if (courseOptional.isEmpty()) {
            String message = String.format("Course with \"%s\" id not found", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, message);
        }

        return courseOptional.get();
    }
}
