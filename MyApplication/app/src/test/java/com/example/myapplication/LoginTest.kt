import org.junit.Assert.*
import org.junit.Test
import java.lang.reflect.Method
import com.example.myapplication.Login as Login1

class LoginTest {

    @Test
    fun emailIsEmpty_shouldReturnFalse() {
        val login = Login1()
        val method = getPrivateMethod(login, "isEmailValid", String::class.java)

        val result = method.invoke(login, "") as Boolean
        assertFalse("Empty email should be invalid", result)
    }

    @Test
    fun emailIsInvalidPattern_shouldReturnFalse() {
        val login = Login1()
        val method = getPrivateMethod(login, "isEmailValid", String::class.java)

        val result = method.invoke(login, "invalidEmail") as Boolean
        assertFalse("Invalid email pattern should return false", result)
    }

    @Test
    fun emailIsValid_shouldReturnTrue() {
        val login = Login1()
        val method = getPrivateMethod(login, "isEmailValid", String::class.java)

        val result = method.invoke(login, "test@example.com") as Boolean
        assertTrue("Valid email should return true", result)
    }

    @Test
    fun passwordIsTooShort_shouldReturnFalse() {
        val login = Login1()
        val method = getPrivateMethod(login, "isPasswordValid", String::class.java)

        val result = method.invoke(login, "12345") as Boolean
        assertFalse("Password shorter than 7 characters should be invalid", result)
    }

    @Test
    fun passwordIsValid_shouldReturnTrue() {
        val login = Login1()
        val method = getPrivateMethod(login, "isPasswordValid", String::class.java)

        val result = method.invoke(login, "password123") as Boolean
        assertTrue("Password with 7 or more characters should be valid", result)
    }

    // Helper function to access private methods
    private fun getPrivateMethod(instance: Any, methodName: String, vararg parameterTypes: Class<*>): Method {
        val method = instance::class.java.getDeclaredMethod(methodName, *parameterTypes)
        method.isAccessible = true
        return method
    }
}
