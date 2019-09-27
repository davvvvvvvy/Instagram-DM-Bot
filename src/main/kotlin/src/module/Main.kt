import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement

class Main {

    var username : String ?= null
    var password : String ?= null

    constructor(username : String, password : String) {
        this.username = username
        this.password = password
    }

    var driver : AppiumDriver<MobileElement>?= null

    fun findApp() {
        val launch = driver?.launchApp()
    }

    fun login() {
    //  //*[@text='Log In']  Log In button
    //  //*[@id='login_username']  Username input
        //  //*[@id='password']  Password input
    //  //*[@text='Log In']

        try {
            val logIn = driver?.findElementByXPath("//*[@text='Log In']")
            logIn?.click()
        } catch (e : Exception) {
            println(e)
        }

        try {
            val Username = driver?.findElementByXPath("//*[@id='login_username']")
            Username?.sendKeys(this.username)
        } catch (e : Exception) {
            println(e)
        }

        try {
            val Password = driver?.findElementByXPath("//*[@id='password']")
            Password?.sendKeys(this.password)
        } catch (e : Exception) {
            println(e)
        }

        try {
            val b = driver?.findElementByXPath("//*[@text='Log In']")
            b?.click()
        } catch (e : Exception) {
            println(e)
        }


    }

    fun sendMessage(text : String, usernameToSend : String) {
    //  //*[@id='action_bar_inbox_button']
        //  //*[@contentDescription='New Message']

        //  //*[@id='search_edit_text']

        // //*[@id='recipient_typeahead_add']

        //  //*[@class='android.widget.ImageView' and ./parent::*[@id='action_bar_button_action']]

        // //*[@id='row_thread_composer_edittext'] .sendKeys

        //  //*[@text='Send']

        try {
            driver?.findElementByXPath("//*[@id='action_bar_inbox_button']")?.click()
        } catch (e : Exception) {
            println(e)
        }

        try {
            driver?.findElementByXPath("//*[@contentDescription='New Message']")?.click()
        } catch (e : Exception) {
            println(e)
        }

        try {
            driver?.findElementByXPath("//*[@id='search_edit_text']")?.sendKeys(usernameToSend)
        } catch (e : Exception) {
            println(e)
        }

        try {
            driver?.findElementByXPath("//*[@id='recipient_typeahead_add']")?.click()
        } catch (e : Exception) {
            println(e)
        }

        try {
            driver?.findElementByXPath("//*[@class='android.widget.ImageView' and ./parent::*[@id='action_bar_button_action']]")?.click()
        } catch (e : Exception) {
            println(e)
        }

        try {
            driver?.findElementByXPath("//*[@id='row_thread_composer_edittext']")?.sendKeys(text)
        } catch (e : Exception) {
            println(e)
        }

        try {
            driver?.findElementByXPath("//*[@text='Send']")?.click()
        } catch (e : Exception) {
            println(e)
        }

    }

    fun quit() {
        driver?.close()
    }

}