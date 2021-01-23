package bp.course.exception.course;

import org.springframework.lang.NonNull;

/**
 * CourseNotFoundException class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-01-22
 */
public class CourseNotFoundException extends CourseException {
    /**
     * CourseNotFoundException constructor
     */
    public CourseNotFoundException() {
        super();
    }

    /**
     * CourseNotFoundException constructor
     *
     * @param message an exception message
     */
    public CourseNotFoundException(@NonNull String message) {
        super(message);
    }

    /**
     * CourseNotFoundException constructor
     *
     * @param message  an exception message
     * @param previous a previous exception
     */
    public CourseNotFoundException(@NonNull String message, @NonNull Throwable previous) {
        super(message, previous);
    }
}
