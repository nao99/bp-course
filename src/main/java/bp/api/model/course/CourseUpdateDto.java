package bp.api.model.course;

import bp.constraint.AtLeastOneFieldNotNull;
import org.springframework.lang.Nullable;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Size;

/**
 * CourseCreateDto class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2020-12-20
 */
@Validated
@AtLeastOneFieldNotNull(fields = {"name", "description"}, message = "At least one field must be not null")
public class CourseUpdateDto {
    /**
     * Name
     */
    @Nullable
    @Size(min = 4, max = 255, message = "\"name\" cannot be less than 4 and greater than 255 symbols")
    private String name;

    /**
     * Description
     */
    @Nullable
    @Size(min = 4, max = 8092, message = "\"description\" cannot be less than 4 and greater than 8092 symbols")
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
