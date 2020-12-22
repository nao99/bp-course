package bp.api.model.section;

import bp.entity.Course;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * SectionCreateDto class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2020-12-22
 */
@Validated
public class SectionCreateDto {
    /**
     * Course
     */
    @NotNull(message = "\"course\" cannot be null")
    private Course course;

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
    public Course getCourse() {
        return course;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @Nullable
    public String getDescription() {
        return description;
    }
}
