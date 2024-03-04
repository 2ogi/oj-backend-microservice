package com.yu.ojbackendjudgeservice.judge.codesandbox;


import com.yu.ojbackendmodel.model.codesandbox.ExecuteCodeRequest;
import com.yu.ojbackendmodel.model.codesandbox.ExecuteCodeResponse;

/**
 * 代码沙箱
 */
public interface CodeSandbox {
    /**
     * 执行代码
     * @param executeCodeRequest
     * @return
     */
    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);
}
