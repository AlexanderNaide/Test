package com.test.workflow

import io.temporal.workflow.WorkflowInterface
import io.temporal.workflow.WorkflowMethod

@WorkflowInterface
fun interface PromptRejectionProcessing {

    @WorkflowMethod
    fun processing(task: TaskTransferData)
}