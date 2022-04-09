package ar.edu.unahur.obj2.ejemplo

import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class ParcelasTest : DescribeSpec({
    describe("Test de Parcela"){
        val parcela = Parcela(20.0,1.0,10)
        val parcelaChica = Parcela(15.0,1.0,5)
        val soja = Soja(2007,1.0)
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
    }
})