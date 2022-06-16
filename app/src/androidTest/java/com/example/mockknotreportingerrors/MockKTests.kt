package com.example.mockknotreportingerrors

import io.mockk.every
import io.mockk.isMockKMock
import io.mockk.mockk
import io.mockk.verify
import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.Test

class MockKTests {

    @Test
    fun canNotMockClosedImplementation() {

        class CannotMockedClosedImplExample {
            fun someFunction() {
            }
        }

        val instanceOfConcreteClass: CannotMockedClosedImplExample = mockk()

        assertFalse(isMockKMock(Object()))
        assertFalse(isMockKMock("foo"))
        assertFalse(isMockKMock(CannotMockedClosedImplExample()))

        val isMock = isMockKMock(instanceOfConcreteClass)

        if (isMock) {
            every { instanceOfConcreteClass.someFunction() } returns Unit

            instanceOfConcreteClass.someFunction()
            verify { instanceOfConcreteClass.someFunction() }
        }
    }
}