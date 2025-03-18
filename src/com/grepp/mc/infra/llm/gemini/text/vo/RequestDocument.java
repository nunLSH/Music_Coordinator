package com.grepp.mc.infra.llm.gemini.text.vo;

import com.grepp.mc.infra.llm.gemini.text.vo.generation.GenerationConfig;
import java.util.List;

public record RequestDocument<T>(
    List<Content> contents,
    GenerationConfig<T> generationConfig
) {

}
