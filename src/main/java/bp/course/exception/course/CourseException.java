package bp.course.exception.course;

import org.springframework.lang.NonNull;

/**
 * CourseException class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-01-22
 */
public class CourseException extends Exception {
    /**
     * CourseException constructor
     */
    public CourseException() {
        super();
    }

    /**
     * CourseException constructor
     *
     * @param message an exception message
     */
    public CourseException(@NonNull String message) {
        super(message);
    }

    /**
     * CourseException constructor
     *
     * @param message  an exception message
     * @param previous a previous exception
     */
    public CourseException(@NonNull String message, @NonNull Throwable previous) {
        super(message, previous);
    }
}
