package ar.edu.unahur.obj2.ejemplo

abstract class Parcela(
    val ancho: Double,
    val largo: Double,
    val horasSolRecibidas: Int,
    val plantadas: MutableCollection<Planta> = mutableListOf()
){


    fun superficie(): Double {
        return ancho*largo
    }
    fun cantidadMaxima(): Int {
        return if(this.ancho > largo) (this.superficie()/5).toInt() else ((superficie()/3) + largo).toInt()
    }

    fun tieneComplicaciones(): Boolean {
        return this.plantadas.all{ p: Planta -> p.horasDeSolToleradas() < this.horasSolRecibidas}
    }
    fun sePuedePlantar() = this.cantidadMaxima() > this.plantadas.size

    fun plantar(p: Planta){
        if (this.sePuedePlantar()){
            this.plantadas.add(p)
        }else{
            error("No se puede plantar")
        }
    }
    abstract fun seAsociaBien(planta: Planta) : Boolean
    abstract fun porcentajeBienAsociada(): Double


}

open class ParcelasEcologicas (
    ancho: Double,
    largo: Double,
    horasSolRecibidas: Int,
): Parcela(ancho, largo, horasSolRecibidas) {

    override fun seAsociaBien(planta: Planta) = !this.tieneComplicaciones() and planta.parcelaIdeal(this)
    override fun porcentajeBienAsociada(): Double =  ((this.plantadas.count{ p -> this.seAsociaBien(p)} * 100) / this.plantadas.size).toDouble()


}

class ParcelasIndustriales (
    ancho: Double,
    largo: Double,
    horasSolRecibidas: Int,
  ): Parcela(ancho, largo, horasSolRecibidas) {

    override fun seAsociaBien(planta: Planta) = (this.cantidadMaxima() <= 2) and planta.esFuerte()
    override fun porcentajeBienAsociada(): Double =  ((this.plantadas.count{ p -> this.seAsociaBien(p)} * 100) / this.plantadas.size).toDouble()

}


