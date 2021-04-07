package bp.course.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.time.OffsetDateTime;

/**
 * Lesson class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-01-23
 */
@Table(value = "lessons")
public class Lesson {
    public final static short MIN_LENGTH_NAME    = 3;
    public final static short MAX_LENGTH_NAME    = 255;
    public final static short MIN_LENGTH_CONTENT = 3;
    public final static short MAX_LENGTH_CONTENT = 8192;

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
     * Content column
     */
    @NonNull
    private String content;

    /**
     * Created at column
     */
    @NonNull
    private OffsetDateTime createdAt;

    /**
     * Lesson constructor
     *
     * @param name    a lesson name
     * @param content a lesson content
     */
    public Lesson(@NonNull String name, @NonNull String content) {
        this.name = name;
        this.content = content;

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
     * Renames this lesson
     *
     * @param name a new lesson name
     * @throws IllegalArgumentException if passed name less than 3 or greater than 255 in length
     */
    public void rename(@NonNull String name) {
        if (MIN_LENGTH_NAME > name.length() || MAX_LENGTH_NAME < name.length()) {
            throw new IllegalArgumentException("Lesson name length cannot be less than 3 or greater than 255");
        }

        this.name = name;
    }

    @NonNull
    public String getContent() {
        return content;
    }

    /**
     * Changes content of this lesson
     *
     * @param content a new lesson content
     * @throws IllegalArgumentException if passed content less than 3 or greater than 8192 in length
     */
    public void changeContent(@NonNull String content) {
        if (MIN_LENGTH_CONTENT > content.length() || MAX_LENGTH_CONTENT < content.length()) {
            throw new IllegalArgumentException("Lesson content length cannot be less than 3 or greater than 8192");
        }

        this.content = content;
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
        if (!other.getClass().isAssignableFrom(Lesson.class)) {
            return false;
        }

        Lesson lesson = (Lesson) other;
        if (null != lesson.id && null != id) {
            return lesson.id.equals(id);
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

        hash = 31 * hash + name.hashCode();
        hash = 31 * hash + content.hashCode();
        hash = 31 * hash + createdAt.hashCode();

        return hash;
    }
}
