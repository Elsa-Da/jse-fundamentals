package fr.aelion.helpers.dto;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
public class DtoMapper {
    /**
     * Transform the Object m to Object o
     * @param m Media Object i want to transform
     * @param dto Dto Object i want to obtain
     * @return Object dto
     */
    public Object map(Object m, Object dto) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Field[] oFields = dto.getClass().getDeclaredFields();
        String[] properties = new String[oFields.length];

        int i = 0;
        for (Field oField : oFields) {
            properties[i] = oField.getName();
            i++;
        }

        i = 0;
        for (String property : properties) {
            String getter = "get" + property.substring(0,1).toUpperCase() + property.substring(1);
            Method method = m.getClass().getSuperclass().getDeclaredMethod(getter,null);

            oFields[i].set(dto, method.invoke(m, null));
            i++;
        }

        return dto;
    }
}
