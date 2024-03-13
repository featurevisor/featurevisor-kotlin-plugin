package com.featurevisor.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Optional
import org.gradle.api.tasks.TaskAction
import com.featurevisor.testRunner.*

open class RunAllTestsTask : DefaultTask() {

    companion object {
        const val NAME = "run-test"
    }

    @Input
    @Optional
    var rootProjectPath: String? = null

    @Input
    @Optional
    var testDirPath: String? = null

    @Input
    @Optional
    var featureName: String? = null

    @Input
    @Optional
    var segmentName: String? = null

    @TaskAction
    fun executeTask() {

        when {
            (rootProjectPath.isNullOrEmpty().not() && testDirPath.isNullOrEmpty().not()) -> {
                startTest(rootProjectPath.orEmpty(), testDirPath.orEmpty())
            }

            (rootProjectPath.isNullOrEmpty().not() && featureName.isNullOrEmpty().not()) -> {
                testSingleFeature(featureKey = featureName.orEmpty(), projectRootPath = rootProjectPath.orEmpty())
            }

            (rootProjectPath.isNullOrEmpty().not() && segmentName.isNullOrEmpty().not()) -> {
                testSingleSegment(segmentKey = segmentName.orEmpty(), projectRootPath = rootProjectPath.orEmpty())
            }

            rootProjectPath.isNullOrEmpty().not() -> {
                startTest(projectRootPath = rootProjectPath.orEmpty())
            }

            testDirPath.isNullOrEmpty().not() -> {
                startTest(testDirPath = testDirPath.orEmpty(), projectRootPath = project.projectDir.absolutePath)
            }

            featureName.isNullOrEmpty().not() -> {
                testSingleFeature(featureKey = featureName.orEmpty(), projectRootPath = project.projectDir.absolutePath)
            }

            segmentName.isNullOrEmpty().not() -> {
                testSingleSegment(segmentKey = segmentName.orEmpty(), projectRootPath = project.projectDir.absolutePath)
            }

            else -> {
                startTest(projectRootPath = project.projectDir.absolutePath)
            }
        }
    }
}