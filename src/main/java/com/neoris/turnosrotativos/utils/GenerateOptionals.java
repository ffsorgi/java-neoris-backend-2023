package com.neoris.turnosrotativos.utils;

import java.time.LocalDate;
import java.util.Optional;

public class GenerateOptionals {

    public static Optional<String> optionalString(String string){
        Optional<String> optional = Optional.ofNullable(string);
        return optional;
    }

    public static Optional<Integer> optionalInteger(Integer integer){
        Optional<Integer> optional = Optional.ofNullable(integer);
        return optional;
    }

    public static Optional<LocalDate> optionalLocalDate(LocalDate localDate){
        Optional<LocalDate> optional = Optional.ofNullable(localDate);
        return optional;
    }

}
