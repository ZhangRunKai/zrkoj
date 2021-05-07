package com.zrk.entity.sandbox;

import lombok.Data;

/**
 * @author zhang run kai
 * @version 1.0
 * @date 2021/4/2 15:12
 */
@Data
public class SandboxRequest {
    //沙盒指令
    private String command;
    private SandboxSubmit problem;

    public SandboxRequest() {
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command.toUpperCase();
    }

    public SandboxSubmit getProblem() {
        return problem;
    }

    public void setProblem(SandboxSubmit problem) {
        this.problem = problem;
    }
}
