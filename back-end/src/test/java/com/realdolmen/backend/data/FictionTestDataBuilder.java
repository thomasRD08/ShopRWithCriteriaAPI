package com.realdolmen.backend.data;

import com.realdolmen.backend.domain.Fiction;
import com.realdolmen.backend.domain.FictionGenre;
import com.realdolmen.backend.dto.FictionDto;

public class FictionTestDataBuilder {
    public static Fiction.FictionBuilder buildFictionTheHelp() {
        return Fiction.builder()
                .title("The Help")
                .price(14D)
                .type("Fiction")
                .author("Kathryn Stockett")
                .isbn("978-039-915-534-5")
                .pages("465")
                .fictionGenre(FictionGenre.ROMANCE)
                .summary("Test");
    }

    public static Fiction.FictionBuilder buildFictionTheKiteRunner() {
        return Fiction.builder()
                .title("The Kite Runner")
                .price(12D)
                .type("Fiction")
                .author("Khaled Hosseini")
                .isbn("978-159-448-000-3")
                .pages("371")
                .fictionGenre(FictionGenre.THRILLER)
                .summary("Test");
    }

    public static FictionDto.FictionDtoBuilder buildFictionDtoTheHelp() {
        return FictionDto.builder()
                .title("The Help")
                .price(14D)
                .type("Fiction")
                .author("Kathryn Stockett")
                .isbn("978-039-915-534-5")
                .pages("465")
                .fictionGenre(FictionGenre.ROMANCE)
                .summary("Test");
    }
}
