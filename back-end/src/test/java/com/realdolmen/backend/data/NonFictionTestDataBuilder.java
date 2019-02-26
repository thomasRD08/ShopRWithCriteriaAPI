package com.realdolmen.backend.data;

import com.realdolmen.backend.domain.NonFiction;
import com.realdolmen.backend.domain.NonFictionSubject;
import com.realdolmen.backend.dto.NonFictionDto;

import java.math.BigDecimal;

public class NonFictionTestDataBuilder {
    public static NonFiction.NonFictionBuilder buildNonFictionAncientEgypt() {
        return NonFiction.builder()
                .title("The Oxford History of Ancient Egypt")
                .price(new BigDecimal(18.00))
                .type("Non-fiction")
                .author("Ian Shaw")
                .isbn("978-019-815-034-3")
                .pages("554")
                .nonFictionSubject(NonFictionSubject.HISTORY);
    }

    public static NonFiction.NonFictionBuilder buildNonFictionCooking() {
        return NonFiction.builder()
                .title("Cooking Basics for Dummies")
                .price(new BigDecimal(9.00))
                .type("Non-fiction")
                .author("Bryan Miller")
                .isbn("978-076-457-206-7")
                .pages("436")
                .nonFictionSubject(NonFictionSubject.COOKBOOK);
    }

    public static NonFictionDto.NonFictionDtoBuilder buildNonFictionDtoAncientEgypt() {
        return NonFictionDto.builder()
                .title("The Oxford History of Ancient Egypt")
                .price(new BigDecimal(18.00))
                .type("Non-fiction")
                .author("Ian Shaw")
                .isbn("978-019-815-034-3")
                .pages("554")
                .nonFictionSubject(NonFictionSubject.HISTORY.getLabel());
    }
}
