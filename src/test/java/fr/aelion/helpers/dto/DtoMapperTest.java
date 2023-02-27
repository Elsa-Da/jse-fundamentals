package fr.aelion.helpers.dto;

import fr.aelion.models.courses.Media;
import fr.aelion.models.courses.Video;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

class DtoMapperTest {

    private DtoMapper mapper;
    private Media video = new Video();
    private MediaListDto dto = new MediaListDto();

    @BeforeEach
    void setUp() {
        mapper = new DtoMapper();

    }

    @Test
    void map() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        DtoMapper mapper = new DtoMapper();

        dto = (MediaListDto) mapper.map(video, dto);
        assertAll (
                () -> assertEquals(video.getTitle(), dto.title),
                () -> assertEquals(video.getDuration(), dto.duration));
    }
}