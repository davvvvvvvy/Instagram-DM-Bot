import io.appium.java_client.AppiumDriver
import io.appium.java_client.remote.MobileCapabilityType
import org.openqa.selenium.remote.DesiredCapabilities
import java.net.URL
import java.nio.file.Paths
import io.appium.java_client.android.AndroidDriver

import OS
import io.appium.java_client.MobileElement
import java.util.concurrent.TimeUnit
import org.aspectj.lang.annotation.Before

class Util {

    var os : OS = OS.ANDROID
    var driver : AppiumDriver<MobileElement> ?= null

    init {

        os = OS.valueOf(System.getProperty("platform", OS.ANDROID.name))

        val capabilities = DesiredCapabilities()
        val serverAddress = URL("http://localhost:4723/wd/hub")
        val userDir = System.getProperty("user.dir" + "\\app\\instagram.apk")

        capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.13.0")
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android emulator")
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android")
        capabilities.setCapability(MobileCapabilityType.APP, userDir)
        capabilities.setCapability(MobileCapabilityType.APPLICATION_NAME, "Instagram")

        driver = AndroidDriver(serverAddress, capabilities)

        driver?.let {
            it.manage()?.timeouts()?.implicitlyWait(30, TimeUnit.SECONDS)
        }

    }

}