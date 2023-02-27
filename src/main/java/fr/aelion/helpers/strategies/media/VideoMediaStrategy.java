package fr.aelion.helpers.strategies.media;

import fr.aelion.helpers.builders.MediaBuilder;
import fr.aelion.helpers.exceptions.NoMediaTypeException;
import fr.aelion.helpers.exceptions.NotEnoughArgsException;
import fr.aelion.models.courses.Video;

public class VideoMediaStrategy implements IMediaStrategy<Video> {
    @Override
    public Video castAs(MediaBuilder mediaBuilder) throws NoMediaTypeException, NotEnoughArgsException {
        return (Video) mediaBuilder.build();
    }
}