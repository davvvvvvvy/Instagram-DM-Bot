import Main
import Util

fun main () {

    val username = "friendsgramly"
    val password = "Vojko123"

    val session = Util()
    val start = Main(username, password)

    start.findApp()
    start.login()
    start.sendMessage("Hello", "neznamgdjesambio")
    start.quit()

}