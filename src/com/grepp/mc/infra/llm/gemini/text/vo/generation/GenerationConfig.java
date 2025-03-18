package com.grepp.mc.infra.llm.gemini.text.vo.generation;

public record GenerationConfig<T>(
    String responseMimeType,
    Schema<T> responseSchema
) {

    public GenerationConfig(Schema<T> responseSchema) {
        this("application/json", responseSchema);
    }

    public GenerationConfig(T properties){
        this(new Schema<>(properties));
    }
}
