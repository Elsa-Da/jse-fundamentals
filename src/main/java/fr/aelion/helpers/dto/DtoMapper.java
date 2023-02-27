package fr.aelion.helpers.dto;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class DtoMapper {
    /**
     * Transform the Object m to Object o
     * @param m Media Object i want to transform
     * @param o Dto Object i want to obtain
     * @return Object dto
     */
    public String[] map(Object m, Object o) {
        Field[] oFields = o.getClass().getDeclaredFields();
        String[] fields = new String[oFields.length];

        int i = 0;
        for (Field oField : oFields) {
            fields[i] = oField.getName();
            i++;
        }

        Arrays.sort(fields, Collections.reverseOrder());

        return fields;
    }
}
