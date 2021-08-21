package com.sibyl;

import lombok.extern.slf4j.Slf4j;
import org.activiti.api.process.model.ProcessDefinition;
import org.activiti.api.process.model.ProcessInstance;
import org.activiti.api.process.model.builders.ProcessPayloadBuilder;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.api.runtime.shared.query.Page;
import org.activiti.api.runtime.shared.query.Pageable;
import org.activiti.api.task.model.Task;
import org.activiti.api.task.model.builders.TaskPayloadBuilder;
import org.activiti.api.task.runtime.TaskRuntime;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Classname ActivitiTest
 * @Description TODO
 * @Date 2021/8/21 22:44
 * @Created by dyingleaf3213
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
@Slf4j
public class ActivitiTest {
    @Autowired
    private SecurityUtil securityUtil;
    @Autowired
    private ProcessRuntime processRuntime;
    @Autowired
    private TaskRuntime taskRuntime;

    @org.junit.Test
    public void testTask(){
        securityUtil.logInAs("salaboy");
        Page<Task> tasks = taskRuntime.tasks(Pageable.of(0, 10));
        for (Task task:tasks.getContent()){
            taskRuntime.claim(TaskPayloadBuilder.claim().withTaskId(task.getId()).build());
            taskRuntime.complete(TaskPayloadBuilder.complete().withTaskId(task.getId()).build());
        }
        System.err.println("null");
    }

    @org.junit.Test
    public void testStart(){
        securityUtil.logInAs("salaboy");
        ProcessInstance processInstance = processRuntime.start(
                ProcessPayloadBuilder.start().withProcessDefinitionKey("evt01").build());
        System.err.println(processInstance);
    }

    @org.junit.Test
    public void testQuery(){
        securityUtil.logInAs("salaboy");
        Page<ProcessDefinition> processDefinitionPage = processRuntime.processDefinitions(Pageable.of(0, 10));

        System.err.println("null");
    }
}
