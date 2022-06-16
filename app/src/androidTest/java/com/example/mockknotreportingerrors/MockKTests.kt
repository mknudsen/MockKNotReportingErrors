package com.example.mockknotreportingerrors

import io.mockk.every
import io.mockk.isMockKMock
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

class MockKTests {

    @Test
    fun canNotMockClosedImplementation() {

        class CannotMockedClosedImplExample {
            fun someFunction() {
            }
        }

        val instanceOfConcreteClass: CannotMockedClosedImplExample = mockk()

        val isMock = isMockKMock(instanceOfConcreteClass)

        if (isMock) {
            every { instanceOfConcreteClass.someFunction() } returns Unit

            instanceOfConcreteClass.someFunction()
            verify { instanceOfConcreteClass.someFunction() }
        }
    }
}