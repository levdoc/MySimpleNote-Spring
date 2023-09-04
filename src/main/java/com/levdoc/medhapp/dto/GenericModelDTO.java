package com.levdoc.medhapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public abstract class GenericModelDTO {
    private Long id;
    private LocalDateTime createdWhen;
    private LocalDateTime sendWhen;
    private boolean isDeleted;
}
