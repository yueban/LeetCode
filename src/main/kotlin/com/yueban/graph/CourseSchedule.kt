package com.yueban.graph

import java.util.*

object CourseSchedule {
  fun courseSchedule1(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
    // adjacencyList[i] represents courses which pre-course is course i
    val adjacencyList = Array<MutableList<Int>>(numCourses) { mutableListOf() }
    // inDegree[i] represents how many pre-courses that course i have
    val inDegree = IntArray(numCourses)

    // populate the adjacency list and in-degree array
    prerequisites.forEach { (course, prereq) ->
      adjacencyList[prereq].add(course)
      inDegree[course]++
    }

    // initialize the queue with courses having zero in-degree, which means courses without pre-course
    val queue: Queue<Int> = LinkedList()
    for (i in 0 until numCourses) {
      if (inDegree[i] == 0) {
        queue.add(i)
      }
    }

    // visitedCourses represents count of courses which have no other pre-courses and can be visited
    // every time a course popup from queue, do two things:
    // 1. visitedCourses++
    // 2. iterate courses in adjacencyList[course], these courses are depend on course.
    //    Now course can be visited so that these courses in inDegree can be reduced by 1.
    //    if the inDegree value after reducing is zero which means the course now has no other pre-courses and can be visited,
    //    add it to queue and loop from step 1.
    var visitedCourses = 0
    while (queue.isNotEmpty()) {
      val course = queue.poll()
      visitedCourses++

      for (nextCourse in adjacencyList[course]) {
        inDegree[nextCourse]--
        if (inDegree[nextCourse] == 0) {
          queue.add(nextCourse)
        }
      }
    }

    return visitedCourses == numCourses
  }

  fun courseSchedule2(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
    // prereqList represents all courses with their pre-courses
    val prereqList = Array<MutableList<Int>>(numCourses) { mutableListOf() }
    prerequisites.forEach { (course, pre) ->
      prereqList[course] += pre
    }

    val status_visited = 1
    val status_visiting = 2

    // record all courses status (0:idle, 1:status_visited, 2:status_visiting)
    val coursesStatus = IntArray(numCourses)

    // determine if course can be visited using dfs
    fun dfs(course: Int): Boolean = when (coursesStatus[course]) {
      // the course status is visiting which means there is a depending circle
      status_visiting -> false
      status_visited -> true
      else -> {
        // for course status is idle, do following steps:
        // 1. mark course status as visiting
        // 2. check if all pre-courses for current course can be visited using dfs
        // 3. mark course status as visited
        coursesStatus[course] = status_visiting
        val result = prereqList[course].all { dfs(it) }
        coursesStatus[course] = status_visited
        result
      }
    }

    // ensure all courses which have pre-courses can be visited
    return prereqList.indices.all { dfs(it) }
  }
}
