package com.grepp.mc;

import com.google.gson.Gson;
import com.grepp.mc.infra.llm.GeminiChatModel;
import com.grepp.mc.infra.llm.gemini.text.vo.Content;
import com.grepp.mc.infra.llm.gemini.text.vo.Part;
import com.grepp.mc.infra.llm.gemini.text.vo.RequestDocument;
import com.grepp.mc.infra.llm.gemini.text.vo.generation.GenerationConfig;
import java.util.List;
import java.util.function.BiPredicate;

public class Run {

    public static void main(String[] args) {

        RequestDocument doc = new RequestDocument("오늘 저녁 추천해줘");

        new GeminiChatModel().invoke(doc);


    }
}
