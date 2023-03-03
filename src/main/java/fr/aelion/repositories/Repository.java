package fr.aelion.repositories;

import fr.aelion.helpers.CaseConverter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class Repository<T> {

    private Class<T> model;
    private String simpleName;

    protected Repository(Class<T> className) {
        this.model = className;
        this.simpleName = model.getSimpleName();
    }

    public String getTableName() {
        return simpleName.toLowerCase();
    }

    public String getAliasedTableName() {
        return getTableName() + " " + getTableName().substring(0, 1);
    }

    public String[] getFields() {
        var current = model;
        var stringFields = new ArrayList<String>();
        while (current.getSuperclass() != null) {
            // Let's do stuff
            stringFields.addAll(
                    Arrays.asList(
                            Arrays.stream(current.getDeclaredFields())
                                    .map(f -> f.getName())
                                    .collect(Collectors.toSet())
                                    .toArray(new String[0])
                    )
            );
            current = (Class<T>) current.getSuperclass();
        }

        return stringFields.toArray(new String[0]);
    }

    public String getCommaSeparatedColumns() {

        String commaSeparatedColumns = "";
        String[] fields = getFields();
        Arrays.sort(fields);

        var tableNameFirstChar = getTableName().substring(0, 1);

        for (String field : fields) {
            var fieldName = CaseConverter.camelToSnake(field);
            commaSeparatedColumns += tableNameFirstChar + "." + fieldName + ",";
        }

        return commaSeparatedColumns.substring(0, commaSeparatedColumns.length()-1);
    }

    public String getSelectQuery() {
        return "SELECT " + getCommaSeparatedColumns() + " FROM " + getAliasedTableName() + ";";
    }

}
