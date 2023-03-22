package com.sha.springbootmicroserviceproduct.Model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;


@Data
public abstract class BaseDto {
    private Long id;

    private Integer version;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
