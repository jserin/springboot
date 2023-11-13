package com.ll.spingboot.answer;

import com.ll.spingboot.question.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class AnswerService {

    private final AnswerRepository answerRepository;

    public Answer create(Question question, String content) {
        Answer a = Answer.builder()
                .question(question)
                .content(content)
                .createDate(LocalDateTime.now())
                .build();
        this.answerRepository.save(a);

        return a;
    }
}
