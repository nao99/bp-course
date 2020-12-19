package bp.exception.section;

import org.springframework.lang.NonNull;

/**
 * SectionCourseConstraintException class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2020-12-19
 */
public class SectionCourseConstraintException extends SectionConstraintException {
    /**
     * SectionCourseConstraintException constructor
     */
    public SectionCourseConstraintException() {
        super();
    }

    /**
     * SectionCourseConstraintException constructor
     *
     * @param message an exception message
     */
    public SectionCourseConstraintException(@NonNull String message) {
        super(message);
    }

    /**
     * SectionCourseConstraintException constructor
     *
     * @param message an exception message
     * @param cause   a previous exception
     */
    public SectionCourseConstraintException(@NonNull String message, @NonNull Throwable cause) {
        super(message, cause);
    }

    /**
     * SectionCourseConstraintException constructor
     *
     * @param cause a previous exception
     */
    public SectionCourseConstraintException(@NonNull Throwable cause) {
        super(cause);
    }
}
