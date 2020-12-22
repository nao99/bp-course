package bp.controller;

import bp.api.mapper.SectionMapper;
import bp.api.model.section.SectionCreateDto;
import bp.api.model.section.SectionDto;
import bp.api.model.section.SectionUpdateDto;
import bp.entity.Course;
import bp.entity.Section;
import bp.exception.section.SectionConstraintException;
import bp.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * SectionController class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2020-12-22
 */
@RestController
@RequestMapping(name = "api_v1.0_sections", path = "/api/v1.0")
public class SectionController {
    /**
     * Section service
     */
    @NonNull
    private final SectionService service;

    /**
     * SectionController controller
     *
     * @param service a section service
     */
    @Autowired
    public SectionController(@NonNull SectionService service) {
        this.service = service;
    }

    /**
     * API endpoint to get a {@link Section} by id
     *
     * @param section a section
     * @return a response with 200 status code and section content as a body
     */
    @GetMapping(name = "api_v1.0_sections_get_one", path = "/sections/{sectionId:\\d+}")
    public ResponseEntity<SectionDto> getSection(@PathVariable("sectionId") Section section) {
        SectionDto sectionDto = new SectionDto(section);
        return ResponseEntity.ok(sectionDto);
    }

    /**
     * API endpoint to get a {@link Section} by a {@link Course#id}
     *
     * @param course a course
     * @return a response with 200 status code and section content as a body
     */
    @GetMapping(name = "api_v1.0_sections_get_by_course_id", path = "/course/{courseId:\\d+}/sections")
    public ResponseEntity<List<SectionDto>> getSectionsByCourseId(@PathVariable("courseId") Course course) {
        List<Section> sections = service.getSectionsByCourseId(course.getId());
        List<SectionDto> sectionsDto = sections
            .stream()
            .map(SectionDto::new)
            .collect(Collectors.toList());

        return ResponseEntity.ok(sectionsDto);
    }

    /**
     * API endpoint to create a new {@link Section}
     *
     * @param createDto a validated section create dto
     * @return a response with 200 status code and section content as a body
     */
    @PostMapping(name = "api_v1.0_sections_create", path = "/sections")
    public ResponseEntity<SectionDto> createSection(@Valid @RequestBody SectionCreateDto createDto) {
        Course course = createDto.getCourse();
        Section section = null;

        try {
            section = service.createSection(course.getId(), createDto.getName(), createDto.getDescription());
        } catch (SectionConstraintException e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, e.getMessage(), e);
        }

        SectionDto sectionDto = new SectionDto(section);

        return ResponseEntity.ok(sectionDto);
    }

    /**
     * API endpoint to update a {@link Section}
     *
     * @param section   a section
     * @param updateDto a validated section update dto
     *
     * @return a response with 204 status code
     */
    @PutMapping(name = "api_v1.0_sections_update", path = "/sections/{sectionId:\\d+}")
    public ResponseEntity<Void> updateSection(
        @PathVariable(value = "sectionId") Section section,
        @Valid @RequestBody SectionUpdateDto updateDto
    ) {
        SectionMapper.dtoToSection(updateDto, section);
        service.saveSection(section);

        return ResponseEntity.noContent().build();
    }

    /**
     * API endpoint to delete a {@link Section} by id
     *
     * @param section a section
     * @return a response with 204 status code
     */
    @DeleteMapping(name = "api_v1.0_sections_delete", path = "/sections/{sectionId:\\d+}")
    public ResponseEntity<Void> deleteSection(@PathVariable(value = "sectionId") Section section) {
        service.deleteSection(section);
        return ResponseEntity.noContent().build();
    }
}
