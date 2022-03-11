package com.dhk.expensetrackerapi.service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PageResponseDto<T> {

    private List<T> content;

    private boolean isLastPage;
    private int page;
    private int size;
    private int totalPages;
    private long totalElements;
}
