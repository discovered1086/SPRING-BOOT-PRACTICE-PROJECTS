package com.kingshuk.springboot.springbootmvc.validator;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter<String, Date> {
    /**
     * Convert the source object of type {@code S} to target type {@code T}.
     *
     * @param source the source object to convert, which must be an instance of {@code S} (never {@code null})
     * @return the converted object, which must be an instance of {@code T} (potentially {@code null})
     * @throws IllegalArgumentException if the source cannot be converted to the desired target type
     */
    @Override
    public Date convert(String source) {
        try {
            System.out.println("Inside the converter");

            if (!"".equals(source))
                return new SimpleDateFormat("mm-dd-yyyy").parse(source);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }
}
