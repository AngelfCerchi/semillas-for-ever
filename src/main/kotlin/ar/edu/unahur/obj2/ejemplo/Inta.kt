package ar.edu.unahur.obj2.ejemplo

object Inta{
    val parcelasAsociadas : MutableCollection<Parcela> = mutableListOf()

    fun agregarParcela(p : Parcela){
        this.parcelasAsociadas.add(p)
    }

    fun promedioPlantas(): Double =  ((this.parcelasAsociadas.sumBy { p-> p.plantadas.size} / this.parcelasAsociadas.size).toDouble())

    fun listaParcelasMasDeCuatro() =  this.parcelasAsociadas.filter { p -> p.plantadas.size > 4}

    fun mayorPorcentajePlantasBien(): Parcela? = this.listaParcelasMasDeCuatro().maxByOrNull { p -> p.porcentajeBienAsociada() }

}
