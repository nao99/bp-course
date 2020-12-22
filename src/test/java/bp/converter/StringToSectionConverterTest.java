package bp.converter;

import bp.entity.Section;
import bp.service.SectionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * StringToSectionConverterTest class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2020-12-22
 */
@ExtendWith(SpringExtension.class)
public class StringToSectionConverterTest {
    /**
     * Section service mock
     */
    @MockBean
    private SectionService serviceMock;

    /**
     * String to section converter
     */
    private StringToSectionConverter converter;

    /**
     * Sets up
     */
    @BeforeEach
    public void setUp() throws Exception {
        converter = new StringToSectionConverter(serviceMock);
    }

    /**
     * Test for {@link StringToSectionConverter#convert(String)}
     */
    @Test
    public void convert() throws Exception {
        // given
        String id = "2";
        Long sectionId = Long.parseLong(id);

        Section section = new Section(1L, "Cool math", "Math - it's cool");
        section.setId(sectionId);

        // when
        Mockito
            .when(serviceMock.getSection(sectionId))
            .thenReturn(Optional.of(section));

        Section result = converter.convert(id);

        // then
        assertSame(section, result);
    }

    /**
     * Test for {@link StringToSectionConverter#convert(String)}
     */
    @Test
    public void convertWhenSectionNotFound() throws Exception {
        // given
        String sectionId = "2";

        // when / then
        assertThrows(ResponseStatusException.class, () -> {
            Mockito
                .when(serviceMock.getSection(Long.parseLong(sectionId)))
                .thenReturn(Optional.empty());

            converter.convert(sectionId);
        });
    }
}
