package ar.edu.unahur.obj2.ejemplo


interface ParcelaInterfaz {
    val ancho: Double
    val largo: Double
    val horasSolRecibidas : Int
    val plantadas: MutableCollection<PlantaInterfaz>

    fun superficie(): Double
    fun cantidadMaxima(): Int
    fun tieneComplicaciones(): Boolean
    fun plantar(p:PlantaInterfaz)
    fun sePuedePlantar() = this.cantidadMaxima() > this.plantadas.size

}

