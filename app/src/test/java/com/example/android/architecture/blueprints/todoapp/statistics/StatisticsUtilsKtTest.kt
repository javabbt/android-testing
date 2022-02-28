package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.junit.Assert.*
import org.junit.Test

class StatisticsUtilsKtTest{

    @Test
    fun getActiveAndCompleteStats_noCompleted_returnsHundredZero(){
        val tasks = listOf<Task>(
            Task("title" , "desc" , isCompleted = false)
        )
        val per = getActiveAndCompletedStats(tasks)
        assertEquals(per.completedTasksPercent , 0f)
        assertEquals(per.activeTasksPercent , 100f)
    }

    @Test
    fun getActiveAndCompleteStats_noActive_returnsHundredZero(){
        val tasks = listOf<Task>(
            Task("title" , "desc" , isCompleted = true)
        )
        val per = getActiveAndCompletedStats(tasks)
        assertEquals(per.completedTasksPercent , 100f)
        assertEquals(per.activeTasksPercent , 0f)
    }

    @Test
    fun getActiveAndCompleteStats_both_returnsFourthySize(){
        val tasks = listOf<Task>(
            Task("title" , "desc" , isCompleted = true),
            Task("title" , "desc" , isCompleted = true),
            Task("title" , "desc" , isCompleted = true),
            Task("title" , "desc" , isCompleted = false),
            Task("title" , "desc" , isCompleted = false)
        )
        val per = getActiveAndCompletedStats(tasks)
        assertEquals(per.completedTasksPercent , 60f)
        assertEquals(per.activeTasksPercent , 40f)
    }

    @Test
    fun getActiveAndCompleteStats_empty_list_returnsHundredZero(){
        val tasks = listOf<Task>()
        val per = getActiveAndCompletedStats(tasks)
        assertEquals(per.completedTasksPercent , 0f)
        assertEquals(per.activeTasksPercent , 0f)
    }

    @Test
    fun getActiveAndCompleteStats_null_list_returnsHundredZero(){
        val tasks = null
        val per = getActiveAndCompletedStats(null)
        assertEquals(per.completedTasksPercent , 0f)
        assertEquals(per.activeTasksPercent , 0f)
    }
}