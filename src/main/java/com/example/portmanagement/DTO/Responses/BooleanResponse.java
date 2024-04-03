package com.example.portmanagement.DTO.Responses;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class BooleanResponse {
    private boolean isExist;
}