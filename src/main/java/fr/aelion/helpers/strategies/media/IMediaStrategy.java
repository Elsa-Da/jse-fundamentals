package fr.aelion.helpers.strategies.media;

import fr.aelion.helpers.builders.MediaBuilder;
import fr.aelion.helpers.exceptions.NoMediaTypeException;
import fr.aelion.helpers.exceptions.NotEnoughArgsException;

public interface IMediaStrategy<T> {
    T castAs(MediaBuilder mediaBuilder) throws NoMediaTypeException, NotEnoughArgsException;
}
