package com.operation.api.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Builder
@Getter
@Setter
public class GetMessageRequest {
    private ArrayList<ArrayList<String>> messages;
}