package org.endow.framework.entity

import com.google.gson.annotations.SerializedName

class Message {
    var content: String? = null
    var refusal: Any? = null
    var role: String? = null

    @SerializedName("tool_calls")
    var toolCalls: MutableList<ChatResponse.ToolCall>? = null

    @SerializedName("function_call")
    var functionCall: ChatResponse.FunctionCall? = null

    var audio: String? = null

    @SerializedName("tool_call_id")
    var toolCallID: String? = null

    constructor(role: String, content: String) {
        this.role = role
        this.content = content
    }

    constructor(role: String, content: String, toolCallID: String?) {
        this.role = role
        this.content = content
        this.toolCallID = toolCallID
    }

    override fun toString(): String {
        return "Message{" +
                "content='" + content + '\'' +
                ", refusal=" + refusal +
                ", role='" + role + '\'' +
                ", toolCalls=" + toolCalls +
                ", functionCall=" + functionCall +
                ", audio='" + audio + '\'' +
                ", toolCallID='" + toolCallID + '\'' +
                '}'
    }

    companion object {
        fun of(role: String, content: String): Message {
            return Message(role, content)
        }

        fun system(content: String): Message {
            return Message("system", content)
        }

        fun assistant(content: String): Message {
            return Message("assistant", content)
        }

        fun user(content: String): Message {
            return Message("user", content)
        }

        fun tool(content: String, toolCallId: String): Message {
            return Message("tool", content, toolCallId)
        }
    }
}