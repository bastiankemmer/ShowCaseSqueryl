package model

import org.squeryl.PrimitiveTypeMode._
import org.squeryl.{ForeignKeyDeclaration, Schema}

object DatabaseSchemifier extends DatabaseSchema

class DatabaseSchema extends Schema {
  val userTable = table[User]

  val deviceTable = table[Device]
  on(deviceTable)(d => declare(
    d.user_id         is(unique),
    d.uid             is(unique)
  ))
  //OneToOne between User and Device
  val userToDevice = oneToManyRelation(userTable, deviceTable).via((u, d) => u.id === d.user_id)

  //ForeignKey Policy
  override def applyDefaultForeignKeyPolicy(foreignKeyDeclaration: ForeignKeyDeclaration) =
    foreignKeyDeclaration.constrainReference

  userToDevice.foreignKeyDeclaration.constrainReference(onDelete cascade)
}
