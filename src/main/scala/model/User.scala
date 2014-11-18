package model

import org.squeryl.KeyedEntity

/**
 * Created by B001 on 18.11.2014.
 */
class User (val name: String)extends KeyedEntity[Long] {
  val id: Long = 0L

  def device: Option[Device] = DatabaseSchemifier.userToDevice.left(this).headOption
}
