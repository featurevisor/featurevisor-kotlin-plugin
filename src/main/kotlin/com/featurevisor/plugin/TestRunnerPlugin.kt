package com.featurevisor.plugin

import com.featurevisor.tasks.RunAllTestsTask
import org.gradle.api.Plugin
import org.gradle.api.Project

class TestRunnerPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.tasks.register(RunAllTestsTask.NAME,RunAllTestsTask::class.java)
    }
}