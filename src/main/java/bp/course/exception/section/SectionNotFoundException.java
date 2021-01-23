package bp.course.exception.section;

import org.springframework.lang.NonNull;

/**
 * SectionNotFoundException class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-01-23
 */
public class SectionNotFoundException extends SectionException {
    /**
     * SectionNotFoundException constructor
     */
    public SectionNotFoundException() {
        super();
    }

    /**
     * SectionNotFoundException constructor
     *
     * @param message an exception message
     */
    public SectionNotFoundException(@NonNull String message) {
        super(message);
    }

    /**
     * SectionNotFoundException constructor
     *
     * @param message  an exception message
     * @param previous a previous exception
     */
    public SectionNotFoundException(@NonNull String message, @NonNull Throwable previous) {
        super(message, previous);
    }
}
