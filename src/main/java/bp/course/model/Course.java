package bp.course.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.time.OffsetDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Course class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2020-12-16
 */
@Table(value = "courses")
public class Course {
    public final static short MIN_LENGTH_NAME        = 3;
    public final static short MAX_LENGTH_NAME        = 255;
    public final static short MIN_LENGTH_DESCRIPTION = 3;
    public final static short MAX_LENGTH_DESCRIPTION = 8092;

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
     * Sections of this course
     */
    @NonNull
    private Set<Section> sections;

    /**
     * Course constructor
     *
     * @param name        a course name
     * @param description a course description
     */
    public Course(@NonNull String name, @Nullable String description) {
        this.name = name;
        this.description = description;

        this.sections = new LinkedHashSet<>();
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
     * Renames this course
     *
     * @param name a new course name
     * @throws IllegalArgumentException if passed name less than 3 or greater than 255 in length
     */
    public void rename(@NonNull String name) {
        if (MIN_LENGTH_NAME > name.length() || MAX_LENGTH_NAME < name.length()) {
            throw new IllegalArgumentException("Course name length cannot be less than 3 or greater than 255");
        }

        this.name = name;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    /**
     * Changes description of this course
     *
     * @param description a new course description
     * @throws IllegalArgumentException if passed description less than 3 or greater than 8092 in length
     */
    public void changeDescription(@NonNull String description) {
        if (MIN_LENGTH_DESCRIPTION > description.length() || MAX_LENGTH_DESCRIPTION < description.length()) {
            throw new IllegalArgumentException("Course description length cannot be less than 3 or greater than 8092");
        }

        this.description = description;
    }

    /**
     * Removes a description of this course
     */
    public void removeDescription() {
        description = null;
    }

    @NonNull
    public Set<Section> getSections() {
        return sections;
    }

    /**
     * Adds a new {@link Section} to sections collection
     *
     * @param section a new section
     */
    public void addSection(@NonNull Section section) {
        sections.add(section);
    }

    /**
     * Removes a {@link Section} from sections collection
     *
     * @param section a section to remove
     */
    public void removeSection(@NonNull Section section) {
        sections.remove(section);
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
        if (!other.getClass().isAssignableFrom(Course.class)) {
            return false;
        }

        Course course = (Course) other;
        if (null != course.id && null != this.id) {
            return course.id.equals(this.id);
        }

        return course == this;
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
