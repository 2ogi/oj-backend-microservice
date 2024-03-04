package com.yu.ojbackendjudgeservice.judge.strategy;


import com.yu.ojbackendmodel.model.codesandbox.JudgeInfo;

public interface JudgeStrategy {

    /**
     * 执行判题
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext);
}
