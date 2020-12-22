package bp.service;

import bp.entity.Section;
import bp.exception.section.SectionConstraintException;
import bp.repository.SectionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * SectionServiceImplTest class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2020-12-19
 */
@ExtendWith(SpringExtension.class)
public class SectionServiceImplTest {
    /**
     * Section repository mock
     */
    @MockBean
    private SectionRepository repositoryMock;

    /**
     * Section service
     */
    private SectionServiceImpl service;

    /**
     * Sets up
     */
    @BeforeEach
    public void setUp() throws Exception {
        this.service = new SectionServiceImpl(this.repositoryMock);
    }

    /**
     * Test for {@link SectionServiceImpl#getSection(Long)}
     */
    @Test
    public void getSection() throws Exception {
        // given
        Section section = new Section(1L, "Mathematic - it's a cool!", null);
        section.setId(1L);

        // when
        Mockito
            .when(repositoryMock.findById(section.getId()))
            .thenReturn(Optional.of(section));

        Optional<Section> result1 = service.getSection(section.getId());
        Optional<Section> result2 = service.getSection(2L);

        // then
        assertTrue(result1.isPresent());
        assertEquals(section, result1.get());

        assertFalse(result2.isPresent());
    }

    /**
     * Test for {@link SectionServiceImpl#getSectionsByCourseId(Long)}
     */
    @Test
    public void getSectionsByCourseId() throws Exception {
        // given
        Long courseId = 1L;

        Section section1 = new Section(courseId, "Mathematic - it's a cool!", null);
        section1.setId(1L);

        Section section2 = new Section(courseId, "Chemistry - it's a cool!", null);
        section2.setId(2L);

        // when
        Mockito
            .when(repositoryMock.findAllByCourseId(courseId))
            .thenReturn(List.of(section1, section2));

        List<Section> result = service.getSectionsByCourseId(courseId);

        // then
        assertEquals(2, result.size());

        assertSame(section1, result.get(0));
        assertSame(section2, result.get(1));
    }

    /**
     * Test for {@link SectionServiceImpl#createSection(Long, String, String)}
     */
    @Test
    public void createSection() throws Exception {
        // given
        Long courseId = 1L;
        String name = "Mathematic";
        String description = "Mathematic - it's a cool!";

        // when
        Section result = service.createSection(courseId, name, description);
        Mockito
            .verify(repositoryMock, Mockito.atMostOnce())
            .save(result);

        // then
        assertNull(result.getId());
        assertEquals(courseId, result.getCourseId());
        assertEquals(name, result.getName());
        assertEquals(description, result.getDescription());
        assertNotNull(result.getCreatedAt());
        assertNotNull(result.getUpdatedAt());
    }

    /**
     * Test for {@link SectionServiceImpl#createSection(Long, String, String)}
     */
    @Test
    public void createSectionForNonExistedCourse() throws Exception {
        // when / then
        assertThrows(SectionConstraintException.class, () -> {
            Mockito
                .when(repositoryMock.save(Mockito.any()))
                .thenThrow(new DataIntegrityViolationException("Course does not exist"));

            service.createSection(1L, "Mathematic", "Mathematic - it's a cool!");
        });
    }

    /**
     * Test for a {@link SectionServiceImpl#saveSection(Section)}
     */
    @Test
    public void saveSection() {
        // given
        Section section = new Section(1L, "Mathematic", "Mathematic - it's a cool!");

        // when / then
        service.saveSection(section);
        Mockito
            .verify(repositoryMock, Mockito.atMostOnce())
            .save(section);
    }

    /**
     * Test for {@link SectionServiceImpl#deleteSection(Section)}
     */
    @Test
    public void deleteSection() throws Exception {
        // given
        Section section = new Section(1L, "Mathematic", "Mathematic - it's a cool!");

        // when / then
        service.deleteSection(section);
        Mockito
            .verify(repositoryMock, Mockito.atMostOnce())
            .delete(section);
    }
}
