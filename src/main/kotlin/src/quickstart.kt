import Main
import Util

fun main () {

    val username = ""
    val password = ""

    val session = Util()
    val start = Main(username, password)

    start.findApp()
    start.login()
    start.sendMessage("text", "username")
    start.quit()

}