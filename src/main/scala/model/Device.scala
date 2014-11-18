package model

import org.squeryl.KeyedEntity
import org.squeryl.PrimitiveTypeMode._
class Device (val uid: String, val user_id: Option[Long])extends KeyedEntity[Long] {
    val id: Long = 0L

    def user: Option[User] = DatabaseSchemifier.userTable.lookup(user_id.get)
}
