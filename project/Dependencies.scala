import sbt._

object Dependencies {

  val luajc = {
    val `BCEL` = "6.5.0"

    List(
      "org.apache.bcel" % "bcel" % `BCEL`
    )
  }

  val overrides = {
    val `JUNIT` = "4.13.2"

    List(
      "junit" % "junit" % `JUNIT`
    )
  }

  val rules = {
    val `ORGANIZE-IMPORTS` = "0.5.0"

    List(
      "com.github.liancheng" %% "organize-imports" % `ORGANIZE-IMPORTS`
    )
  }

  val tests = {
    val `JUNIT`             = "4.13.2"
    val `JUNIT-INTERFACE`   = "0.11"
    val `JUPITER`           = "5.7.0"
    val `JUPITER-INTERFACE` = "0.9.0"
    val `SCALATEST`         = "3.2.9"

    List(
      "junit"             % "junit"             % `JUNIT`             % Test,
      "com.novocode"      % "junit-interface"   % `JUNIT-INTERFACE`   % Test,
      "org.junit.jupiter" % "junit-jupiter"     % `JUPITER`           % Test,
      "net.aichler"       % "jupiter-interface" % `JUPITER-INTERFACE` % Test,
      "org.scalatest"    %% "scalatest"         % `SCALATEST`         % Test
    )
  }
}
