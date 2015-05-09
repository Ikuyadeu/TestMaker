package ikuyadeu;

abstract class AbstractTest {
	protected String problem="";
	protected String answer="";
	protected String operator;
	protected int digit1;
	protected int digit2;
	protected int floutnum;
	protected boolean amari;
	
	public abstract void makeTest();//問題の作成
	public String getProblem(){
		return problem;
	}
	public  String getAnswer(){
		return answer;
	}
}
