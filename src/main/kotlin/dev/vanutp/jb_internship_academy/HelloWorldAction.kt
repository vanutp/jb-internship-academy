package dev.vanutp.jb_internship_academy

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages

class HelloWorldAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        @Suppress("DialogTitleCapitalization")
        Messages.showInfoMessage("Hello World!", "\uD83E\uDD8A")
    }
}
