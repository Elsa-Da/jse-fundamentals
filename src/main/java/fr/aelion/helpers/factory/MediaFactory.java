package fr.aelion.helpers.factory;

import fr.aelion.models.courses.Media;

public class MediaFactory {

    private final static String classRoot = "fr.aelion.models.courses";


    public Media getMedia(String mediaType) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        String className = mediaType.toLowerCase();
        className = String.valueOf(mediaType.charAt(0)).toUpperCase() + className.substring(1);
        return getInstance(className);
    }

    private Media getInstance(String mediaType) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        String className = MediaFactory.classRoot + "." + mediaType;
        return (Media) Class.forName(className).newInstance();
    }

}
