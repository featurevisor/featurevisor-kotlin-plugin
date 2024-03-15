package com.featurevisor.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction
import com.featurevisor.testRunner.*
import org.gradle.api.tasks.options.Option

open class RunAllTestsTask : DefaultTask() {

    companion object {
        const val NAME = "test"
    }

    @Input
    @Option(option = "rootProjectPath", description = "Whether to run test for specific project")
    var rootProjectPath: String = project.projectDir.absolutePath

    @Input
    @Option(option = "testDirPath", description = "Whether to run test for specific test directory")
    var testDirPath: String = "tests"

    @Input
    @Option(option = "keyPattern", description = "Run test for specific key pattern")
    var keyPattern: String = ""

    @Input
    @Option(option = "assertionPattern", description = "Run test for specific assertion pattern")
    var assertionPattern: String = ""

    @Input
    @Option(option = "verbose", description = "Whether to run tests in verbose mode")
    var verbose: Boolean = false

    @Input
    @Option(option = "showDatafile", description = "Whether to run tests by showing datafile")
    var showDatafile: Boolean = false

    @Input
    @Option(option = "onlyFailures", description = "Whether to run tests by showing only failed tests")
    var onlyFailures: Boolean = false

    @Input
    @Option(option = "fast", description = "Whether to run tests in fast mode")
    var fast: Boolean = false

    @TaskAction
    fun executeTask() {

        val testProjectOption = TestProjectOption(
            keyPattern = keyPattern,
            assertionPattern = assertionPattern,
            verbose = verbose,
            showDatafile = showDatafile,
            onlyFailures = onlyFailures,
            fast = fast,
            projectRootPath = rootProjectPath,
            testDirPath = testDirPath
        )

        startTest(testProjectOption)
    }
}