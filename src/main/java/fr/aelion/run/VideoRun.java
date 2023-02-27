package fr.aelion.run;

import fr.aelion.helpers.builders.MediaBuilder;
import fr.aelion.helpers.exceptions.NoMediaTypeException;
import fr.aelion.helpers.exceptions.NotEnoughArgsException;
import fr.aelion.helpers.strategies.media.VideoMediaStrategy;
import fr.aelion.models.courses.Author;
import fr.aelion.models.courses.Video;

public class VideoRun {
    private MediaBuilder mediaBuilder = new MediaBuilder();

    public VideoRun() throws NoMediaTypeException, NotEnoughArgsException {
        mediaBuilder.setMediaType("video");
        mediaBuilder
                .title("Titre")
                .summary("Résumé")
                .author(new Author())
                .duration(5.35F);
        VideoMediaStrategy videoStrategy = new VideoMediaStrategy();
        Video video = videoStrategy.castAs(mediaBuilder);

    }
}