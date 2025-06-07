package org.skypro.skyshop.search;

public interface Searchable {
    String searchTerm();

    String getContentType();

    default String getStringRepresentation() {
        return "Имя объекта- %s Тип объекта- %s".formatted(searchTerm(), getContentType());
    }
}