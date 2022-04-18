package ar.edu.unahur.obj2.ejemplo

import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class ParcelasTest : DescribeSpec({
    describe("Test de Parcela"){
        /*PARCELAS*/
        val parcela = Parcela(20.0,1.0,10)
        val parcelaChica = Parcela(15.0,1.0,5)
        val parcelaEco = ParcelasEcologicas(20.0,1.0,10)
        val parcelaInd = ParcelasIndustriales(2.5 , 2.15, 8)
        val parcelaInd2 = ParcelasIndustriales(2.5 , 2.15, 8)

        /*PLANTAS*/
        val soja = Soja(2007,1.0)
        val sTrangenica = SojaTrangenica(2007,1.2)
        val menta = Menta(2006, 0.4)

        parcelaEco.plantar(soja)
        parcelaEco.plantar(sTrangenica)
        parcelaInd.plantar(sTrangenica)
        parcelaInd2.plantar(menta)

        it("Parcela Chica control superficie"){
            parcelaChica.superficie().shouldBe(15.0)
        }
        it("Parcela chica control cantidad Maxima"){
            parcelaChica.cantidadMaxima().shouldBe(3)
        }
        it("Superficie de Parcela"){
            parcela.superficie().shouldBe(20.0)
            parcela.superficie().shouldNotBe(3.0)
        }
        it("Cantidad maxima tolerada"){
            parcela.cantidadMaxima().shouldBe(4)
            parcela.cantidadMaxima().shouldNotBe(3)
        }
        it("Plantando cuatro plantas de Sojas de 1 metro con 12 hs de sol"){
            parcela.plantar(soja)
            parcela.plantar(soja)
            parcela.plantar(soja)
            parcela.plantar(soja)

            parcela.tieneComplicaciones().shouldBeFalse()
        }
        it("No puedo plantar mas de cuatro plantas"){
            parcela.plantar(soja)
            parcela.plantar(soja)
            parcela.plantar(soja)
            parcela.plantar(soja)
            shouldThrowAny {
                parcela.plantar(soja)
            }
        }
        it("Test parcelas ecologicas no se asocia bien con la soja y soja transgenica"){
            parcelaEco.seAsociaBien(soja).shouldBeFalse()
            parcelaEco.seAsociaBien(sTrangenica).shouldBeFalse()
        }
        it("Test parcela ecologica se asocia bien con la menta"){
            parcelaEco.seAsociaBien(menta).shouldBeTrue()
        }
        it("Test parcela industrial se asocia bien con la soja transgenica"){
            parcelaInd.seAsociaBien(sTrangenica).shouldBeTrue()
        }
        it("Test parcela industrial no se asocia bien con la menta"){
            parcelaInd2.seAsociaBien(menta).shouldBeFalse()
        }

    }

})