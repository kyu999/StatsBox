package datastore

object DataTes extends App{
  
  val x=Stream(35.0,20,63,59,14,44,42,25,73,38,56,69,28,46)
  val y=Stream(47.0,62,36,40,58,46,50,57,38,44,40,32,54,48)
  val data=new Dataset(x,y)
  data.summary
  println("labelX: "+data.labelX+" , labelY : "+data.labelY)
  println("ranked : "+data.labelX.zip(data.labelY))
  data.difsqured(data.ranked).foreach(println)
  val data3=new Data(x)
  
}