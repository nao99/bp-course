package bp.course.api.model.course;

import bp.course.constraint.AtLeastOneFieldNotNull;
import bp.course.model.Course;
import org.springframework.lang.Nullable;

import javax.validation.constraints.Size;

/**
 * CourseUpdateDto class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-01-22
 */
@AtLeastOneFieldNotNull(
    fields = {"name", "description"},
    message = "\"name\" and \"description\" cannot be nullable together"
)
public class CourseUpdateDto {
    /**
     * Name
     */
    @Size(
        min = Course.MIN_LENGTH_NAME,
        max = Course.MAX_LENGTH_NAME,
        message = "\"name\" cannot be less than 3 and greater than 255 symbols"
    )
    @Nullable
    private String name;

    /**
     * Description
     */
    @Size(
        min = Course.MIN_LENGTH_DESCRIPTION,
        max = Course.MAX_LENGTH_DESCRIPTION,
        message = "\"description\" cannot be less than 3 and greater than 8092 symbols"
    )
    @Nullable
    private String description;

    @Nullable
    public String getName() {
        return name;
    }

    public void setName(@Nullable String name) {
        this.name = name;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    public void setDescription(@Nullable String description) {
        this.description = description;
    }
}
