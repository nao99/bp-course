package bp.course.exception.section;

import org.springframework.lang.NonNull;

/**
 * SectionException class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-01-23
 */
public class SectionException extends Exception {
    /**
     * SectionException constructor
     */
    public SectionException() {
        super();
    }

    /**
     * SectionException constructor
     *
     * @param message an exception message
     */
    public SectionException(@NonNull String message) {
        super(message);
    }

    /**
     * SectionException constructor
     *
     * @param message  an exception message
     * @param previous a previous exception
     */
    public SectionException(@NonNull String message, @NonNull Throwable previous) {
        super(message, previous);
    }
}
