package bp.course.api.model.section;

import bp.course.model.Section;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.time.OffsetDateTime;

/**
 * SectionDto class
 *
 * @author Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since 2021-01-14
 */
public class SectionDto {
    /**
     * Section
     */
    @NonNull
    private final Section section;

    /**
     * SectionDto constructor
     *
     * @param section a section
     */
    public SectionDto(@NonNull Section section) {
        this.section = section;
    }

    @Nullable
    public Long getId() {
        return section.getId();
    }

    @NonNull
    public String getName() {
        return section.getName();
    }

    @Nullable
    public String getDescription() {
        return section.getDescription();
    }

    @NonNull
    public OffsetDateTime getCreatedAt() {
        return section.getCreatedAt();
    }
}
