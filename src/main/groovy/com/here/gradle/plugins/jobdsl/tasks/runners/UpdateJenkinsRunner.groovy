package com.here.gradle.plugins.jobdsl.tasks.runners

import com.here.gradle.plugins.jobdsl.RestJobManagement
import javaposse.jobdsl.dsl.DslScriptLoader

def properties = System.getProperties()

def jenkinsUrl = properties['jenkinsUrl']
def jenkinsUser = properties['jenkinsUser']
def jenkinsPassword = properties['jenkinsPassword']

def jobManagement = new RestJobManagement(jenkinsUrl, jenkinsUser, jenkinsPassword)

properties['inputFiles'].split(':').each { String filename ->
    println "Loading ${filename}"
    DslScriptLoader.runDslEngine(new File(filename).text, jobManagement)
}