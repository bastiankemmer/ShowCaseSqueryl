version       := "0.1"

scalaVersion  := "2.10.0"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

resolvers ++= Seq("snapshots"     at "http://oss.sonatype.org/content/repositories/snapshots",
  "staging"       at "http://oss.sonatype.org/content/repositories/staging",
  "releases"      at "http://oss.sonatype.org/content/repositories/releases"
)

libraryDependencies ++= {
  val akkaV = "2.1.4"
  val sprayV = "1.1.2"
  Seq(
  "org.squeryl" %% "squeryl" % "0.9.5-6",
  "mysql" % "mysql-connector-java" % "5.1.10", // In-process database, useful for development systems
  "ch.qos.logback" % "logback-classic" % "0.9.26" % "compile->default",
  "io.spray"            %   "spray-can"     % sprayV,
  "io.spray"            %   "spray-routing" % sprayV,
  "io.spray"            %   "spray-testkit" % sprayV  % "test",
  "com.typesafe.akka"   %%  "akka-actor"    % akkaV,
  "com.typesafe.akka"   %%  "akka-testkit"  % akkaV   % "test",
  "org.specs2"          %%  "specs2"        % "2.2.3" % "test"
)
}