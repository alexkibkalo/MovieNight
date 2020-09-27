package com.kharkiv.movienight.transport.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UserAgreementDto {

    @NotNull
    private boolean agreement;
}
