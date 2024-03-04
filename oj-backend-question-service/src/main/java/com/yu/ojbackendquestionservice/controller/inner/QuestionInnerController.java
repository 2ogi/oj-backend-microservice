package com.yu.ojbackendquestionservice.controller.inner;

import com.yu.ojbackendmodel.model.entity.Question;
import com.yu.ojbackendmodel.model.entity.QuestionSubmit;
import com.yu.ojbackendmodel.model.entity.User;
import com.yu.ojbackendquestionservice.service.QuestionService;
import com.yu.ojbackendquestionservice.service.QuestionSubmitService;
import com.yu.ojbackendserviceclient.service.QuestionFeignClient;
import com.yu.ojbackendserviceclient.service.UserFeignClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * 该服务仅内部调用，不是提供给前端的
 */
@RestController
@RequestMapping("/inner")
public class QuestionInnerController implements QuestionFeignClient {

    @Resource
    private QuestionService questionService;

    @Resource
    private QuestionSubmitService questionSubmitService;

    @GetMapping("/get/id")
    public Question getQuestionById(@RequestParam("questionId") long questionId){
        return questionService.getById(questionId);
    }

    @GetMapping("/question_submit/get/id")
    public QuestionSubmit getQuestionSubmitById(@RequestParam("questionSubmitId") long questionSubmitId){
        return questionSubmitService.getById(questionSubmitId);
    }

    @PostMapping("question_submit/update")
    public boolean updateQuestionSubmitById(@RequestBody QuestionSubmit questionSubmit){
        return questionSubmitService.updateById(questionSubmit);
    }
}
