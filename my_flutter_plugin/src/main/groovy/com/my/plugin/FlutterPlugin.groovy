package com.my.plugin

import com.android.build.gradle.AppExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * 修复flutter 2.5.3 bug plugin
 * https://github.com/flutter/flutter/issues/94329
 */
class FlutterPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        //注册Transform
        def androidConfig = project.extensions.getByType(AppExtension)
        MyClassTransform transform = new MyClassTransform()
        androidConfig.registerTransform(transform)
    }
}