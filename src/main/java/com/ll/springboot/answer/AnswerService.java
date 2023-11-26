package com.ll.springboot.answer;

import com.ll.springboot.DataNotFoundException;
import com.ll.springboot.question.Question;
import com.ll.springboot.user.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

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

    public Answer getAnswer(Integer id) {
        Optional<Answer> answer = this.answerRepository.findById(id);
        if (answer.isPresent()) {
            return answer.get();
        } else {
            throw new DataNotFoundException("answer not found");
        }
    }

    public void modify(Answer answer, String content) {
        answer = answer.toBuilder()
                .content(content)
                .modifyDate(LocalDateTime.now())
                .build();
        this.answerRepository.save(answer);
    }

    public void delete(Answer answer) {
        this.answerRepository.delete(answer);
    }

    public void vote(Answer answer, SiteUser siteUser) {
        answer.getVoter().add(siteUser);
        this.answerRepository.save(answer);
    }
}
