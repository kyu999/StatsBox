package datafactory

class data(x:Seq[Double]) extends Descritive with TimeSeries{
    val raw=x 
    val mean=meanf(x)
	val dv=deviation(x,mean)
    val sd=stdevi(devito2(dv))
    
    lazy val acf=autocorrelation(x)
    
    def ++(component:data)=dataset(x,component.raw)
    
	def summary(x:Seq[Double])={ 
	    Seq("X; "+raw,"mean -> "+mean,"deviation -> "+dv,
	        "standard deviation -> "+sd).foreach(println)
	    mkLine
	}
//	summary(x)
}
object data{
  def apply(x:Seq[Double])=new data(x)
}