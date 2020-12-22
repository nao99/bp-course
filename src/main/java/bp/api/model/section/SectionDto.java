package bp.api.model.section;

import bp.entity.Section;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.time.OffsetDateTime;

/**
 * SectionDto class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2020-12-22
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

    /**
     * @return a section id
     */
    @Nullable
    public Long getId() {
        return section.getId();
    }

    /**
     * @return a course id
     */
    @NonNull
    public Long getCourseId() {
        return section.getCourseId();
    }

    /**
     * @return a section name
     */
    @NonNull
    public String getName() {
        return section.getName();
    }

    /**
     * @return a section description
     */
    @Nullable
    public String getDescription() {
        return section.getDescription();
    }

    /**
     * @return a section created_at
     */
    @NonNull
    public OffsetDateTime getCreatedAt() {
        return section.getCreatedAt();
    }

    /**
     * @return a section updated_at
     */
    @NonNull
    public OffsetDateTime getUpdatedAt() {
        return section.getUpdatedAt();
    }
}
