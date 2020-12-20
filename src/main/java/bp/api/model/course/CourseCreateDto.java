package bp.api.model.course;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * CourseCreateDto class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2020-12-20
 */
@Validated
public class CourseCreateDto {
    /**
     * Name
     */
    @NotBlank(message = "\"name\" cannot be null or empty")
    @Size(min = 4, max = 255, message = "\"name\" cannot be less than 4 and greater than 255 symbols")
    private String name;

    /**
     * Description
     */
    @Nullable
    @Size(min = 4, max = 8092, message = "\"description\" cannot be less than 4 and greater than 8092 symbols")
    private String description;

    @NonNull
    public String getName() {
        return name;
    }

    @Nullable
    public String getDescription() {
        return description;
    }
}
