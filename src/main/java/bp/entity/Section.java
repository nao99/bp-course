package bp.entity;

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
    /**
     * Id column
     */
    @Id
    @Nullable
    private Long id;

    /**
     * Course id column
     */
    @NonNull
    private Long courseId;

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
     * Updated at column
     */
    @NonNull
    private OffsetDateTime updatedAt;

    /**
     * Section constructor
     *
     * @param courseId    a course id
     * @param name        a section name
     * @param description a section description
     */
    public Section(@NonNull Long courseId, @NonNull String name, @Nullable String description) {
        this.courseId = courseId;
        this.name = name;
        this.description = description;

        this.createdAt = OffsetDateTime.now();
        this.updatedAt = OffsetDateTime.now();
    }

    @Nullable
    public Long getId() {
        return id;
    }

    public void setId(@Nullable Long id) {
        this.id = id;
    }

    @NonNull
    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(@NonNull Long courseId) {
        this.courseId = courseId;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    public void setDescription(@Nullable String description) {
        this.description = description;
    }

    @NonNull
    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(@NonNull OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @NonNull
    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(@NonNull OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object other) {
        if (null == other) {
            return false;
        }

        if (!other.getClass().isAssignableFrom(Section.class)) {
            return false;
        }

        Section section = (Section) other;
        if (null != section.id && null != this.id) {
            return section.id.equals(this.id);
        }

        return section == this;
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

        hash = 31 * hash + this.courseId.hashCode();
        hash = 31 * hash + this.name.hashCode();
        hash = 31 * hash + this.createdAt.hashCode();
        hash = 31 * hash + this.updatedAt.hashCode();

        return hash;
    }
}
