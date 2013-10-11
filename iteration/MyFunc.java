package iteration;
class MyFunc implements Function2<Integer,String,String>{



	@Override
	public String apply(Integer t, String u) {
		// TODO Auto-generated method stub
		
	 //Long l = new Long(1);
	 String ret = u+t + "-";
	 System.out.println("ret= "+ret);
	 return ret;
	}



	
}
