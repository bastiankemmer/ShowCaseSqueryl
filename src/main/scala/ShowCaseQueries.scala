
import model._
import model.DatabaseSchemifier._
import org.squeryl.PrimitiveTypeMode._
class ShowCaseQueries {

  def queries(): Unit ={
        printDdl(println(_))
        //First possibility: Delete user from userTable
        val device1 = deviceTable.insert(new Device("NewDevice1", None))//None User

        val user1 = userTable.insert(new User("User1"))

        //User connects
        update(deviceTable)(d => where(d.id === device1.id) set(d.user_id := Some(user1.id)))//User is now User1

        println("Delete User 1")
        //Delete User1
        userTable.deleteWhere(u=> u.id === user1.id)

        //Second possibility: Delete user from userToDevice
        val device2 = userToDevice.rightTable.insert(new Device("NewDevice2", None))

        val user2 = userToDevice.leftTable.insert(new User("User2"))

        update(userToDevice.rightTable)(d => where(d.id === device2.id) set(d.user_id := Some(user2.id)))//User is now User1

        println("Delete")
        userToDevice.leftTable.deleteWhere(u => u.id === user2.id)
  }
}
