package bp.course.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.time.OffsetDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

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
     * Lessons of this section
     */
    @NonNull
    private Set<Lesson> lessons;

    /**
     * Section constructor
     *
     * @param name        a section name
     * @param description a section description
     */
    public Section(@NonNull String name, @Nullable String description) {
        this.name = name;
        this.description = description;

        this.lessons = new LinkedHashSet<>();
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
    public Set<Lesson> getLessons() {
        return lessons;
    }

    /**
     * Adds a new {@link Lesson} to lessons collection
     *
     * @param lesson a new lesson
     */
    public void addLesson(@NonNull Lesson lesson) {
        lessons.add(lesson);
    }

    /**
     * Removes a {@link Lesson} from lessons collection
     *
     * @param lesson a lesson to remove
     */
    public void removeLesson(@NonNull Lesson lesson) {
        lessons.remove(lesson);
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
        if (null != section.id && null != id) {
            return section.id.equals(id);
        }

        return other == this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int hash = 17;

        if (null != id) {
            hash = 31 * hash + id.hashCode();
        }

        if (null != description) {
            hash = 31 * hash + description.hashCode();
        }

        hash = 31 * hash + name.hashCode();
        hash = 31 * hash + createdAt.hashCode();

        return hash;
    }
}
