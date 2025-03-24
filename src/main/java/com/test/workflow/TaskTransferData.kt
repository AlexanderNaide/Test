package com.test.workflow

import com.fasterxml.jackson.databind.annotation.JsonDeserialize

@JsonDeserialize
class TaskTransferData(
    var taskId: Int?,
    var phone: String?,
    var name: String?
)