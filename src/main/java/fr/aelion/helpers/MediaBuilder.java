package fr.aelion.helpers;

import fr.aelion.helpers.exceptions.NoMediaTypeException;
import fr.aelion.helpers.exceptions.NotEnoughArgsException;
import fr.aelion.helpers.factory.MediaFactory;
import fr.aelion.helpers.interfaces.Builder;
import fr.aelion.helpers.strategies.media.IMediaStrategy;
import fr.aelion.helpers.strategies.media.VideoMediaStrategy;
import fr.aelion.models.courses.*;

import javax.swing.text.html.Option;
import java.util.Optional;

public class MediaBuilder implements Builder<Media> {

    private String title;
    private String summary;
    private Float duration;
    private Author author;

    private String mediaType;

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public MediaBuilder title(String title) {
        this.title = title;
        return this;
    }

    public MediaBuilder summary(String summary) {
        this.summary = summary;
        return this;
    }

    public MediaBuilder duration(Float duration) {
        this.duration = duration;
        return this;
    }

    public MediaBuilder author(Author author) {
        this.author = author;
        return this;
    }

    @Override
    public Media build() throws NotEnoughArgsException, NoMediaTypeException {
        if (this.title == null || this.duration == null) {
            throw new NotEnoughArgsException("Missing duration or title");
        }
        if (this.mediaType == null) {
            throw new NoMediaTypeException();
        }

        Media media = null;
        try {
            media = new MediaFactory().getMedia(this.mediaType);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }


        media.setTitle(this.title);
        media.setSummary(this.summary);
        media.setDuration(this.duration);
        media.setAuthor(this.author);

        return media;
    }
}
