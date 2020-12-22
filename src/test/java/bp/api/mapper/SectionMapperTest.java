package bp.api.mapper;

import bp.api.model.section.SectionUpdateDto;
import bp.entity.Section;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * SectionMapperTest class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2020-12-22
 */
public class SectionMapperTest {
    /**
     * Test for {@link SectionMapper#dtoToSection(SectionUpdateDto, Section)}
     */
    @Test
    public void dtoToSection() throws Exception {
        // given
        SectionUpdateDto updateDto1 = new SectionUpdateDto();
        updateDto1.setName("Math section");
        updateDto1.setDescription("Math is's a cool");

        SectionUpdateDto updateDto2 = new SectionUpdateDto();
        updateDto2.setDescription("Chemistry is's a cool");

        SectionUpdateDto updateDto3 = new SectionUpdateDto();
        updateDto3.setName("Chemistry section");

        SectionUpdateDto updateDto4 = new SectionUpdateDto();

        Section section = new Section(1L, "Chemistry", "Chemistry it's a cool");

        // when / then
        SectionMapper.dtoToSection(updateDto1, section);
        assertEquals(updateDto1.getName(), section.getName());
        assertEquals(updateDto1.getDescription(), section.getDescription());

        SectionMapper.dtoToSection(updateDto2, section);
        assertEquals(updateDto1.getName(), section.getName());
        assertEquals(updateDto2.getDescription(), section.getDescription());

        SectionMapper.dtoToSection(updateDto3, section);
        assertEquals(updateDto3.getName(), section.getName());
        assertEquals(updateDto2.getDescription(), section.getDescription());

        SectionMapper.dtoToSection(updateDto4, section);
        assertEquals(updateDto3.getName(), section.getName());
        assertEquals(updateDto2.getDescription(), section.getDescription());
    }
}
