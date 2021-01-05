package bp.course.api.model.course;

import bp.course.api.model.section.SectionCreateDto;
import bp.course.model.Course;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * CourseCreateDto class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-01-05
 */
public class CourseCreateDto {
    /**
     * Name
     */
    @Size(
        min = Course.MIN_LENGTH_NAME,
        max = Course.MAX_LENGTH_NAME,
        message = "\"name\" cannot be less than 3 and greater than 255 symbols"
    )
    @NotBlank(message = "\"name\" cannot be empty")
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

    /**
     * Sections
     */
    @NotEmpty(message = "A new course must has at least one section")
    private List<SectionCreateDto> sections;

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

    @Valid
    @NonNull
    public List<SectionCreateDto> getSections() {
        return sections;
    }

    public void setSections(@NonNull List<SectionCreateDto> sections) {
        this.sections = sections;
    }
}
