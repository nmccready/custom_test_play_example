package scalax.io

import org.specs2.Specification
import scalax.io.JavaConverters._
import scalax.file._
import java.net.URL

class ScalaxIOSpec extends Specification {

  def is =
    args(sequential = true) ^
      "This spec verifies 'Scalax-io' " ^
      p ^
      "'Scala-IO' should " ^
      "Save a file to disk" ! saveFileTest ^
      end

  def saveFileTest = {
    val fileName = "scalaout"
    Path(fileName).delete(true)

    val scalalang = new URL("http://www.scala-lang.org").asInput.bytes
    val scalatools = new URL("http://www.scala-tools.org").asInput.bytes

    Path(fileName).write(scalalang ++ scalatools)

    val input: Input = Resource.fromFile(fileName)

    val test = input.byteArray.toList == (scalalang ++ scalatools).toList
    Path(fileName).delete(true)
    test
  }
}
