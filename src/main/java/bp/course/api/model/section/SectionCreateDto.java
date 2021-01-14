package bp.course.api.model.section;

import bp.course.model.Section;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * CreateSectionDto class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-01-06
 */
public class SectionCreateDto {
    /**
     * Name
     */
    @Size(
        min = Section.MIN_LENGTH_NAME,
        max = Section.MAX_LENGTH_NAME,
        message = "\"name\" cannot be less than 3 and greater than 255 symbols"
    )
    @NotBlank(message = "\"name\" cannot be empty")
    private String name;

    /**
     * Description
     */
    @Nullable
    @Size(
        min = Section.MIN_LENGTH_DESCRIPTION,
        max = Section.MAX_LENGTH_DESCRIPTION,
        message = "\"description\" cannot be less than 3 and greater than 4096 symbols"
    )
    private String description;

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
}
