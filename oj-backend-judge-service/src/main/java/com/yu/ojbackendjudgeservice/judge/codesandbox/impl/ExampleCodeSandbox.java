package com.yu.ojbackendjudgeservice.judge.codesandbox.impl;



import com.yu.ojbackendjudgeservice.judge.codesandbox.CodeSandbox;
import com.yu.ojbackendmodel.enums.JudgeInfoMessageEnum;
import com.yu.ojbackendmodel.enums.QuestionSubmitStatusEnum;
import com.yu.ojbackendmodel.model.codesandbox.ExecuteCodeRequest;
import com.yu.ojbackendmodel.model.codesandbox.ExecuteCodeResponse;
import com.yu.ojbackendmodel.model.codesandbox.JudgeInfo;

import java.util.List;

/**
 * 示例代码沙箱
 */
public class ExampleCodeSandbox implements CodeSandbox {

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        List<String> inputList = executeCodeRequest.getInputList();
        ExecuteCodeResponse executeCodeResponse = new ExecuteCodeResponse();
        executeCodeResponse.setOutputList(inputList);
        executeCodeResponse.setMessage("测试执行成功");
        executeCodeResponse.setStatus(QuestionSubmitStatusEnum.SUCCEED.getValue());
        JudgeInfo judgeInfo = new JudgeInfo();
        judgeInfo.setMessage(JudgeInfoMessageEnum.ACCEPTED.getText());
        judgeInfo.setMemory(100L);
        judgeInfo.setTime(100L);
        executeCodeResponse.setJudgeInfo(judgeInfo);
        return executeCodeResponse;
    }
}
