package fr.aelion.helpers.dto;

import fr.aelion.helpers.dto.annotations.ClassInitial;

import java.lang.annotation.Annotation;
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
            Annotation annotation = oFields[i].getAnnotation(ClassInitial.class);
            if (annotation == null) {
                String getter = "get" + property.substring(0, 1).toUpperCase() + property.substring(1);
                Method method = m.getClass().getSuperclass().getDeclaredMethod(getter, null);

                oFields[i].set(dto, method.invoke(m, null));
            } else {
               String initial = m.getClass().getSimpleName().substring(0,1);
               oFields[i].set(dto,initial);
            }
            i++;
        }

        return dto;
    }
}
