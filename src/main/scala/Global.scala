import model.DatabaseSchemifier
import java.sql._

import org.squeryl.{Session, SessionFactory}
import org.squeryl.adapters.MySQLAdapter
import org.squeryl.PrimitiveTypeMode._



case class mysql_config(user: String,
                        pass: String,
                        host: String,
                        name: String,
                        port: Int)


object Global {

  val config = mysql_config("root", "", "localhost", "showcasesqueryl", 3306)
  val dbVendor= "jdbc:mysql://"+config.host+":"+config.port+"/"+config.name+"?user="+config.user+"&password="+config.pass
  val databaseDriver = "com.mysql.jdbc.Driver"
  //  var dbVendor: StandardDBVendor = null
  def databaseConnect=
  {
    Class.forName(databaseDriver)
    SessionFactory.concreteFactory = Some(() =>
      Session.create(
        java.sql.DriverManager.getConnection(dbVendor),
        new MySQLAdapter)
    )
  }

  def databaseCreate=
  {
    val querie = new ShowCaseQueries()
    transaction{
      DatabaseSchemifier.drop
      DatabaseSchemifier.create
      querie.queries()
    }
  }


}