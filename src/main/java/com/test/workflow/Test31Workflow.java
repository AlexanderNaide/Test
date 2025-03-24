package com.test.workflow;

import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.serviceclient.WorkflowServiceStubs;

public class Test31Workflow {
    public static void main(String[] args) {
        WorkflowServiceStubs serviceStub = WorkflowServiceStubs.newLocalServiceStubs();
        WorkflowClient client = WorkflowClient.newInstance(serviceStub);
        WorkflowOptions options = WorkflowOptions.newBuilder()
                .setTaskQueue(Shared.INSTANCE.getPROMPT_REJECTION_PROCESSING_QUEUE())
                .setWorkflowId("test_create_task_by_workflow-2")
                .build();
        PromptRejectionProcessing workflow = client.newWorkflowStub(PromptRejectionProcessing.class, options);

        TaskTransferData transferData = new TaskTransferData(16, "8-951-6691", "Вася Иванов");

        WorkflowClient.start(workflow::processing, transferData);
//        System.exit(0);
    }
}
