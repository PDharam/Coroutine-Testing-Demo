package com.pdharam.coroutinetesting


import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class UtilTest {

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()


    @Test
    fun testGetUser() {
        val sut = Util(mainCoroutineRule.testDispatcher)
        runTest {
            sut.getAddressDetails()
            mainCoroutineRule.testDispatcher.scheduler.advanceUntilIdle()
            assertEquals(true, sut.globalArg)
        }
    }

}