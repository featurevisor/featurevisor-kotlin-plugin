package com.featurevisor.plugin

import com.featurevisor.tasks.RunAllTestsTask
import org.gradle.api.Plugin
import org.gradle.api.Project

class TestRunnerPlugin : Plugin<Project> {
    override fun apply(project: Project) {

        project.tasks.register(RunAllTestsTask.NAME,RunAllTestsTask::class.java){  task ->
            task.rootProjectPath = project.findProperty("rootProjectPath") as? String
            task.testDirPath = project.findProperty("testDirPath") as? String
            task.featureName = project.findProperty("featureName") as? String
            task.segmentName = project.findProperty("segmentName") as? String
        }

    }
}