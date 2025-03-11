package com.yueban.graph

import com.yueban.graph.CourseSchedule.courseSchedule1
import com.yueban.graph.CourseSchedule.courseSchedule2
import kotlin.test.Test
import kotlin.test.assertEquals

class CourseScheduleTest {
  class TestCase(
    val numCourses: Int,
    val prerequisites: Array<IntArray>,
    val result: Boolean,
  )

  private val testCases = listOf(
    TestCase(2, arrayOf(intArrayOf(1, 0)), true),
    TestCase(2, arrayOf(intArrayOf(1, 0), intArrayOf(0, 1)), false),
  )

  @Test
  fun courseSchedule1Test() {
    testCases.forEach { case ->
      assertEquals(case.result, courseSchedule1(case.numCourses, case.prerequisites))
    }
  }

  @Test
  fun courseSchedule2Test() {
    testCases.forEach { case ->
      assertEquals(case.result, courseSchedule2(case.numCourses, case.prerequisites))
    }
  }
}
