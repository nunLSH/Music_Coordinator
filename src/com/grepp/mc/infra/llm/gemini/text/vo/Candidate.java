package com.grepp.mc.infra.llm.gemini.text.vo;

import java.util.List;

public record Candidate (
    Content content,
    String finishReason,
    Double avgLogprobs
){

}
