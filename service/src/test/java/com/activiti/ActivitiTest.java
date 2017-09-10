package com.activiti;

import org.activiti.engine.*;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.spring.ProcessEngineFactoryBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by chengyin on 2017/9/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/application-mybatis.xml","classpath:spring/application-activiti.xml"})
public class ActivitiTest {

    Logger logger = LoggerFactory.getLogger(ActivitiTest.class);

    @Autowired
    ProcessEngineFactoryBean processEngine;

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private IdentityService identityService;

    @Test
    public void testEvent() throws InterruptedException {
        repositoryService.createDeployment()
                .addClasspathResource("workflow/hello.bpmn")
                .deploy();
        System.out.println("Number of process definitions: " + repositoryService.createProcessDefinitionQuery().count());

        identityService.setAuthenticatedUserId("Jeff Dean");

        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("leave");
        System.out.println(processInstance.getId());
        System.out.println(processInstance.getProcessDefinitionId());
        System.out.println(processInstance.getProcessDefinitionKey());

        List<Task> tasks = taskService.createTaskQuery().taskAssignee("kermit").list();
        for (Task task : tasks) {
            System.out.println(task.getName() + " : " + task.getAssignee());

            taskService.claim(task.getId(), "kermit");
        }

        tasks = taskService.createTaskQuery().taskAssignee("kermit").list();
        for (Task task : tasks) {

            taskService.complete(task.getId());
            System.out.println(task.getName() + " : " + task.getId() + " completed ");
        }

        Thread.sleep(10 * 1000);

        tasks = taskService.createTaskQuery().taskAssignee("stone").list();
        for (Task task : tasks) {
            System.out.println(task.getName() + " : " + task.getAssignee());
            taskService.claim(task.getId(), "stone");
        }

        tasks = taskService.createTaskQuery().taskAssignee("stone").list();
        for (Task task : tasks) {
            taskService.complete(task.getId());
            System.out.println(task.getName() + " : " + task.getId() + " completed ");
        }

        tasks = taskService.createTaskQuery().taskAssignee("kermit").list();
        for (Task task : tasks) {
            System.out.println(task.getName() + " : " + task.getAssignee());
            taskService.claim(task.getId(), "kermit");
        }


        HistoricProcessInstance hpInstance =
                historyService.createHistoricProcessInstanceQuery()
                        .processInstanceId(processInstance.getId()).singleResult();
        System.out.println("end time: " + hpInstance.getEndTime());

    }
}
