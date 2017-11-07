package com.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.task.listener.annotation.AfterTask;
import org.springframework.cloud.task.listener.annotation.BeforeTask;
import org.springframework.cloud.task.listener.annotation.FailedTask;
import org.springframework.cloud.task.repository.TaskExecution;
import org.springframework.stereotype.Component;

/**
 * @author zhenghuasheng
 * @date 2017/10/27.16:06
 */
@Component
public class TaskListener {
    Logger logger = LoggerFactory.getLogger(TaskListener.class);
    @BeforeTask
    public void methodA(TaskExecution taskExecution) {
        logger.info("before task ");
    }

    @AfterTask
    public void methodB(TaskExecution taskExecution) {
        logger.info("after task ");

    }

    @FailedTask
    public void methodC(TaskExecution taskExecution, Throwable throwable) {
        logger.info("failed task ");
    }
}
