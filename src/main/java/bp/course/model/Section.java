package bp.course.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.time.OffsetDateTime;

/**
 * Section class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2020-12-16
 */
@Table(value = "sections")
public class Section {
    public final static short MIN_LENGTH_NAME        = 3;
    public final static short MAX_LENGTH_NAME        = 255;
    public final static short MIN_LENGTH_DESCRIPTION = 3;
    public final static short MAX_LENGTH_DESCRIPTION = 4096;

    /**
     * Id column
     */
    @Id
    @Nullable
    private Long id;

    /**
     * Name column
     */
    @NonNull
    private String name;

    /**
     * Description column
     */
    @Nullable
    private String description;

    /**
     * Created at column
     */
    @NonNull
    private OffsetDateTime createdAt;

    /**
     * Section constructor
     *
     * @param name        a section name
     * @param description a section description
     */
    public Section(@NonNull String name, @Nullable String description) {
        this.name = name;
        this.description = description;

        this.createdAt = OffsetDateTime.now();
    }

    @Nullable
    public Long getId() {
        return id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    /**
     * Renames this section
     *
     * @param name a new section name
     * @throws IllegalArgumentException if passed name less than 3 or greater than 255 in length
     */
    public void rename(@NonNull String name) {
        if (MIN_LENGTH_NAME > name.length() || MAX_LENGTH_NAME < name.length()) {
            throw new IllegalArgumentException("Section name length cannot be less than 3 or greater than 255");
        }

        this.name = name;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    /**
     * Changes description of this section
     *
     * @param description a new section description
     * @throws IllegalArgumentException if passed description less than 3 or greater than 4096 in length
     */
    public void changeDescription(@NonNull String description) {
        if (MIN_LENGTH_DESCRIPTION > description.length() || MAX_LENGTH_DESCRIPTION < description.length()) {
            throw new IllegalArgumentException("Course description length cannot be less than 3 or greater than 4096");
        }

        this.description = description;
    }

    /**
     * Removes a description of this section
     */
    public void removeDescription() {
        description = null;
    }

    @NonNull
    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(@NonNull Object other) {
        if (!other.getClass().isAssignableFrom(Section.class)) {
            return false;
        }

        Section section = (Section) other;
        if (null != section.id && null != this.id) {
            return section.id.equals(this.id);
        }

        return other == this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int hash = 17;

        if (null != this.id) {
            hash = 31 * hash + this.id.hashCode();
        }

        if (null != this.description) {
            hash = 31 * hash + this.description.hashCode();
        }

        hash = 31 * hash + this.name.hashCode();
        hash = 31 * hash + this.createdAt.hashCode();

        return hash;
    }
}
