package fr.aelion.helpers.strategies.media;

import fr.aelion.helpers.MediaBuilder;
import fr.aelion.helpers.exceptions.NoMediaTypeException;
import fr.aelion.helpers.exceptions.NotEnoughArgsException;
import fr.aelion.models.courses.Media;

public interface IMediaStrategy<T> {
    T castAs(MediaBuilder mediaBuilder) throws NoMediaTypeException, NotEnoughArgsException;
}