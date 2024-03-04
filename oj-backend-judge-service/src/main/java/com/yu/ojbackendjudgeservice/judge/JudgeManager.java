package com.yu.ojbackendjudgeservice.judge;


import com.yu.ojbackendjudgeservice.judge.strategy.DefaultJudgeStrategy;
import com.yu.ojbackendjudgeservice.judge.strategy.JavaLanguageJudgeStrategy;
import com.yu.ojbackendjudgeservice.judge.strategy.JudgeContext;
import com.yu.ojbackendjudgeservice.judge.strategy.JudgeStrategy;
import com.yu.ojbackendmodel.model.codesandbox.JudgeInfo;
import com.yu.ojbackendmodel.model.entity.QuestionSubmit;
import org.springframework.stereotype.Service;

/**
 * 判题管理（简化调用）
 */
@Service
public class JudgeManager {

    /**
     * 执行判题
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext){
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if(language.equals("java")){
            judgeStrategy = new JavaLanguageJudgeStrategy();
        }
        return judgeStrategy.doJudge(judgeContext);
    }
}
