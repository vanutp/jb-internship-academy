
import com.intellij.openapi.vcs.ui.FlatSpeedSearchPopup
import com.intellij.remoterobot.RemoteRobot
import com.intellij.remoterobot.fixtures.ComponentFixture
import com.intellij.remoterobot.search.locators.byXpath
import com.intellij.remoterobot.utils.keyboard
import kotlinx.coroutines.delay
import org.junit.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.awt.Point
import java.awt.event.KeyEvent
import java.time.Duration

class HelloWorldActionTest {
    private val remoteRobot = RemoteRobot("http://127.0.0.1:8580")

    @Test
    fun testHelloWorldAction(): Unit = with(remoteRobot) {
        // keyboard.doubleKeyPress is not used because pressKey and releaseKey are swapped there on the second press
        runJs(
            """
                robot.pressKey(${KeyEvent.VK_SHIFT})
                robot.releaseKey(${KeyEvent.VK_SHIFT})
                Thread.sleep(10)
                robot.pressKey(${KeyEvent.VK_SHIFT})
                robot.releaseKey(${KeyEvent.VK_SHIFT})
            """
        )
        find(ComponentFixture::class.java, byXpath("//div[@class='SearchEverywhereUI']"), Duration.ofSeconds(5)).apply {
            find(ComponentFixture::class.java, byXpath("//div[@class='SearchField']")).keyboard {
                enterText("Hello World Action")
            }
            Thread.sleep(5000)
            keyboard {
                enter()
            }
        }
        find(ComponentFixture::class.java, byXpath("//div[@title='🦊' and @class='MyDialog']"), Duration.ofSeconds(5)).apply {
            assert(hasText("Hello World!"))
            find(ComponentFixture::class.java, byXpath("//div[@class='JButton']")).apply {
                assert(hasText("OK"))
                click()
            }
        }
    }
}
