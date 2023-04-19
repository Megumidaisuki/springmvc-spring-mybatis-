package com.megumi.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResult<T> {
    private Integer currentPage;
    private Integer pageSize;
    private Integer total;
    private List<T> data;
}
