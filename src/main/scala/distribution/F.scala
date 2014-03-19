package distribution

import scala.math._

object F {
  
	def table(va:Int,ve:Int,fval:Double)={
	  var vertical=closer(ve)
	  var horizontal=closer(va)-1
	  
	  println("va : "+va)
	  println("ve : "+ve)
	  

	
	  println("vertical : "+vertical)
	  println("horizontal : "+horizontal)
	 
	  
	  var criteria=0.0
	  if(horizontal<=10) criteria=lessreference(vertical)(horizontal)
	  else criteria=morereference(vertical)(horizontal)
	  
	  println("criteria : "+criteria)	  
//	  println("fval : "+fval)
	  
	  if(criteria>fval) (true,fval)
	  else (false,fval)
	  
	}
	
	val index=Array(1,2,3,4,5,6,7,8,9,10,11,12,15,20,30,50,100,200,500,501)
	
	//input must be bigger than 1
	def closer(input:Double)={
	  
	  var look=0
	  var end=index.length-1
	  
	  var previous=false
	  var preval=0
	  var current=false
	  var curval=0
	  
	  var ok=true
	  
	  while(look<end && ok){
	    
	    preval=index(look)
	    curval=index(look+1)
	    
	    if(preval<=input) previous=true
	    if(input<=curval) current=true
	    
	    if(previous && current) ok=false
	    
	    look=look+1
	    
	  }
	  
	  if(abs(preval-input)>abs(curval-input)) curval
	  else preval
	  
	}
	
	val lessreference=
	  Map(
	  //m<=10 cases
	    1->Vector(161.45, 199.5, 215.71, 224.58, 230.16, 233.99, 236.77, 238.88, 240.54, 241.88), 
	    2->Vector(18.513, 19.0, 19.164, 19.247, 19.296, 19.33, 19.353, 19.371, 19.385, 19.396), 
	    3->Vector(10.128, 9.5521, 9.2766, 9.1172, 9.0135, 8.9406, 8.8867, 8.8452, 8.8123, 8.7855), 
	    4->Vector(7.7086, 6.9443, 6.5914, 6.3882, 6.2561, 6.1631, 6.0942, 6.041, 5.9988, 5.9644), 
	    5->Vector(6.6079, 5.7861, 5.4095, 5.1922, 5.0503, 4.9503, 4.8759, 4.8183, 4.7725, 4.7351), 
	    6->Vector(5.9874, 5.1433, 4.7571, 4.5337, 4.3874, 4.2839, 4.2067, 4.1468, 4.099, 4.06), 
	    7->Vector(5.5914, 4.7374, 4.3468, 4.1203, 3.9715, 3.866, 3.787, 3.7257, 3.6767, 3.6365), 
	    8->Vector(5.3177, 4.459, 4.0662, 3.8379, 3.6875, 3.5806, 3.5005, 3.4381, 3.3881, 3.3472), 
	    9->Vector(5.1174, 4.2565, 3.8625, 3.6331, 3.4817, 3.3738, 3.2927, 3.2296, 3.1789, 3.1373), 
	    10->Vector(4.9646, 4.1028, 3.7083, 3.478, 3.3258, 3.2172, 3.1355, 3.0717, 3.0204, 2.9782), 
	    11->Vector(4.8443, 3.9823, 3.5874, 3.3567, 3.2039, 3.0946, 3.0123, 2.948, 2.8962, 2.8536), 
	    12->Vector(4.7472, 3.8853, 3.4903, 3.2592, 3.1059, 2.9961, 2.9134, 2.8486, 2.7964, 2.7534), 
	    15->Vector(4.5431, 3.6823, 3.2874, 3.0556, 2.9013, 2.7905, 2.7066, 2.6408, 2.5876, 2.5437), 
	    20->Vector(4.3512, 3.4928, 3.0984, 2.8661, 2.7109, 2.599, 2.514, 2.4471, 2.3928, 2.3479), 
	    30->Vector(4.1709, 3.3158, 2.9223, 2.6896, 2.5336, 2.4205, 2.3343, 2.2662, 2.2107, 2.1646), 
	    50->Vector(4.0343, 3.1826, 2.79, 2.5572, 2.4004, 2.2864, 2.1992, 2.1299, 2.0734, 2.0261), 
	    100->Vector(3.9361, 3.0873, 2.6955, 2.4626, 2.3053, 2.1906, 2.1025, 2.0323, 1.9748, 1.9267), 
	    200->Vector(3.8884, 3.0411, 2.6498, 2.4168, 2.2592, 2.1441, 2.0556, 1.9849, 1.9269, 1.8783), 
	    500->Vector(3.8601, 3.0138, 2.6227, 2.3898, 2.232, 2.1167, 2.0279, 1.9569, 1.8986, 1.8496), 
	    501->Vector(3.8415, 2.9957, 2.6049, 2.3719, 2.2141, 2.0986, 2.0096, 1.9384, 1.8799, 1.8307)
	    )
	//m > 10 cases 
	    
	  
	 val morereference=
	   Map(
	    1->Vector(242.98, 243.91, 245.95, 248.01, 250.1, 251.77, 253.04, 253.68, 254.06, 254.31), 
	    2->Vector(19.405, 19.413, 19.429, 19.446, 19.462, 19.476, 19.486, 19.491, 19.494, 19.496), 
	    3->Vector(8.7633, 8.7446, 8.7029, 8.6602, 8.6166, 8.581, 8.5539, 8.5402, 8.532, 8.5264), 
	    4->Vector(5.9358, 5.9117, 5.8578, 5.8025, 5.7459, 5.6995, 5.6641, 5.6461, 5.6353, 5.6281), 
	    5->Vector(4.704, 4.6777, 4.6188, 4.5581, 4.4957, 4.4444, 4.4051, 4.3851, 4.3731, 4.365), 
	    6->Vector(4.0274, 3.9999, 3.9381, 3.8742, 3.8082, 3.7537, 3.7117, 3.6904, 3.6775, 3.6689), 
	    7->Vector(3.603, 3.5747, 3.5107, 3.4445, 3.3758, 3.3189, 3.2749, 3.2525, 3.2389, 3.2298), 
	    8->Vector(3.313, 3.2839, 3.2184, 3.1503, 3.0794, 3.0204, 2.9747, 2.9513, 2.9371, 2.9276), 
	    9->Vector(3.1025, 3.0729, 3.0061, 2.9365, 2.8637, 2.8028, 2.7556, 2.7313, 2.7166, 2.7067), 
	    10->Vector(2.943, 2.913, 2.845, 2.774, 2.6996, 2.6371, 2.5884, 2.5634, 2.5481, 2.5379), 
	    11->Vector(2.8179, 2.7876, 2.7186, 2.6464, 2.5705, 2.5066, 2.4566, 2.4308, 2.4151, 2.4045), 
	    12->Vector(2.7173, 2.6866, 2.6169, 2.5436, 2.4663, 2.401, 2.3498, 2.3233, 2.3071, 2.2962), 
	    15->Vector(2.5068, 2.4753, 2.4034, 2.3275, 2.2468, 2.178, 2.1234, 2.095, 2.0776, 2.0658), 
	    20->Vector(2.31, 2.2776, 2.2033, 2.1242, 2.0391, 1.9656, 1.9066, 1.8755, 1.8562, 1.8432), 
	    30->Vector(2.1256, 2.0921, 2.0148, 1.9317, 1.8409, 1.7609, 1.695, 1.6597, 1.6375, 1.6223), 
	    50->Vector(1.9861, 1.9515, 1.8714, 1.7841, 1.6872, 1.5995, 1.5249, 1.4835, 1.4569, 1.4383), 
	    100->Vector(1.8857, 1.8503, 1.7675, 1.6764, 1.5733, 1.4772, 1.3917, 1.3416, 1.3079, 1.2832), 
	    200->Vector(1.8368, 1.8008, 1.7166, 1.6233, 1.5164, 1.4146, 1.3206, 1.2626, 1.2211, 1.1885), 
	    500->Vector(1.8078, 1.7715, 1.6864, 1.5916, 1.4821, 1.3762, 1.2753, 1.2096, 1.1587, 1.1132), 
	    501->Vector(1.7886, 1.7522, 1.6664, 1.5705, 1.4591, 1.3501, 1.2434, 1.17, 1.1063, 1.0)
	    )
}

object Ftest extends App{
	println(F.closer(503))
	println(F.table(4,11,8))
  
}