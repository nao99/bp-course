package bp.exception.section;

import org.springframework.lang.NonNull;

/**
 * SectionConstraintException class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2020-12-19
 */
public class SectionConstraintException extends SectionException {
    /**
     * SectionConstraintException constructor
     */
    public SectionConstraintException() {
        super();
    }

    /**
     * SectionConstraintException constructor
     *
     * @param message an exception message
     */
    public SectionConstraintException(@NonNull String message) {
        super(message);
    }

    /**
     * SectionConstraintException constructor
     *
     * @param message an exception message
     * @param cause   a previous exception
     */
    public SectionConstraintException(@NonNull String message, @NonNull Throwable cause) {
        super(message, cause);
    }

    /**
     * SectionConstraintException constructor
     *
     * @param cause a previous exception
     */
    public SectionConstraintException(@NonNull Throwable cause) {
        super(cause);
    }
}
