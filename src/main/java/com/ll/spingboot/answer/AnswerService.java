package com.ll.spingboot.answer;

import com.ll.spingboot.question.Question;
import com.ll.spingboot.user.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class AnswerService {

    private final AnswerRepository answerRepository;

    public Answer create(Question question, String content, SiteUser author) {
        Answer a = Answer.builder()
                .question(question)
                .content(content)
                .createDate(LocalDateTime.now())
                .author(author)
                .build();
        this.answerRepository.save(a);

        return a;
    }
}
