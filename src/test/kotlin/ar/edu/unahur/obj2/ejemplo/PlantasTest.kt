package ar.edu.unahur.obj2.ejemplo

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe


class EspeciesTest : DescribeSpec({
  describe("Probando la Menta") {
    val menta = Menta(2022,1.0)
    val mentita = Menta(2018,0.3)

    val parcelaA = Parcela(4.0 , 4.0, 6)
    val parcelaB = Parcela(2.0,2.0,9)

    parcelaA.plantar(menta)
    parcelaB.plantar(mentita)

    it("Menta con semillas y espaciosa") {
      menta.daSemillas().shouldBeTrue()
      menta.espacio().shouldBe(2.0)
    }
    it("Menta sin semillas y pequeña"){
      mentita.daSemillas().shouldBeFalse()
      mentita.espacio().shouldBe(1.3)
    }
    it("Test: Menta parcela ideal"){
      menta.parcelaIdeal(parcelaA).shouldBeTrue()
    }
    it("Test: Menta parcela no ideal"){
      menta.parcelaIdeal(parcelaB).shouldBeFalse()
    }
  }
  describe("Probando la Soja"){
    val soja = Soja(2008,0.8) // Da semillas
    val sojita = Soja(2007,0.76) // No da semillas por anio
    val sojilenta = Soja(2015,0.9) // no da semillas altura mayor
    val soj = Soja(2011,0.4) // no da semillas altura menor}
    val ultimaSoja = Soja(2015 , 1.1)
    val testEjemplo = Soja(2009,0.6)

    val parcelaA = Parcela(4.0 , 4.0, 8)
    val parcelaB = Parcela(2.0,2.0,6)

    parcelaA.plantar(soja)
    parcelaB.plantar(sojita)

    it("Sojas Test de semillas por anio"){
      soja.daSemillas().shouldBeTrue()
      sojita.daSemillas().shouldBeFalse()
      sojilenta.daSemillas().shouldBeTrue()
      soj.daSemillas().shouldBeFalse()
      ultimaSoja.daSemillas().shouldBeTrue()
    }
    it("Soja Test ejemplo enunciado"){
      testEjemplo.daSemillas().shouldBeFalse()
      testEjemplo.horasDeSolToleradas().shouldBe(8)

    }
    it("Sojas Test espacio"){
      soja.espacio().shouldBe(0.4)
      sojita.espacio().shouldBe(0.38)
      sojilenta.espacio().shouldBe(0.45)
      soj.espacio().shouldBe(0.2)
    }
    it("Test: Soja Parcela ideal"){
      soja.parcelaIdeal(parcelaA).shouldBeTrue()
    }
    it("Test: Soja Parcela no ideal"){
      sojita.parcelaIdeal(parcelaB).shouldBeFalse()
    }
  }
  describe("Test Quinoa"){
    /*
      Da semillas si el año de obtención de la semilla que le dio origen esté entre el 2001 y el 2008 o es fuerte.
      Si ocupa menos de 0.3 m2, entonces tolera 10 horas de sol al día (Es fuerte); si no, corre el valor genérico (No es fuerte).
     */

    val quinoaA = Quinoa(2010, 0.2,0.2) //da semilla por espacio que ocupa
    val quinoaB = Quinoa(2006, 0.5,0.9) // da semilla por año de obtencion
    val quinoaC = Quinoa(2011, 0.4,0.4) //no da semilla por espacio y año de obtencion
    val quinoaD = Quinoa(2000, 0.5,0.3) // no da semilla

    val parcelaA = Parcela(4.0 , 4.0, 8)
    val parcelaB = Parcela(2.0,2.0,6)
    val sojaA = Soja(2015 , 1.1)
    val sojaB = Soja(2009,0.6)
    val sojaC = Soja(2009,1.7)

    parcelaA.plantar(sojaA)
    parcelaA.plantar(sojaB)
    parcelaB.plantar(sojaB)
    parcelaB.plantar(sojaC)

    it("Test: Quinoa da semillas "){
      quinoaA.daSemillas().shouldBeTrue()
      quinoaB.daSemillas().shouldBeTrue()
    }
    it("Test: Quinoa no da semillas"){
      quinoaC.daSemillas().shouldBeFalse()
      quinoaD.daSemillas().shouldBeFalse()
    }
    it("Test: Quinoa horas de sol toleradas"){
      quinoaA.horasDeSolToleradas().shouldBe(10)
      quinoaB.horasDeSolToleradas().shouldBe(7)
      quinoaC.horasDeSolToleradas().shouldBe(7)
      quinoaD.horasDeSolToleradas().shouldBe(7)
    }
    it("Test: Quinoa es fuerte"){
      quinoaA.esFuerte().shouldBeTrue()
    }
    it("Test: Quinoa no es fuerte"){
      quinoaB.esFuerte().shouldBeFalse()
      quinoaC.esFuerte().shouldBeFalse()
      quinoaD.esFuerte().shouldBeFalse()
    }
    it("Test: Quinoa parcela ideal"){
      quinoaA.parcelaIdeal(parcelaA).shouldBeTrue()
      quinoaB.parcelaIdeal(parcelaA).shouldBeTrue()
      quinoaC.parcelaIdeal(parcelaA).shouldBeTrue()
      quinoaD.parcelaIdeal(parcelaA).shouldBeTrue()
    }
    it("Test: Quinoa parcela no ideal"){
      quinoaA.parcelaIdeal(parcelaB).shouldBeFalse()
      quinoaB.parcelaIdeal(parcelaB).shouldBeFalse()
      quinoaC.parcelaIdeal(parcelaB).shouldBeFalse()
      quinoaD.parcelaIdeal(parcelaB).shouldBeFalse()
    }
  }
  describe("Soja trangenica"){
    val sTransgenicaA = SojaTrangenica(2001,1.2)
    val sTransgenicaB = SojaTrangenica(2010,0.4)
    val sTransgenicaC = SojaTrangenica(2010,0.8)

    val parcelaA = Parcela(2.5 , 2.15, 8)
    val parcelaB = Parcela(1.72,2.0,6)

    it("Test: Soja trangenica es fuerte"){
      sTransgenicaA.esFuerte().shouldBeTrue()
    }
    it("Test: Soja trangenica no es fuerte"){
      sTransgenicaB.esFuerte().shouldBeFalse()
    }
    it("Test: Soja trangenica no da semilla"){
      sTransgenicaA.daSemillas().shouldBeFalse()
      sTransgenicaB.daSemillas().shouldBeFalse()
      sTransgenicaC.daSemillas().shouldBeFalse()
    }
    it("Test: Soja transgenica parcela ideal"){
      sTransgenicaA.parcelaIdeal(parcelaA).shouldBeTrue()
      sTransgenicaB.parcelaIdeal(parcelaA).shouldBeTrue()
      sTransgenicaC.parcelaIdeal(parcelaA).shouldBeTrue()
    }
    it("Test: Soja transgenica parcela no ideal"){
      sTransgenicaA.parcelaIdeal(parcelaB).shouldBeFalse()
      sTransgenicaB.parcelaIdeal(parcelaB).shouldBeFalse()
      sTransgenicaC.parcelaIdeal(parcelaB).shouldBeFalse()
    }
  }
  describe("Test Peperina"){
    val peperinaA = Peperina(2003,1.0)
    val peperinaB = Peperina(2007,0.1)
    it("Test: Peperina da semilla"){
      peperinaA.daSemillas().shouldBeTrue()
    }
    it("Test: Peperina no da semilla"){
      peperinaB.daSemillas().shouldBeFalse()
    }
    it("Test: Peperina espacio que ocupa"){
      peperinaA.espacio().shouldBe(4.0)
    }

  }
})
