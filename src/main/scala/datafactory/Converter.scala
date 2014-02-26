package datafactory

object Converter {
	implicit def toda(in:Seq[Double]):ConvertData=new ConvertData(in)
	implicit def tods(in:Seq[Seq[Double]]):ConvertDataset=new ConvertDataset(in)
}
class ConvertData(in:Seq[Double]){
  def toda=data(in)
}
class ConvertDataset(in:Seq[Seq[Double]]){
  def tods=new dataset(in.map(_.map(_.toDouble)))
}
//  def tods=new dataset(in.map(_.map(_.toDouble)))

/*暗黙の型変換用オブジェ＆クラス
  Seqに本来ないメソッドtoda,todsが呼び出される
  ->暗黙の型変換
  ->Converter objectのtodaメソッドが呼び出される
  ->ConvertDataインスタンス作成
  ->ConvertDataのtodaメソッドが呼び出される
  ※使用するにはConverterオブジェクトをimportするだけ。ぶっちゃけコンパニオンオブジェクトを使用して
  newなしでdata,datasetインスタンス作成できるからあとは好みの問題。
  ちなみにConvertDataseクラスのtodsメソッドでdatasetのインスタンス作成にnewを使っているのは引数が可変長引数の関係で
  マッチしないから直接datasetクラスを作成している
  */