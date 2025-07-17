package org.endow.framework.test

import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import org.endow.framework.EndowFramework
import org.endow.framework.entity.DefaultRequest
import org.endow.framework.entity.Message
import org.endow.framework.model.ChatModel
import org.endow.framework.service.ChatService
import org.endow.framework.toolcall.ToolContainer

fun main() {
    EndowFramework.init(arrayOf("org.endow.framework.test"))
    runBlocking {
        val chatService = ChatService(
            ChatModel(
                baseUrl = "https://dashscope.aliyuncs.com/compatible-mode/v1/chat/completions",
                apiKey = "sk-152dd4d7753a4e7e9f4f5362fd5a9815",
                modelName = "qwen-plus"
            )
        )

        val defaultRequest = DefaultRequest(
            messages = mutableListOf(
                Message.system("你是一个助手，请回答我的问题。"),
                Message.user("生命的意义是什么？")
            )
        ).apply {
            stream = true
            tools = ToolContainer.getTools("default")
        }
        println(chatService.execChat(defaultRequest).value)
//        chatService.execChat(defaultRequest).stream
//            .map { data ->
//                print("${data.choices?.get(0)?.delta?.content}")
//            }
//            .collect()
    }

}