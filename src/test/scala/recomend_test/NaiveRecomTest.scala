package recomend_test

import org.scalatest.FunSuite	
import recommendation.NaiveRecom 

class NaiveRecomTest extends FunSuite{
  
  val data=NaiveRecom.data
  val topmat=NaiveRecom.topMatches _ 
  val pe=NaiveRecom.pearsim _ 
  val eu=NaiveRecom.euclisim _ 
  val getrecom=NaiveRecom.getRecommendations _
  val trans=NaiveRecom.transform _ 
//  val transdata=trans(data)
  
  test("topMatch"){
  
//  assert(topmat(data, "Toby", 3, pe )===List((0.9912407071619301,"Lisa Rose"), (0.924473451641905,"Mick LaSalle"), (0.8934051474415642,"Claudia Puig")),"pearson's similarity fail")
//  assert(topmat(data, "Toby", 3, eu )===List((0.4,"Mick LaSalle"), (0.3567891723253309,"Claudia Puig"), (0.3483314773547883,"Lisa Rose")),"euclidean's similarity fail")
  
  }
  
  test("getRecommendations"){
//    getrecom(data,"Toby",pe)
  }
  test("trans"){
//  (0 to 100000).par.map(a=>(0 to 10000).map(b=>a-b).reduce((a,b)=>a+b))
//  par takes 60% faster than ordinary collection => par : ord = 3 : 5 
 
//    println("this should be correlation : "+topmat(transdata,"Just My Luck",5,eu))
    
  }
  
  test("type parameter"){
  	val exsuperString:ExSuper[Any]=new ExSuper[String]("get String as type parameter")
  	exsuperString.typeName
  	//AnyRefのサブクラス以降なら可。StringはAnyRefのサブクラスに当たる　
  	val ExItoD:IntToDouble[Double]=new IntToDouble[Double](1500)
  	ExItoD.typeName
  }
  
}

class IntToDouble[Type](para:Type){
	def typeName=println(para)
}

class ExSuper[+Type](para:Type){
	def typeName=println(para)
}